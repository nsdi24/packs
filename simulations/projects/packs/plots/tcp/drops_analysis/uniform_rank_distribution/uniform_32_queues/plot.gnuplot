load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,17" size 3.5in,2.5in

set xlabel 'Rank Values'
set ylabel 'Number of Drops'

set yrange[0:150000]
set ytics ("0" 0, "25000" 25000, "50000" 50000, "75000" 75000, "100000" 100000, "125000" 125000, "150000" 150000)

stats "projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat" using 2 name "fifo" nooutput
stats "projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat" using 3 name "aifo" nooutput
stats "projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat" using 4 name "sppifo" nooutput
stats "projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat" using 5 name "packs" nooutput
stats "projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat" using 6 name "pifo" nooutput

set output 'projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.pdf'
plot "projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/uniform32.dat" using 2 title "FIFO" w l ls 1 lw 6, \
              '' using 3 title "AIFO" w l ls 2 lw 6, \
              '' using 4 title "SP-PIFO" w l ls 3 lw 6, \
              '' using 5 title "PACKS" w l ls 7 lw 6, \
              '' using 6 title "PIFO" w l ls 8 lw 6