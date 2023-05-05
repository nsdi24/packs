# General settings
dev = 0
port = 144

# Queue identifiers
queue0 = 0
queue1 = 1
queue2 = 2
queue3 = 3
queue4 = 4
queue5 = 5
queue6 = 6
queue7 = 7

# Get the pipe number corresponding to the port
pipe = port >> 7

# Get the Port Group ID
entry = bfrt.tf2.tm.port.cfg.get(port, print_ents=False)
pg_id = entry.data[b'pg_id']

# Get the physical number of the queue that corresponds to the desired queue_ids
pg_queue0 = entry.data[b'egress_qid_queues'][queue0]
pg_queue1 = entry.data[b'egress_qid_queues'][queue1]
pg_queue2 = entry.data[b'egress_qid_queues'][queue2]
pg_queue3 = entry.data[b'egress_qid_queues'][queue3]
pg_queue4 = entry.data[b'egress_qid_queues'][queue4]
pg_queue5 = entry.data[b'egress_qid_queues'][queue5]
pg_queue6 = entry.data[b'egress_qid_queues'][queue6]
pg_queue7 = entry.data[b'egress_qid_queues'][queue7]

print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue0, pipe, pg_id, pg_queue0))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue1, pipe, pg_id, pg_queue1))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue2, pipe, pg_id, pg_queue2))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue3, pipe, pg_id, pg_queue3))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue4, pipe, pg_id, pg_queue4))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue5, pipe, pg_id, pg_queue5))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue6, pipe, pg_id, pg_queue6))
print('DEV_PORT: {}  QueueID: {}  --> Pipe: {}  PG_ID: {} PG_QUEUE: {}'.format(port, queue7, pipe, pg_id, pg_queue7))

# Set the queue scheduling parameters 
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue0, max_priority=0)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue1, max_priority=1)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue2, max_priority=2)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue3, max_priority=3)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue4, max_priority=4)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue5, max_priority=5)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue6, max_priority=6)
bfrt.tf2.tm.queue.sched_cfg.mod(pipe=pipe, pg_id=pg_id, pg_queue=pg_queue7, max_priority=7)

# Set port shaping
bfrt.tf2.tm.port.sched_cfg.mod(dev_port=port, max_rate_enable=True)
bfrt.tf2.tm.port.sched_shaping.mod(dev_port=port, unit='BPS', max_rate=10000000, max_burst_size=100000)
