load 'projects/packs/plots/spectral.pal'

set terminal pdfcairo
set term pdfcairo enhanced font "Helvetica,16" size 4.6in,2.5in
set key font "Helvetica,15"
set key opaque
set key horiz center out top 

########################################################################################################################
# Mean flow completion time <100KB: pFabric-based scheduling schemes
########################################################################################################################
set output 'projects/packs/plots/fairness/web_search_workload/fairness_less_100KB_99th_fct_ms_32.pdf'

set xlabel 'Load'
set xrange [0:6]
set xtics ("0.2" 0, "0.3" 1, "0.4" 2, "0.5" 3, "0.6" 4, "0.7" 5, "0.8" 6)

set ylabel 'Flow Completion Time (ms)'
set yrange [0:40]
set ytics ("0" 0, "10" 10, "20" 20, "30" 30, "40" 40)

plot "projects/packs/plots/fairness/web_search_workload/fairness_less_100KB_99th_fct_ms_32.dat" using 2 title "TCP"  w lp ls 21 lw 4, \
               '' using 3 title "DCTCP" w lp ls 22 lw 4, \
               '' using 5 title "AIFO" w lp ls 23 lw 4, \
               '' using 6 title "SP-PIFO"  w lp ls 24 lw 4, \
               '' using 7 title "PACKS"  w lp ls 25 lw 4, \
               '' using 4 title "AFQ" w lp  ls 26 lw 4, \
               '' using 8 title "PIEO" w lp  ls 27 lw 4, \
               '' using 8 title "PIFO" w lp  ls 38 lw 4

########################################################################################################################
# Mean flow completion time <100KB: pFabric-based scheduling schemes
########################################################################################################################
set output 'projects/packs/plots/fairness/web_search_workload/fairness_less_100KB_mean_fct_ms_32.pdf'

set ylabel 'Flow Completion Time (ms)'
set yrange [0:10]
set ytics ("0" 0, "2" 2, "4" 4, "6" 6, "8" 8, "10" 10)

plot "projects/packs/plots/fairness/web_search_workload/fairness_less_100KB_mean_fct_ms_32.dat" using 2 title "TCP"  w lp ls 21 lw 4, \
               '' using 3 title "DCTCP" w lp ls 22 lw 4, \
               '' using 5 title "AIFO" w lp ls 23 lw 4, \
               '' using 6 title "SP-PIFO"  w lp ls 24 lw 4, \
               '' using 7 title "PACKS"  w lp ls 25 lw 4, \
               '' using 4 title "AFQ" w lp  ls 26 lw 4, \
               '' using 8 title "PIEO" w lp  ls 27 lw 4, \
               '' using 8 title "PIFO" w lp  ls 38 lw 4

########################################################################################################################
# Mean flow completion time >10MB: pFabric-based scheduling schemes
########################################################################################################################
set output 'projects/packs/plots/fairness/web_search_workload/fairness_split_mean_fct_ms_32.pdf'

set xlabel 'Flow Size'
set xrange [-0.5:6.5]
set xtics format ""
set xtics ("10K" 0, "20K" 1, "30K" 2, "50K" 3, "80K" 4, "0.2-1M" 5, "{/Symbol \263}2M" 6)

set ylabel 'Flow Completion Time (ms)'
set yrange [0.1:1000]
set logscale y 10
set ytics auto
set ytics ("1" 1, "10" 10, "100" 100, "1000" 1000)

set key opaque

set style data histogram
set style histogram errorbars gap 2 lw 3

set bars fullwidth
set bars front
#set boxwidth 0.7
set style fill solid 0.4

plot "projects/packs/plots/fairness/web_search_workload/fairness_split_mean_fct_ms_32.dat" using 2:3:4 title "TCP"  linecolor rgb '#D53E4F' lw 3, \
              '' using 5:6:7 title "DCTCP" linecolor rgb '#F46D43' lw 3, \
              '' using 11:12:13 title "AIFO" linecolor rgb '#FDAE61' lw 3, \
              '' using 14:15:16 title "SP-PIFO"  linecolor rgb '#FEE08B' lw 3, \
              '' using 17:18:19 title "PACKS"  linecolor rgb '#E6F598' lw 3, \
              '' using 8:9:10 title "AFQ" linecolor rgb '#ABDDA4' lw 3, \
              '' using 20:21:22 title "PIEO" linecolor rgb '#66C2A5' lw 3, \
              '' using 20:21:22 title "PIFO" linecolor rgb '#3288BD' lw 3


