package ch.ethz.systems.netbench.core.run;

public class MainFromIntelliJ {

    public static void main_AIFO_7() {

        /*
         * Figure 7 Simulation results of web search workload to minimize FCT.
         * Result data are stored in java-code/project/aifo/plots/aifo_evaluation/pFabric/web_search_workload.
         * Since we are doing 10G/40G, overwrite traffice_lambda_flow_starts_per_s and link_bandwidth_bit_per_ns
         * to original_lambda*10 and 10 respectively. */
         

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/AIFO.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "sample_count=15", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "k_value=0.1"});


        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/DCTCP.properties", "traffic_lambda_flow_starts_per_s=36000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/TCP.properties", "traffic_lambda_flow_starts_per_s=36000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/PIFO.properties", "traffic_lambda_flow_starts_per_s=36000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=36000", "link_bandwidth_bit_per_ns=10"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/DCTCP.properties", "traffic_lambda_flow_starts_per_s=52000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/TCP.properties", "traffic_lambda_flow_starts_per_s=52000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/PIFO.properties", "traffic_lambda_flow_starts_per_s=52000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=52000", "link_bandwidth_bit_per_ns=10"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/DCTCP.properties", "traffic_lambda_flow_starts_per_s=70000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/TCP.properties", "traffic_lambda_flow_starts_per_s=70000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/PIFO.properties", "traffic_lambda_flow_starts_per_s=70000", "link_bandwidth_bit_per_ns=10"});
       MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=70000", "link_bandwidth_bit_per_ns=10"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/DCTCP.properties", "traffic_lambda_flow_starts_per_s=89000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/TCP.properties", "traffic_lambda_flow_starts_per_s=89000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/PIFO.properties", "traffic_lambda_flow_starts_per_s=89000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=89000", "link_bandwidth_bit_per_ns=10"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/DCTCP.properties", "traffic_lambda_flow_starts_per_s=111000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/TCP.properties", "traffic_lambda_flow_starts_per_s=111000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/PIFO.properties", "traffic_lambda_flow_starts_per_s=111000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=111000", "link_bandwidth_bit_per_ns=10"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/DCTCP.properties", "traffic_lambda_flow_starts_per_s=141500", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/TCP.properties", "traffic_lambda_flow_starts_per_s=141500", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/PIFO.properties", "traffic_lambda_flow_starts_per_s=141500", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=141500", "link_bandwidth_bit_per_ns=10"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/DCTCP.properties", "traffic_lambda_flow_starts_per_s=190000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/TCP.properties", "traffic_lambda_flow_starts_per_s=190000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/PIFO.properties", "traffic_lambda_flow_starts_per_s=190000", "link_bandwidth_bit_per_ns=10"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/SPPIFO.properties", "traffic_lambda_flow_starts_per_s=190000", "link_bandwidth_bit_per_ns=10"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/aifo/plots/aifo_evaluation/pFabric/web_search_workload/analyze.py");
        MainFromProperties.runCommand("python3 parse.py fig 7a");
        MainFromProperties.runCommand("python3 parse.py fig 7b");
        MainFromProperties.runCommand("python3 parse.py fig 7c");
    }

    public static void main_AIFO_8() {

        /*
         * Figure 8: The effect of parameter k
         * Note that despite the property files, all out_port_max_size_packets (C/q_len) are set to 20
         * Result data are stored in java-code/project/aifo/plots/aifo_evaluation/pFabric/web_search_workload_C_K.
         */

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/TCP.properties", "traffic_lambda_flow_starts_per_s=36000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/PIFO.properties", "traffic_lambda_flow_starts_per_s=36000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/TCP.properties", "traffic_lambda_flow_starts_per_s=52000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/5200/PIFO.properties", "traffic_lambda_flow_starts_per_s=52000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/TCP.properties", "traffic_lambda_flow_starts_per_s=70000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/7000/PIFO.properties", "traffic_lambda_flow_starts_per_s=70000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/TCP.properties", "traffic_lambda_flow_starts_per_s=89000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/8900/PIFO.properties", "traffic_lambda_flow_starts_per_s=89000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/TCP.properties", "traffic_lambda_flow_starts_per_s=111000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/11100/PIFO.properties", "traffic_lambda_flow_starts_per_s=111000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/TCP.properties", "traffic_lambda_flow_starts_per_s=141500", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/14150/PIFO.properties", "traffic_lambda_flow_starts_per_s=141500", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/TCP.properties", "traffic_lambda_flow_starts_per_s=190000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/19000/PIFO.properties", "traffic_lambda_flow_starts_per_s=190000", "link_bandwidth_bit_per_ns=10", "enable_inversions_tracking=false"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/3600/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/5200/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/7000/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/8900/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/11100/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/14150/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/19000/AIFO_C30.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.1", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/3600/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/5200/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/7000/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/8900/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/11100/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/14150/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/19000/AIFO_C40.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.3", "k_value=0.3"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/5200/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/7000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/8900/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/11100/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/14150/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/19000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/3600/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.9", "k_value=0.9"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/3600/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/5200/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/7000/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/11100/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/14150/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/19000/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_C_K/8900/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "run_folder_name=AIFO_C20_K0.7", "k_value=0.7"});

        MainFromProperties.runCommand("python3 projects/aifo/plots/aifo_evaluation/pFabric/web_search_workload_C_K/analyze.py");

    }

    public static void main_AIFO_9() {

        /*
         * Figure 9: The effect of window length and sampling rate
         * Result data are stored in java-code/project/aifo/plots/aifo_evaluation/pFabric/web_search_workload_w_sr.
         */

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/3600/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/5200/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/7000/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/8900/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/11100/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/14150/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/19000/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W20_SR1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/3600/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/5200/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/7000/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/8900/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/11100/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/14150/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/19000/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=50", "k_value=0.1", "run_folder_name=AIFO_W20_SR0.02"});


        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/3600/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/5200/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/7000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/8900/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/11100/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/14150/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/19000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=1000", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=1", "k_value=0.1", "run_folder_name=AIFO_W1000_SR1"});


        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/3600/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/5200/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/7000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/8900/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/11100/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/14150/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_sample_rate/19000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=100", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=10", "k_value=0.1", "run_folder_name=AIFO_W100_SR0.1"});


        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/aifo/plots/aifo_evaluation/pFabric/web_search_workload_w_sr/analyze.py");
    }

    public static void main_AIFO_10() {
        /*
         * Figure 10: The effect of queue length on 1G/4G network.
         * Result data are stored in java-code/project/aifo/plots/aifo_evaluation/pFabric/web_search_workload_q_len_1_4
         */

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C10.properties"
                , "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C20.properties"
                , "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C50.properties"
                , "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C100.properties"
                , "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C200.properties"
                , "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C500.properties"
                , "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C1000.properties"
                , "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=1", "sample_count=15", "k_value=0.1"});

        /* Analyze */
        MainFromProperties.runCommand("python3 projects/aifo/plots/aifo_evaluation/pFabric/web_search_workload_q_len_1_4/analyze.py");
    }

    public static void main_AIFO_11() {
        /*
         * Figure 11: The effect of queue length on 10G/40G network.
         * Result data are stored in java-code/project/aifo/plots/aifo_evaluation/pFabric/web_search_workload_q_len
         */

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C10.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=10", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C20.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=20", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C50.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=50", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C100.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C200.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=200", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C500.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=500", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/3600/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=36000", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/5200/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=52000", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/7000/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=70000", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/8900/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=89000", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/11100/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=111000", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/19000/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=190000", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload_q_len/14150/AIFO_C1000.properties"
                , "traffic_lambda_flow_starts_per_s=141500", "window_size=20", "output_port_max_size_packets=1000", "link_bandwidth_bit_per_ns=10", "sample_count=15", "k_value=0.1"});

        /* Analyze */
        MainFromProperties.runCommand("python3 projects/aifo/plots/aifo_evaluation/pFabric/web_search_workload_q_len/analyze.py");

    }

    public static void main_AIFO_12_13() {
        /*
         * Figure 12 and 13: Packet distribution logged at the receiver. Three senders send one flow each to a receiver at the same time.
         * The size of the three flows are 100MB (large), 50MB (medium) and 10MB (small), respectively.
         * The link between the switch and the receiver is the bottleneck.
         *
         * The result plots are in projects/aifo/plots/aifo_evaluation/selfDefinedFlows
         */

        //todo: uncomment SelfDefinedFlows.setIsSDFTrue();
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/PIFO.properties", "link_bandwidth_bit_per_ns=1", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/SPPIFO.properties", "link_bandwidth_bit_per_ns=1", "enable_inversions_tracking=false"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/AIFO.properties"
                , "window_size=20", "sample_count=15", "output_port_max_size_packets=100", "link_bandwidth_bit_per_ns=1", "enable_inversions_tracking=false", "k_value=0.1"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/pFabric/web_search_workload/3600/TCP.properties", "link_bandwidth_bit_per_ns=1", "enable_inversions_tracking=false", "transport_layer=pfabric"});
        //todo: uncomment SelfDefinedFlows.setIsSDFFalse();

        MainFromProperties.runCommand("python plot_received.py"); //figure plots

    }

    public static void main_AIFO_14() {

        /*
         * Figure 14: Simulation results of web search workload with fair queueing
         * Result data are stored in java-code/project/aifo/plots/aifo_evaluation/fairness/web_search_workload
         */

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/3600/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/3600/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/3600/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/3600/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/3600/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/3600/PIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/5200/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/5200/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/5200/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/5200/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/5200/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/5200/PIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/7000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/7000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/7000/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/7000/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/7000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/7000/PIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/8900/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/8900/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/8900/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/8900/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/8900/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/8900/PIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/11100/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/11100/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/11100/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/11100/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/11100/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/11100/PIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/14150/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/14150/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/14150/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/14150/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/14150/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/14150/PIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/19000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/19000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/19000/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/19000/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/19000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/aifo/runs/aifo_evaluation/fairness/web_search_workload/19000/PIFOWFQ_32.properties"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python projects/aifo/plots/aifo_evaluation/fairness/analyze.py");
        //MainFromProperties.runCommand("python3 parse.py fig 14a");
        //MainFromProperties.runCommand("python3 parse.py fig 14b");
        //MainFromProperties.runCommand("python3 parse.py fig 14c");
        MainFromProperties.runCommand("gnuplot projects/aifo/plots/aifo_evaluation/fairness/plot.gnuplot");
    }

    public static void main_SPPIFO() {

        /* Figure 5: SP-PIFO performance (uniform rank distribution) */

        /* Figure 5a: Uniform 8 queues */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_8_queues/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_8_queues/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_8_queues/Fixed_queue_bounds.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_8_queues/Greedy.properties"});

        /* Figure 5b: Uniform 32 queues */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_32_queues/Fixed_queue_bounds_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/uniform_32_queues/Greedy_32.properties"});

        /* Figure 5c: Adaptation strategies
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/adaptation_strategies/SPPIFO_queuebound.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/adaptation_strategies/SPPIFO_cost.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/adaptation_strategies/SPPIFO_rank.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/adaptation_strategies/SPPIFO_1.properties"}); */

        /* Figure 5d: Utilization
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/SPPIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/SPPIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/SPPIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/SPPIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/SPPIFO_90.properties"}); */

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/Greedy_20.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/Greedy_40.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/Greedy_60.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/Greedy_80.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/Greedy_90.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/FIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/FIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/FIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/FIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/uniform_rank_distribution/utilization/FIFO_90.properties"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/uniform_8_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/uniform_8_queues/plot.gnuplot");
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/uniform_32_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/uniform_32_queues/plot.gnuplot");
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/adaptation_strategies/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/adaptation_strategies/plot.gnuplot");
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/utilization/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/uniform_rank_distribution/utilization/plot.gnuplot");

        /* Figure 6: SP-PIFO performance (alternative distributions) */

        /* Figure 6a: Exponential */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/exponential/Greedy.properties"});

        /* Figure 6b: Inverse exponential */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/inverse_exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/inverse_exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/inverse_exponential/Greedy.properties"});

        /* Figure 6c: Poisson */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/poisson/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/poisson/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/poisson/Greedy.properties"});

        /* Figure 6d: Convex */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/convex/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/convex/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_analysis/alternative_distributions/convex/Greedy.properties"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_analysis/alternative_distributions/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/alternative_distributions/exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/alternative_distributions/inverse_exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/alternative_distributions/poisson/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_analysis/alternative_distributions/convex/plot.gnuplot");

        /* Figure 7: pFabric: FCT statistics across different flow sizes in data mining workload

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/4000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/4000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/4000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/4000/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/6000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/6000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/6000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/6000/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/10000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/10000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/10000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/10000/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/15000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/15000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/15000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/15000/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/22500/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/22500/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/22500/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/22500/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/37000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/37000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/37000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/37000/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/60000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/60000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/60000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/data_mining_workload/60000/SPPIFO.properties"}); */

        /* Analyze and plot
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_evaluation/pFabric/data_mining_workload/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_evaluation/pFabric/data_mining_workload/plot.gnuplot"); */

        /* Figure 8: pFabric: FCT statistics across different flow sizes in web search workload

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/3600/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/3600/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/3600/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/3600/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/5200/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/5200/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/5200/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/5200/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/7000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/7000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/7000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/7000/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/8900/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/8900/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/8900/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/8900/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/11100/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/11100/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/11100/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/11100/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/14150/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/14150/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/14150/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/14150/SPPIFO.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/19000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/19000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/19000/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/pFabric/web_search_workload/19000/SPPIFO.properties"}); */

        /* Analyze and plot
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_evaluation/pFabric/web_search_workload/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_evaluation/pFabric/web_search_workload/plot.gnuplot"); */

        /* Figure 9 and 10: Fairness FCT statistics */

        /* Figure 9: Fairness: FCT statistics for all flows at different loads, over the web search workload */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/3600/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/5200/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/7000/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/8900/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/11100/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/14150/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/PIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/19000/SPPIFOWFQ_32.properties"});

        /* Figure 10: Fairness: FCT statistics for all flows at different loads, when the number of queues is modified */
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/AFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/AFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/SPPIFOWFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/SPPIFOWFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/3600/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/AFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/AFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/SPPIFOWFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/SPPIFOWFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/7000/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/AFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/AFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/SPPIFOWFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/SPPIFOWFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/11100/SPPIFOWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/AFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/AFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/AFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/SPPIFOWFQ_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/SPPIFOWFQ_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/SPPIFOWFQ_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/sppifo_evaluation/fairness/web_search_workload/queue_analysis/19000/SPPIFOWFQ_32.properties"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/sppifo/plots/sppifo_evaluation/fairness/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/sppifo/plots/sppifo_evaluation/fairness/plot.gnuplot");

        /* Figure 13: Greedy convergence for uniform rank distribution (we add extra distributions that are not included in the paper)

        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_convergence/Greedy_Uniform.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_convergence/Greedy_Exponential.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_convergence/Greedy_InverseExponential.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_convergence/Greedy_MinMax.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_convergence/Greedy_Poisson.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_convergence/Greedy_Convex.properties"}); */

        /* Analyze and plot */
        //MainFromProperties.runCommand("python3 projects/sppifo/plots/greedy_convergence/analyze.py");
        //MainFromProperties.runCommand("gnuplot projects/sppifo/plots/greedy_convergence/plot.gnuplot");

        /* Figure 14: Greedy algorithm adaptation microbenchmark

        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_50.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_250.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_500.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_1000.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_2500.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_5000.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/adaptation_period/Greedy_Uniform_7000.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_4.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_8.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_12.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_16.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_20.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_24.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_28.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/num_queues/Greedy_Uniform_32.properties"});

        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_50.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_100.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_200.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_400.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_600.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_800.properties"});
        MainFromProperties.main(new String[]{"projects/sppifo/runs/greedy_microbenchmark/max_rank/Greedy_Uniform_1000.properties"}); */

        /* Analyze and plot */
        //MainFromProperties.runCommand("python3 projects/sppifo/plots/greedy_microbenchmark/analyze.py");
        //MainFromProperties.runCommand("gnuplot projects/sppifo/plots/greedy_microbenchmark/plot.gnuplot");
    }

    public static void main_PACKS_TCP(){

        /******************************************************/
        /*********************** TCP **************************/
        /******************************************************/

        /* PACKS drops analysis (uniform rank distribution) */

        /* PACKS drops analysis: Uniform 8 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/AIFO.properties"});
        //MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/Fixed_queue_bounds.properties"});

        /* PACKS drops analysis: Uniform 32 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/PACKS_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/PIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/AIFO_32.properties"});

        /* PACKS drops analysis: Utilization */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/FIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/FIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/FIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/FIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/FIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/PACKS_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/PACKS_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/PACKS_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/PACKS_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/PACKS_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/AIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/AIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/AIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/AIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/uniform_rank_distribution/utilization/AIFO_90.properties"});

        /* PACKS drops analysis: Exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/exponential/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/exponential/AIFO.properties"});

        /* PACKS drops analysis: Inverse exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/inverse_exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/inverse_exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/inverse_exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/inverse_exponential/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/inverse_exponential/AIFO.properties"});

        /* PACKS drops analysis: Poisson */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/poisson/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/poisson/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/poisson/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/poisson/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/poisson/AIFO.properties"});

        /* PACKS drops analysis: Convex */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/convex/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/convex/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/convex/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/convex/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/drops_analysis/alternative_distributions/convex/AIFO.properties"});

        /* PACKS drops analysis: Analyze and plot */
        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_8_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/uniform_32_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/utilization/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/uniform_rank_distribution/utilization/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/drops_analysis/alternative_distributions/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/alternative_distributions/exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/alternative_distributions/inverse_exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/alternative_distributions/poisson/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/drops_analysis/alternative_distributions/convex/plot.gnuplot");

        /* PACKS inversions analysis (uniform rank distribution) */

        /* PACKS inversions analysis: Uniform 8 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/AIFO.properties"});
        //MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/Fixed_queue_bounds.properties"});
        //MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/Greedy.properties"});

        /* PACKS inversions analysis: Uniform 32 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/PACKS_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/AIFO_32.properties"});

        /* PACKS inversions analysis: Utilization */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_90.properties"});

        /* PACKS inversions analysis: Exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/exponential/AIFO.properties"});

        /* PACKS inversions analysis: Inverse exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/inverse_exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/inverse_exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/inverse_exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/inverse_exponential/AIFO.properties"});

        /* PACKS inversions analysis: Poisson */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/poisson/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/poisson/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/poisson/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/poisson/AIFO.properties"});

        /* PACKS inversions analysis: Convex */
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/convex/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/convex/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/convex/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/tcp/inversions_analysis/alternative_distributions/convex/AIFO.properties"});

        /* PACKS inversions analysis: Analyze and plot */
        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/utilization/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/uniform_rank_distribution/utilization/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/tcp/inversions_analysis/alternative_distributions/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/alternative_distributions/exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/alternative_distributions/inverse_exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/alternative_distributions/poisson/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/tcp/inversions_analysis/alternative_distributions/convex/plot.gnuplot");

    }

    public static void main_PACKS_UDP() {

        /******************************************************/
        /*********************** UDP **************************/
        /******************************************************/

        /* PACKS drops analysis (uniform rank distribution) */

        /* PACKS drops analysis: Uniform 8 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/AIFO.properties"});

        /* PACKS drops analysis: Uniform 32 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/PACKS_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/PIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/AIFO_32.properties"});

        /* PACKS drops analysis: Utilization */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/FIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/FIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/FIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/FIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/FIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/SPPIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/PACKS_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/PACKS_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/PACKS_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/PACKS_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/PACKS_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/AIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/AIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/AIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/AIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/uniform_rank_distribution/utilization/AIFO_90.properties"});

        /* PACKS drops analysis: Exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/exponential/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/exponential/AIFO.properties"});

        /* PACKS drops analysis: Inverse exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/inverse_exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/inverse_exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/inverse_exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/inverse_exponential/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/inverse_exponential/AIFO.properties"});

        /* PACKS drops analysis: Poisson */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/poisson/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/poisson/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/poisson/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/poisson/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/poisson/AIFO.properties"});

        /* PACKS drops analysis: Convex */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/convex/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/convex/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/convex/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/convex/PIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/drops_analysis/alternative_distributions/convex/AIFO.properties"});

        /* PACKS drops analysis: Analyze and plot */
        MainFromProperties.runCommand("python3 projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/uniform_8_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/uniform_32_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/utilization/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/uniform_rank_distribution/utilization/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/udp/drops_analysis/alternative_distributions/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/alternative_distributions/exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/alternative_distributions/inverse_exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/alternative_distributions/poisson/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/drops_analysis/alternative_distributions/convex/plot.gnuplot");

        /* PACKS inversions analysis (uniform rank distribution) */

        /* PACKS inversions analysis: Uniform 8 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/AIFO.properties"});

        /* PACKS inversions analysis: Uniform 32 queues */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/FIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/SPPIFO_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/PACKS_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/AIFO_32.properties"});

        /* PACKS inversions analysis: Utilization */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/FIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/SPPIFO_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/PACKS_90.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_20.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_40.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_60.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_80.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/uniform_rank_distribution/utilization/AIFO_90.properties"});

        /* PACKS inversions analysis: Exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/exponential/AIFO.properties"});

        /* PACKS inversions analysis: Inverse exponential */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/inverse_exponential/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/inverse_exponential/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/inverse_exponential/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/inverse_exponential/AIFO.properties"});

        /* PACKS inversions analysis: Poisson */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/poisson/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/poisson/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/poisson/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/poisson/AIFO.properties"});

        /* PACKS inversions analysis: Convex */
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/convex/FIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/convex/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/convex/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/udp/inversions_analysis/alternative_distributions/convex/AIFO.properties"});

        /* PACKS inversions analysis: Analyze and plot */
        MainFromProperties.runCommand("python3 projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/uniform_8_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/uniform_32_queues/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/utilization/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/uniform_rank_distribution/utilization/plot.gnuplot");

        MainFromProperties.runCommand("python3 projects/packs/plots/udp/inversions_analysis/alternative_distributions/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/alternative_distributions/exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/alternative_distributions/inverse_exponential/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/alternative_distributions/poisson/plot.gnuplot");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/udp/inversions_analysis/alternative_distributions/convex/plot.gnuplot");
    }

    public static void main_PACKS_pFabric() {

        /* pFabric: FCT statistics across different flow sizes in web search workload  */

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/3600/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/3600/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/3600/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/3600/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/3600/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/3600/PIFO.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/5200/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/5200/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/5200/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/5200/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/5200/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/5200/PIFO.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/7000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/7000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/7000/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/7000/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/7000/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/7000/PIFO.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/8900/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/8900/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/8900/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/8900/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/8900/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/8900/PIFO.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/11100/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/11100/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/11100/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/11100/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/11100/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/11100/PIFO.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/14150/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/14150/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/14150/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/14150/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/14150/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/14150/PIFO.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/19000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/19000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/19000/AIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/19000/SPPIFO.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/19000/PACKS.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/pFabric/web_search_workload/19000/PIFO.properties"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/packs/plots/pFabric/web_search_workload/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/pFabric/web_search_workload/plot.gnuplot");

    }

    public static void main_PACKS_fairness() {

        /* Fairness: FCT statistics for all flows at different loads, over the web search workload */ 
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/3600/PACKSWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/5200/PACKSWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/7000/PACKSWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/8900/PACKSWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/11100/PACKSWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/14150/PACKSWFQ_32.properties"});

        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/TCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/DCTCP.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/SPPIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/AFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/AIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/PIFOWFQ_32.properties"});
        MainFromProperties.main(new String[]{"projects/packs/runs/fairness/web_search_workload/19000/PACKSWFQ_32.properties"});

        /* Analyze and plot */
        MainFromProperties.runCommand("python3 projects/packs/plots/fairness/analyze.py");
        MainFromProperties.runCommand("gnuplot projects/packs/plots/fairness/plot.gnuplot");
    }

    public static void main(String args[]) {

        main_AIFO_7();

        // main_PACKS_UDP();
        // main_PACKS_pFabric();
        // main_PACKS_fairness();

    }



}
