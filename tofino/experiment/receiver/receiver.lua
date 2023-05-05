local lm     = require "libmoon"
local device = require "device"
local memory = require "memory"
local stats  = require "stats"
local eth    = require "proto.ethernet"
local log    = require "log"
local pcap   = require "pcap"
local pf     = require "pf"

function configure(parser)
	parser:argument("dev", "Device to use."):args(1):convert(tonumber)
	parser:argument("scheduler", "Scheduler used in the tofino switch."):args(1)
	parser:option("-t --threads", "Number of threads."):convert(tonumber):default(1)
    local args = parser:parse()
end

function master(args)
	local dev = device.config{port = args.dev, rxQueues = args.threads, rssQueues = args.threads, dropEnable = false, rxDescs =  4096}
    device.waitForLinks()
	for i = 1, args.threads do
		lm.startTask("dumper", dev:getRxQueue(i - 1), args, i)
	end
	lm.waitForTasks()
end

function dumper(queue, args, threadId)
	-- default: show everything
	local filter1 = "dst host 1.1.1.1" and pf.compile_filter("dst host 1.1.1.1") or function() return true end
	local filter2 = "dst host 2.2.2.2" and pf.compile_filter("dst host 2.2.2.2") or function() return true end
	local filter3 = "dst host 3.3.3.3" and pf.compile_filter("dst host 3.3.3.3") or function() return true end
	local filter4 = "dst host 4.4.4.4" and pf.compile_filter("dst host 4.4.4.4") or function() return true end

    -- we create the packet counters (directly logged to output files in csv format)
    local captureCtr, flow1Ctr, flow2Ctr, flow3Ctr, flow4Ctr
    flow1Ctr = stats:newPktRxCounter("Capture flow 1", "CSV", "run/results/" .. args.scheduler .. "_flow1_throughput.dat")
    flow2Ctr = stats:newPktRxCounter("Capture flow 2", "CSV", "run/results/" .. args.scheduler .. "_flow2_throughput.dat")
    flow3Ctr = stats:newPktRxCounter("Capture flow 3", "CSV", "run/results/" .. args.scheduler .. "_flow3_throughput.dat")
	flow4Ctr = stats:newPktRxCounter("Capture flow 4", "CSV", "run/results/" .. args.scheduler .. "_flow4_throughput.dat")

	local bufs = memory.bufArray()
	while lm.running() do
		local rx = queue:tryRecv(bufs, 100)
		local batchTime = lm.getTime()
		for i = 1, rx do
            local buf = bufs[i]

            -- We now compute the individual throughputs
			if filter1(buf:getBytes(), buf:getSize()) then
				flow1Ctr:countPacket(buf)
			end 

			if filter2(buf:getBytes(), buf:getSize()) then
				flow2Ctr:countPacket(buf)
			end

			if filter3(buf:getBytes(), buf:getSize()) then
				flow3Ctr:countPacket(buf)
			end
			
			if filter4(buf:getBytes(), buf:getSize()) then
				flow4Ctr:countPacket(buf)
			end

			buf:free()
		end	

        flow1Ctr:update()
		flow2Ctr:update()
		flow3Ctr:update()
		flow4Ctr:update()
    end

    -- We close the counters
	flow1Ctr:finalize()
	flow2Ctr:finalize()
	flow3Ctr:finalize()
	flow4Ctr:finalize()
    log:info("Flushing buffers, this can take a while...")

end