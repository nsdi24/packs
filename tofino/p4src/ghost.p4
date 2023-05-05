/* -*- P4_16 -*- */
#include <core.p4>
#include <t2na.p4>

/*************************************************************************
 ***********************  D E F I N E S  *********************************
 *************************************************************************/

typedef bit<48> mac_addr_t;
typedef bit<32> ipv4_addr_t;
typedef bit<16> ether_type_t;

const bit<32> N_PORTS = 512;
const ether_type_t ETHERTYPE_IPV4 = 16w0x0800;

/*************************************************************************
 ***********************  H E A D E R S  *********************************
 *************************************************************************/
 
header ethernet_h {
    mac_addr_t dst_mac_addr;
    mac_addr_t src_mac_addr;
    bit<16> ether_type;
}

header ipv4_h {
    bit<4> version;
    bit<4> ihl;
    bit<8> diffserv;
    bit<16> total_len;
    bit<16> identification;
    bit<3> flags;
    bit<13> frag_offset;
    bit<8> ttl;
    bit<8> protocol;
    bit<16> hdr_checksum;
    ipv4_addr_t src_addr;
    ipv4_addr_t dst_addr;
}

struct headers_t {
    ethernet_h          ethernet;
    ipv4_h              ipv4;
}

/*************************************************************************
 ***********************  M E T A D A T A  *******************************
 *************************************************************************/

struct metadata_t{ }

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
 ******************* I N G R E S S    P A R S E R  ***********************
 *************************************************************************/

parser IngressParser(packet_in  pkt,
        out headers_t           hdr,
        out metadata_t          ig_md,
        out ingress_intrinsic_metadata_t ig_intr_md,
        out ingress_intrinsic_metadata_for_tm_t     ig_tm_md) {

    state start {
        pkt.extract(ig_intr_md);
        
        /* We hardcode the egress port (all packets towards port 144) */
        ig_tm_md.ucast_egress_port = 144;

        pkt.advance(PORT_METADATA_SIZE);
        transition parse_ethernet;
    }

    state parse_ethernet {
        pkt.extract(hdr.ethernet);
        transition select (hdr.ethernet.ether_type) {
            ETHERTYPE_IPV4 : parse_ipv4;
            default : accept;
        }
    }

    state parse_ipv4 {
        pkt.extract(hdr.ipv4);
        transition accept;
    }
}

/*************************************************************************
 **************  I N G R E S S   P R O C E S S I N G   *******************
 *************************************************************************/

// At the Ingress block, we use ghost_intrinsic_metadata as input.
control Ingress(
        inout headers_t hdr,
        inout metadata_t ig_md,
        in ingress_intrinsic_metadata_t ig_intr_md,
        in ingress_intrinsic_metadata_from_parser_t ig_intr_prsr_md,
        inout ingress_intrinsic_metadata_for_deparser_t ig_intr_dprsr_md,
        inout ingress_intrinsic_metadata_for_tm_t ig_tm_md,
        in ghost_intrinsic_metadata_t gh_intr_md) {

        bit<32> temp;

        // Optional: one register where we can check the values of the ghost.
        Register<bit<32>, bit<32>>(N_PORTS) check_ghost;

        RegisterAction<bit<32>, bit<32>, bit<32>>(check_ghost) 
        write_check_ghost = {
                void apply(inout bit<32> value, out bit<32> result){
                    value = temp;
                }
        };

        // We define the register action to read the queue depth provided by the ghost thread.
        RegisterAction<bit<32>, bit<32>, bit<32>>(ghost_qdepth) 
        read_ghost = {
                void apply(inout bit<32> value, out bit<32> result){
                    result = value;
                }
        };

    apply {
        //* Get current queue depth from Ghost Thread *//
        temp = read_ghost.execute((bit<32>)gh_intr_md.qid);

        //* Write queue depth in other register to validate *//
        write_check_ghost.execute((bit<32>)gh_intr_md.qid);        
    }  
    
}

/*************************************************************************
 ****************  I N G R E S S    D E P A R S E R  *********************
 *************************************************************************/

control IngressDeparser(
        packet_out pkt,
        inout headers_t hdr,
        in metadata_t ig_md,
        in ingress_intrinsic_metadata_for_deparser_t ig_intr_dprsr_md) {

    Checksum() ipv4_checksum;

    apply {
        hdr.ipv4.hdr_checksum = ipv4_checksum.update({
            hdr.ipv4.version,
            hdr.ipv4.ihl,
            hdr.ipv4.diffserv,
            hdr.ipv4.total_len,
            hdr.ipv4.identification,
            hdr.ipv4.flags,
            hdr.ipv4.frag_offset,
            hdr.ipv4.ttl,
            hdr.ipv4.protocol,
            hdr.ipv4.src_addr,
            hdr.ipv4.dst_addr});
        pkt.emit(hdr.ethernet);
        pkt.emit(hdr.ipv4);
    }
}



/*************************************************************************
 *********************  E G R E S S    P A R S E R  **********************
 *************************************************************************/

parser EgressParser(
        packet_in pkt,
        out headers_t hdr,
        out metadata_t eg_md,
        out egress_intrinsic_metadata_t eg_intr_md) {

    state start {
        transition accept;
    }
    
}

/*************************************************************************
 ****************  E G R E S S   P R O C E S S I N G   *******************
 *************************************************************************/

control Egress(
        inout headers_t hdr,
        inout metadata_t eg_md,
        in egress_intrinsic_metadata_t eg_intr_md,
        in egress_intrinsic_metadata_from_parser_t eg_intr_md_from_prsr,
        inout egress_intrinsic_metadata_for_deparser_t ig_intr_dprs_md,
        inout egress_intrinsic_metadata_for_output_port_t eg_intr_oport_md) {
        
    apply { }

}

/*************************************************************************
 ******************  E G R E S S    D E P A R S E R  *********************
 *************************************************************************/

control EgressDeparser(
        packet_out pkt,
        inout headers_t hdr,
        in metadata_t eg_md,
        in egress_intrinsic_metadata_for_deparser_t ig_intr_dprs_md) {
        
    apply {
        pkt.emit(hdr);
    }
}

Pipeline(IngressParser(),
        Ingress(),
        IngressDeparser(),
        EgressParser(),
        Egress(),
        EgressDeparser(),
        Ghost()
        ) pipe;


Switch(pipe) main;