load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,17" size 3.5in,2.5in

set xlabel 'Rank Values'
set ylabel 'Number of Inversions'

set yrange[0:150000]
set ytics ("0" 0, "25000" 25000, "50000" 50000, "75000" 75000, "100000" 100000, "125000" 125000, "150000" 150000)

set output 'projects/packs/plots/tcp/inversions_analysis/alternative_distributions/inverse_exponential/inverse_exponential.pdf'

f(x) = 0
plot "projects/packs/plots/tcp/inversions_analysis/alternative_distributions/inverse_exponential/inverse_exponential.dat" using 2 title "FIFO" w l ls 1 lw 6, \
              '' using 3 title "AIFO" w l ls 2 lw 6, \
              '' using 4 title "SP-PIFO" w l ls 3 lw 6, \
              '' using 5 title "PACKS" w l ls 7 lw 6, \
             f(x) title "PIFO" w l ls 8 lw 6