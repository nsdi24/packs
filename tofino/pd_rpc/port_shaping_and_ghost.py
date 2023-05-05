tm.thrift.tm_enable_port_shaping(0,144) # ID 140 is port 2/0
tm.thrift.tm_set_port_shaping_rate(0,144,False,100000,10000000) #high burst rate is important, otherwise we have losses
tm.qstat_report_mode_set(pipe=0, mode =True) # Pipe doesnt seem to affect
tm.q_visible_set(port=144,q=0,visible=True)