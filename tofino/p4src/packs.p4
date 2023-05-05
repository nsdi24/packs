/* -*- P4_16 -*- */
#include <core.p4>
#include <t2na.p4>

/*************************************************************************
 ***********************  D E F I N E S  *********************************
 *************************************************************************/

const bit<32> N_PORTS = 512;
const bit<32> B       = 22000;

#define REGISTER_ACTION_CHECK_WINDOW(i,j) \
    RegisterAction<register_lo_hi_struct, bit<32>, bit<32>> (window_##i##_##j##_register) \
    check_win_##i##_##j##_alu = { \
        void apply(inout register_lo_hi_struct value, out bit<32> rv) { \
            rv = 32w0; \
            register_lo_hi_struct in_value; \
            in_value = value; \
            if (meta.tail == (i*4 + j)) { \
                value.lo = (bit<32>)meta.rank; \
            } \
            if ((bit<32>)meta.rank > in_value.lo) { \
                value.hi = (bit<32>)1; \
            } else { \
                value.hi = (bit<32>)0; \
            } \
            rv = value.hi; \
        } \
    };

/*************************************************************************
 ***********************  H E A D E R S  *********************************
 *************************************************************************/

header ethernet_t {
    bit<48> dstAddr;
    bit<48> srcAddr;
    bit<16> etherType;
}

header ipv4_t {
    bit<4>  version;
    bit<4>  ihl;
    bit<8>  diffserv;
    bit<16> totalLen;
    bit<16> identification;
    bit<3>  flags;
    bit<13> fragOffset;
    bit<8>  ttl;
    bit<8>  protocol;
    bit<16> hdrChecksum;
    bit<32> srcAddr;
    bit<32> dstAddr;
}

header tcp_t {
    bit<16> srcPort;
    bit<16> dstPort;
    bit<32> seqNo;
    bit<32> ackNo;
    bit<4> dataOffset;
    bit<3> res;
    bit<3> ecn;
    bit<6> ctrl;
    bit<16> window;
    bit<16> checksum;
    bit<16> urgentPtr;
}

header udp_t {
    bit<16> srcPort;
    bit<16> dstPort;
    bit<16> pkt_length;
    bit<16> checksum;
}

/* All the headers we plan to process in the ingress */
struct ingress_headers_t {
    ethernet_t      ethernet;
    ipv4_t          ipv4;
    tcp_t           tcp;
    udp_t           udp;
}

/*************************************************************************
 ***********************  M E T A D A T A  *******************************
 *************************************************************************/

struct ingress_metadata_t {
    bit<16>        qid;

    bit<16>        tail;
    bit<32>        queue_length;
    bit<32>        min_value;

    bit<8>         count_0_0_let;
    bit<8>         count_0_1_let;
    bit<8>         count_0_2_let;
    bit<8>         count_0_3_let;

    bit<8>         count_1_0_let;
    bit<8>         count_1_1_let;
    bit<8>         count_1_2_let;
    bit<8>         count_1_3_let;

    bit<8>         count_2_0_let;
    bit<8>         count_2_1_let;
    bit<8>         count_2_2_let;
    bit<8>         count_2_3_let;

    bit<8>         count_3_0_let;
    bit<8>         count_3_1_let;
    bit<8>         count_3_2_let;
    bit<8>         count_3_3_let;
    
    bit<32>        count_all;
    bit<32>        comp0;
    bit<32>        comp1;
    bit<32>        comp2;
    bit<32>        comp3;
    bit<32>        min0;
    bit<32>        min1;
    bit<32>        min2;
    bit<32>        min3;

    bit<8>         rank;                 // Same size as diffserv
}

struct register_lo_hi_struct {
    bit<32> lo;
    bit<32> hi;
}

/*************************************************************************
 ******************  G H O S T   P R O C E S S I N G   *******************
 *************************************************************************/

// We declare the Ghost control and a Register (ghost_qdepth) out of the Ingress block, with a register action to write the queue depth provided by Traffic Manager.

// Register to the ghost thread
Register<bit<32>, bit<32>>(N_PORTS) ghost_qdepth;

// Ghost control
control Ghost(in ghost_intrinsic_metadata_t gh_intr_md){

    RegisterAction<bit<32>, bit<32>, bit<32>>(ghost_qdepth) 
    write_ghost = {
            void apply(inout bit<32> value){
                value = (bit<32>)gh_intr_md.qlength;
            }
    };

    apply {
        write_ghost.execute((bit<32>)gh_intr_md.qid); // bit<11> qid: port_group[3:0] ++ queue_id[6:0]
    }
}

/*************************************************************************
 ***********************  P A R S E R  ***********************************
 *************************************************************************/

