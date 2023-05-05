load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,17" size 3.5in,2.5in

set xlabel 'Rank Values'
set ylabel 'Number of Inversions'

set yrange[0:150000]
set ytics ("0" 0, "25k" 25000, "50k" 50000, "75k" 75000, "100k" 100000, "125k" 125000, "150k" 150000)

set xrange[0:100]
set xtics ("0" 0, "25" 25, "50" 50, "75" 75, "100" 100)

set output 'projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/uniform.pdf'

f(x) = 0
plot "projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/uniform.dat" using 2 title "FIFO" w l ls 1 lw 6, \
                   '' using 3 title "AIFO" w l ls 2 lw 6, \
                   '' using 4 title "SP-PIFO" w l ls 3 lw 6, \
                   '' using 5 title "PACKS" w l ls 37 lw 6, \
                  f(x) title "PIFO" w l ls 8 lw 6