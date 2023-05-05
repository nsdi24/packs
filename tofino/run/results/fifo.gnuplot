load "palette/spectral.pal"

set terminal pdfcairo

set key out horiz top
set term pdfcairo enhanced font "Helvetica,20" size 4in,2.5in

set xlabel "Time (s)"
set xrange [0:80]

#set key opaque
set datafile separator ","

# In-Out Throughput
set yrange [0:10000]
set ytics ("0" 0, "2" 2000, "4" 4000, "6" 6000, "8" 8000, "10" 10000)
set key font "Helvetica,17" 
set ylabel "Throughput (Gbps)"
set output "run/results/fifo.pdf"

plot "run/results/fifo_flow1_throughput.dat" using 5 title "Flow 1" w l ls 1 lw 4, \
     "run/results/fifo_flow2_throughput.dat" using 5 title "Flow 2" w l ls 2 lw 4, \
     "run/results/fifo_flow3_throughput.dat" using 5 title "Flow 3" w l ls 3 lw 4, \
     "run/results/fifo_flow4_throughput.dat" using 5 title "Flow 4" w l ls 4 lw 4