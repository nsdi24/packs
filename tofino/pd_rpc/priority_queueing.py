# General settings
a_dev = 0
a_port = 144

# Queue identifiers
a_queue0 = 0
a_queue1 = 1
a_queue2 = 2
a_queue3 = 3
a_queue4 = 4
a_queue5 = 5
a_queue6 = 6
a_queue7 = 7

# Obtaining and printing the default configuration of port a_port
a_mapping_default = tm.thrift.tm_get_port_q_mapping(a_dev, a_port)
print('Default configuration: {}'.format(a_mapping_default))

# Setting 8 priority queues (higher value means higher priority)
a_qmap = tm.q_map_t(0,1,2,3,4,5,6,7)
a_numqueues = 8
tm.thrift.tm_set_port_q_mapping(a_dev, a_port, a_numqueues, a_qmap)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue0, 0)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue1, 1)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue2, 2)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue3, 3)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue4, 4)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue5, 5)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue6, 6)
tm.thrift.tm_set_q_sched_priority(a_dev, a_port, a_queue7, 7)

# Obtaining and printing the updated configuration
a_mapping_new = tm.thrift.tm_get_port_q_mapping(a_dev,a_port)
print ('Updated configuration: {}'.format(a_mapping_new))

tm.thrift.tm_enable_port_shaping(a_dev, a_port)
tm.thrift.tm_set_port_shaping_rate(a_dev, a_port, False, 100000, 10000000) #high burst rate is important, otherwise we have losses