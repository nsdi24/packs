local mg      = require "moongen"
local device  = require "device"
local memory  = require "memory"
local stats   = require "stats"
local log     = require "log"
local pcap    = require "pcap"
local limiter = require "software-ratecontrol"
local timer  = require "timer"

function configure(parser)
        -- general configs
        parser:argument("dev", "Device to use."):default(1):convert(tonumber)
        local args = parser:parse()
        return args
end

function master(args)
        -- we set 5 queues to the interface
        local dev = device.config{port = args.dev, txQueues = 5}
	device.waitForLinks()

        -- we generate 4 UDP flows with increasing priority
        local packetSize = 1200

        -- The attack lasts for RUN_TIME = 80 seconds (defined later)
        mg.startTask("launch_udp_flow", dev:getTxQueue(1), packetSize, "1.1.1.1", 4, 70)
        stats.startStatsTask{txDevices = {dev}}
        mg.sleepMillis(10000)
        mg.startTask("launch_udp_flow", dev:getTxQueue(2), packetSize, "2.2.2.2", 3, 50)
        mg.sleepMillis(10000)
        mg.startTask("launch_udp_flow", dev:getTxQueue(3), packetSize, "3.3.3.3", 2, 30)
        mg.sleepMillis(10000)
        mg.startTask("launch_udp_flow", dev:getTxQueue(4), packetSize, "4.4.4.4", 1, 10)
        mg.sleepMillis(70000)

        -- monitor progress
        mg.stop()
        mg.waitForTasks()
end

function launch_udp_flow(queue, size, ip, rank, duration)
        
        -- attack packet configuration
        local DST_MAC           = "3c:fd:fe:b4:98:91" -- resolved via ARP on GW_IP or DST_IP, can be overriden with a string here
        local SRC_IP            = "10.0.0.50"
        local DST_IP            = ip
        local SRC_PORT          = 111
        local DST_PORT          = 222
        local RANK              = rank

        local mempool = memory.createMemPool(function(buf)
                buf:getUdpPacket():fill{ 
                        ethSrc = queue, -- get the src mac from the device
                        ethDst = DST_MAC,
                        ip4Src = SRC_IP,
                        ip4Dst = DST_IP,
                        ip4TOS = RANK,
                        ipv4Length = 0,
                        ip4TTL = 250,
                        -- ipProtocol
                        ip4ID  = 0,
                        udpSrc = SRC_PORT,
                        udpDst = DST_PORT,
                        pktLength = size -- this sets all length headers fields in all used protocols
                        -- udpLength
                        -- udpChecksum 
                        -- payload will be initialized to 0x00 as new memory pools are initially empty
                }
        end)

        local bufs = mempool:bufArray() -- a buf array is essentially a very thing wrapper around a rte_mbuf*[], i.e. an array of pointers to packet buffers
        RUN_TIME = duration -- seconds
	local runtime = timer:new(RUN_TIME)
        while mg.running() and runtime:running() do -- check if Ctrl+c was pressed
                -- this actually allocates some buffers from the mempool the array is associated with
		-- this has to be repeated for each send because sending is asynchronous, we cannot reuse the old buffers here
                bufs:alloc(size)
                
                -- UDP checksums are optional, so using just IPv4 checksums would be sufficient here
                -- UDP checksum offloading is comparatively slow: NICs typically do not support calculating the pseudo-header checksum so this is done in SW
                bufs:offloadUdpChecksums()
                -- send out all packets and frees old bufs that have been sent
                queue:send(bufs)
                -- Rate limiting
                --mg.sleepMicros(58) -- tunned such that each attack sends at 10Gbps with framing
        end
end