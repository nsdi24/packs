load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,17" size 3.5in,2.5in

set xlabel 'Utilization (%)'
set ylabel 'Number of Inversions'

set yrange[0:150000]
set ytics ("0" 0, "25000" 25000, "50000" 50000, "75000" 75000, "100000" 100000, "125000" 125000, "150000" 150000)

set xrange[20:90]

set output 'projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/utilization/utilization.pdf'

f(x) = 0
plot "projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/utilization/utilization.dat" using 1:2 title "FIFO" w lp ls 1 lw 6 , \
            '' using 1:3 title "AIFO" w lp ls 2 lw 6, \
            '' using 1:4 title "SP-PIFO" w lp ls 3 lw 6, \
            '' using 1:5 title "PACKS" w lp ls 7 lw 6, \
            f(x) title "PIFO" w lp ls 8 lw 6