parser IngressParser(packet_in                  pkt,
    out ingress_headers_t                       hdr,
    out ingress_metadata_t                      meta,
    out ingress_intrinsic_metadata_t            ig_intr_md,
    out ingress_intrinsic_metadata_for_tm_t     ig_tm_md) {

    state start {
        /* Mandatory code required by Tofino Architecture */
        pkt.extract(ig_intr_md);

        /* We hardcode the egress port (all packets towards port 144) */
        ig_tm_md.ucast_egress_port = 144;

        // Initialize metadata
        meta.qid = 0;
        meta.tail = 0;
        meta.queue_length = 0;
        meta.min_value = 0;
        meta.count_0_0_let = 0;
        meta.count_0_1_let = 0;
        meta.count_0_2_let = 0;
        meta.count_0_3_let = 0;
        meta.count_1_0_let = 0;
        meta.count_1_1_let = 0;
        meta.count_1_2_let = 0;
        meta.count_1_3_let = 0;
        meta.count_2_0_let = 0;
        meta.count_2_1_let = 0;
        meta.count_2_2_let = 0;
        meta.count_2_3_let = 0;
        meta.count_3_0_let = 0;
        meta.count_3_1_let = 0;
        meta.count_3_2_let = 0;
        meta.count_3_3_let = 0;
        meta.count_all = 0;
        meta.comp0 = 0;
        meta.comp1 = 0;
        meta.comp2 = 0;
        meta.comp3 = 0;
        meta.min0 = 0;
        meta.min1 = 0;
        meta.min2 = 0;
        meta.min3 = 0;
        meta.rank = 0;

        transition parse_port_metadata;
    }

    state parse_port_metadata {
        pkt.advance(PORT_METADATA_SIZE);
        transition parse_ethernet;
    }

    state parse_ethernet {
        pkt.extract(hdr.ethernet);
        transition select(hdr.ethernet.etherType) {
            0x0800:  parse_ipv4;
            default: accept;
        }
    }

    state parse_ipv4 {
        pkt.extract(hdr.ipv4);
        transition select(hdr.ipv4.protocol) {
            6:  parse_tcp;
            17: parse_udp;
            default: accept;
        }
    }

    state parse_tcp {
        pkt.extract(hdr.tcp);
        transition accept;
    }

    state parse_udp {
        pkt.extract(hdr.udp);
        transition accept;
    }
}

/*************************************************************************
 **************  I N G R E S S   P R O C E S S I N G   *******************
 *************************************************************************/

