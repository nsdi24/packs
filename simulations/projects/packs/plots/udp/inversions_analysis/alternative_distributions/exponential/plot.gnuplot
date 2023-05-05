load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,17" size 4in,2.5in

set xlabel 'Rank Values'
set ylabel 'Number of Inversions (⋅10^5)'

set yrange[0:500000]
set ytics ("0" 0, "1" 100000, "2" 200000, "3" 300000, "4" 400000, "5" 500000)

set output 'projects/packs/plots/udp/inversions_analysis/alternative_distributions/exponential/exponential.pdf'

f(x) = 0
plot "projects/packs/plots/udp/inversions_analysis/alternative_distributions/exponential/exponential.dat" using 2 title "FIFO" w l ls 1 lw 6, \
              '' using 3 title "AIFO" w l ls 2 lw 6, \
              '' using 4 title "SP-PIFO" w l ls 3 lw 6, \
              '' using 5 title "PACKS" w l ls 7 lw 6, \
             f(x) title "PIFO" w l ls 8 lw 6