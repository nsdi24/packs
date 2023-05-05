load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,17" size 4in,2.5in

set xlabel 'Rank Values'
set ylabel 'Number of Drops (⋅10^4)'

set yrange[0:150000]
set ytics ("0" 0, "3" 30000, "6" 60000, "9" 90000, "12" 120000, "15" 150000)

stats "projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.dat" using 2 name "fifo" nooutput
stats "projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.dat" using 3 name "aifo" nooutput
stats "projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.dat" using 4 name "sppifo" nooutput
stats "projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.dat" using 5 name "packs" nooutput
stats "projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.dat" using 6 name "pifo" nooutput

set output 'projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.pdf'
plot "projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/exponential.dat" using 2 title "FIFO" w l ls 1 lw 6, \
              '' using 3 title "AIFO" w l ls 2 lw 6, \
              '' using 4 title "SP-PIFO" w l ls 3 lw 6, \
              '' using 5 title "PACKS" w l ls 7 lw 6, \
              '' using 6 title "PIFO" w l ls 8 lw 6