control Ingress(
    inout ingress_headers_t                          hdr,
    inout ingress_metadata_t                         meta,
    in    ingress_intrinsic_metadata_t               ig_intr_md,
    in    ingress_intrinsic_metadata_from_parser_t   ig_prsr_md,
    inout ingress_intrinsic_metadata_for_deparser_t  ig_dprsr_md,
    inout ingress_intrinsic_metadata_for_tm_t        ig_tm_md,
    in    ghost_intrinsic_metadata_t                 gh_intr_md) {  

    // Optional register where we can check the values of the ghost thread
    Register<bit<32>, bit<32>>(N_PORTS) check_ghost;
    RegisterAction<bit<32>, bit<32>, bit<32>>(check_ghost) 
    write_check_ghost = {
            void apply(inout bit<32> value, out bit<32> result){
                value = meta.queue_length;
            }
    };

    // We define the register action to read the queue depth provided by the ghost thread
    RegisterAction<bit<32>, bit<32>, bit<32>>(ghost_qdepth) 
    read_ghost = {
            void apply(inout bit<32> value, out bit<32> result){
                result = value;
            }
    };

    // Tail Register
    Register<bit<32>, bit<32>>(32w1) tail_reg;
    RegisterAction<bit<32>, bit<32>, bit<32>>(tail_reg) 
    get_oldest_register = {
        void apply(inout bit<32> value, out bit<32> rv) {
            rv = 32w0;
            bit<32> in_value;
            in_value = value;
            rv = in_value;
            if (in_value < 32w15) {
                value = in_value + 32w1;
            } else if (!(in_value < 32w15)) {
                value = (bit<32>)0;
            }
        }
    };

    // Sliding Window
    Register<register_lo_hi_struct, bit<32>>(1) window_0_0_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_0_1_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_0_2_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_0_3_register; 

    Register<register_lo_hi_struct, bit<32>>(1) window_1_0_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_1_1_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_1_2_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_1_3_register; 

    Register<register_lo_hi_struct, bit<32>>(1) window_2_0_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_2_1_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_2_2_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_2_3_register; 

    Register<register_lo_hi_struct, bit<32>>(1) window_3_0_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_3_1_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_3_2_register; 
    Register<register_lo_hi_struct, bit<32>>(1) window_3_3_register; 

    REGISTER_ACTION_CHECK_WINDOW(0,0) 
    REGISTER_ACTION_CHECK_WINDOW(0,1)
    REGISTER_ACTION_CHECK_WINDOW(0,2) 
    REGISTER_ACTION_CHECK_WINDOW(0,3) 

    REGISTER_ACTION_CHECK_WINDOW(1,0)
    REGISTER_ACTION_CHECK_WINDOW(1,1)
    REGISTER_ACTION_CHECK_WINDOW(1,2)
    REGISTER_ACTION_CHECK_WINDOW(1,3)

    REGISTER_ACTION_CHECK_WINDOW(2,0)
    REGISTER_ACTION_CHECK_WINDOW(2,1)
    REGISTER_ACTION_CHECK_WINDOW(2,2)
    REGISTER_ACTION_CHECK_WINDOW(2,3)

    REGISTER_ACTION_CHECK_WINDOW(3,0)
    REGISTER_ACTION_CHECK_WINDOW(3,1)
    REGISTER_ACTION_CHECK_WINDOW(3,2)
    REGISTER_ACTION_CHECK_WINDOW(3,3)

    Hash<bit<32>>(HashAlgorithm_t.IDENTITY) copy_0;

    Hash<bit<8>>(HashAlgorithm_t.IDENTITY) copy_1;
    Hash<bit<8>>(HashAlgorithm_t.IDENTITY) copy_2;
    Hash<bit<8>>(HashAlgorithm_t.IDENTITY) copy_3;
    Hash<bit<8>>(HashAlgorithm_t.IDENTITY) copy_4;

    @name(".count_mul_action") action count_mul_action() {
        meta.count_all = copy_0.get((bit<32>) meta.count_0_0_let) << 10;
    }

    // We compute (B-b) * i
    action compute_bbi() {
        meta.comp1 = meta.comp1 >> 1;
        meta.comp2 = meta.comp2 >> 1;
        meta.comp3 = meta.comp3 >> 2;
    }

    // Admit if W.quantile(pkt) * (1-K) * B <= (B-b)
    action compute_mins() {
        meta.min0 = min(meta.count_all, meta.comp0); 
        meta.min1 = min(meta.count_all, meta.comp1);
        meta.min2 = min(meta.count_all, meta.comp2);
        meta.min3 = min(meta.count_all, meta.comp3);
    }

    apply {
      
        if (hdr.udp.isValid() || hdr.tcp.isValid()) {

            @stage(0){
            // We extract the packet rank from the ToS field
            meta.rank = hdr.ipv4.diffserv;

            // Get the oldest register, which should be updated with the current rank
            meta.tail = (bit<16>) get_oldest_register.execute(0); }

            // Get quantile and update the window: Go through all registers, count the times r_register < rank. Update get_oldest_register with current rank value.
            @stage(1){
            meta.count_0_0_let = (bit<8>) check_win_0_0_alu.execute(0);
            meta.count_0_1_let = (bit<8>) check_win_0_1_alu.execute(0);
            meta.count_0_2_let = (bit<8>) check_win_0_2_alu.execute(0);
            meta.count_0_3_let = (bit<8>) check_win_0_3_alu.execute(0); }

            @stage(2){
            meta.count_1_0_let = (bit<8>) check_win_1_0_alu.execute(0); 
            meta.count_1_1_let = (bit<8>) check_win_1_1_alu.execute(0);
            meta.count_1_2_let = (bit<8>) check_win_1_2_alu.execute(0);
            meta.count_1_3_let = (bit<8>) check_win_1_3_alu.execute(0); }

            @stage(3){
            meta.count_2_0_let = (bit<8>) check_win_2_0_alu.execute(0);
            meta.count_2_1_let = (bit<8>) check_win_2_1_alu.execute(0);
            meta.count_2_2_let = (bit<8>) check_win_2_2_alu.execute(0);
            meta.count_2_3_let = (bit<8>) check_win_2_3_alu.execute(0);

            meta.count_0_0_let = meta.count_0_0_let + meta.count_1_0_let;
            meta.count_0_1_let = meta.count_0_1_let + meta.count_1_1_let;
            meta.count_0_2_let = meta.count_0_2_let + meta.count_1_2_let;
            meta.count_0_3_let = meta.count_0_3_let + meta.count_1_3_let; }

            @stage(4){
            meta.count_3_0_let = (bit<8>) check_win_3_0_alu.execute(0);
            meta.count_3_1_let = (bit<8>) check_win_3_1_alu.execute(0);
            meta.count_3_2_let = (bit<8>) check_win_3_2_alu.execute(0);
            meta.count_3_3_let = (bit<8>) check_win_3_3_alu.execute(0);

            meta.count_0_0_let = meta.count_0_0_let + meta.count_2_0_let;
            meta.count_0_1_let = meta.count_0_1_let + meta.count_2_1_let;
            meta.count_0_2_let = meta.count_0_2_let + meta.count_2_2_let;
            meta.count_0_3_let = meta.count_0_3_let + meta.count_2_3_let; }

            @stage(5){
            meta.count_0_0_let = meta.count_0_0_let + copy_1.get(meta.count_3_0_let);
            meta.count_0_1_let = meta.count_0_1_let + copy_2.get(meta.count_3_1_let);
            meta.count_0_2_let = meta.count_0_2_let + copy_3.get(meta.count_3_2_let);
            meta.count_0_3_let = meta.count_0_3_let + copy_4.get(meta.count_3_3_let); }

            @stage(6){
            // Sum 0,1,2,3
            meta.count_0_0_let = meta.count_0_0_let + meta.count_0_1_let;
            meta.count_0_2_let = meta.count_0_2_let + meta.count_0_3_let; }

            @stage(7){
            // Sum 0,2
            meta.count_0_0_let = meta.count_0_0_let + meta.count_0_2_let; }

            // PACKS enqueues to i={1,2,3,4}, if sum(0,1,2,3)/16 <= (B-b)/B * i/4 (and the queue is not full)
            // We implement it as: [sum(0,1,2,3) * B] /4 <= (B-b) * i

            // Count_all = [sum(0,1,2,3) * B] /4
            count_mul_action();                     // Stage 8 and 9

            // We get the current queue depth, c, from Ghost Thread
            meta.queue_length = read_ghost.execute((bit<32>)gh_intr_md.qid); // Stage 5 and 6 

            // We write queue depth in other register to validate
            //write_check_ghost.execute((bit<32>)gh_intr_md.qid);    

            // We compute (B-b)
            meta.comp0 = B - meta.queue_length;     // Stage 7
            meta.comp1 = B - meta.queue_length;
            meta.comp2 = B - meta.queue_length;
            meta.comp3 = B - meta.queue_length;

            // We compute (B-b) * i
            compute_bbi();                          // Stage 8
            meta.comp2 = meta.comp2 + meta.comp1;   // Stage 9

            // Admit if W.quantile(pkt) * (1-K) * B <= (B-b)
            compute_mins();

            // Queue mapping
            if (meta.min0 == meta.count_all) {
                ig_tm_md.qid = 0;
            } else if (meta.min1 == meta.count_all) {
                ig_tm_md.qid = 1;
            } else if (meta.min2 == meta.count_all) {
                ig_tm_md.qid = 2;
            } else if (meta.min3 == meta.count_all) {
                ig_tm_md.qid = 3;
            } else {
                ig_dprsr_md.drop_ctl = 0x1; // Mark packet for dropping after ingress.
            }
        }
    }
}

