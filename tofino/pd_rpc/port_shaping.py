tm.thrift.tm_enable_port_shaping(0,144) # ID 140 is port 2/0
tm.thrift.tm_set_port_shaping_rate(0,144,False,100000,10000000) #high burst rate is important, otherwise we have losses