control IngressDeparser(packet_out pkt,
    inout ingress_headers_t                          hdr,
    in    ingress_metadata_t                         meta,
    in    ingress_intrinsic_metadata_for_deparser_t  ig_dprsr_md) {
        
    apply {
        pkt.emit(hdr);
    }
}

/*************************************************************************
 ****************  E G R E S S   P R O C E S S I N G   *******************
 *************************************************************************/

struct egress_headers_t {
    ethernet_t      ethernet;
    ipv4_t          ipv4;
    tcp_t           tcp;
    udp_t           udp;
}

struct egress_metadata_t {
}

parser EgressParser(packet_in        pkt,
    out egress_headers_t             hdr,
    out egress_metadata_t            meta,
    out egress_intrinsic_metadata_t  eg_intr_md) {

    state start {
        transition accept;
    }
}

control Egress(
    inout egress_headers_t                             hdr,
    inout egress_metadata_t                            meta,
    in    egress_intrinsic_metadata_t                  eg_intr_md,
    in    egress_intrinsic_metadata_from_parser_t      eg_prsr_md,
    inout egress_intrinsic_metadata_for_deparser_t     eg_dprsr_md,
    inout egress_intrinsic_metadata_for_output_port_t  eg_dport_md) {

    apply { }
}

control EgressDeparser(packet_out pkt,
    inout egress_headers_t                       hdr,
    in    egress_metadata_t                      meta,
    in    egress_intrinsic_metadata_for_deparser_t  eg_dprsr_md) {

    apply {
        pkt.emit(hdr);
    }
}

/*************************************************************************
 ****************  F I N A L  P A C K A G E    ***************************
 *************************************************************************/

Pipeline(
    IngressParser(), 
    Ingress(), 
    IngressDeparser(),
    EgressParser(), 
    Egress(), 
    EgressDeparser(),
    Ghost()
) pipe;

Switch(pipe) main;
