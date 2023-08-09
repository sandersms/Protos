// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: openconfig_vlan.proto

package opi_api.network.v1alpha1;

public final class OpenconfigVlanProto {
  private OpenconfigVlanProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanSwitchedIf_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanSwitchedIf_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIngressEgressSetting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIngressEgressSetting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanIngressMapping_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanIngressMapping_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanEgressMapping_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanEgressMapping_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025openconfig_vlan.proto\022\030opi_api.network" +
      ".v1alpha1\"\227\001\n\023SwitchedVlanSetting\022A\n\023vla" +
      "n_interface_mode\030\001 \001(\0162$.opi_api.network" +
      ".v1alpha1.VlanIfMode\022\023\n\013native_vlan\030\002 \001(" +
      "\r\022\023\n\013access_vlan\030\003 \001(\r\022\023\n\013trunk_vlans\030\004 " +
      "\001(\t\"\215\001\n\016VlanSwitchedIf\022=\n\006config\030\001 \001(\0132-" +
      ".opi_api.network.v1alpha1.SwitchedVlanSe" +
      "tting\022<\n\005state\030\002 \001(\0132-.opi_api.network.v" +
      "1alpha1.SwitchedVlanSetting\"\242\001\n\030VlanIngr" +
      "essEgressSetting\022B\n\017vlanstackaction\030\001 \001(" +
      "\0162).opi_api.network.v1alpha1.VlanStackAc" +
      "tion\022\017\n\007vlan_id\030\002 \001(\r\0221\n\004tpid\030\003 \001(\0162#.op" +
      "i_api.network.v1alpha1.TpidTypes\"\340\t\n\006Vla" +
      "nIf\0229\n\005match\030\001 \001(\0132*.opi_api.network.v1a" +
      "lpha1.VlanIf.VlanMatch\022K\n\016ingressmapping" +
      "\030\002 \001(\01323.opi_api.network.v1alpha1.VlanIf" +
      ".VlanIngressMapping\022I\n\regressmapping\030\003 \001" +
      "(\01322.opi_api.network.v1alpha1.VlanIf.Vla" +
      "nEgressMapping\032\307\005\n\tVlanMatch\022M\n\014singleta" +
      "gged\030\001 \001(\01327.opi_api.network.v1alpha1.Vl" +
      "anIf.VlanMatch.SingleTagged\022U\n\020singletag" +
      "gedlist\030\002 \001(\0132;.opi_api.network.v1alpha1" +
      ".VlanIf.VlanMatch.SingleTaggedList\032\205\002\n\014S" +
      "ingleTagged\022W\n\006config\030\001 \001(\0132G.opi_api.ne" +
      "twork.v1alpha1.VlanIf.VlanMatch.SingleTa" +
      "gged.SingleTagConfig\022U\n\005state\030\002 \001(\0132F.op" +
      "i_api.network.v1alpha1.VlanIf.VlanMatch." +
      "SingleTagged.SingleTagState\032\"\n\017SingleTag" +
      "Config\022\017\n\007vlan_id\030\001 \001(\r\032!\n\016SingleTagStat" +
      "e\022\017\n\007vlan_id\030\001 \001(\r\032\213\002\n\020SingleTaggedList\022" +
      "Y\n\006config\030\001 \001(\0132I.opi_api.network.v1alph" +
      "a1.VlanIf.VlanMatch.SingleTaggedList.Tag" +
      "ListConfig\022Y\n\006status\030\002 \001(\0132I.opi_api.net" +
      "work.v1alpha1.VlanIf.VlanMatch.SingleTag" +
      "gedList.TagListStatus\032 \n\rTagListConfig\022\017" +
      "\n\007vlan_id\030\001 \003(\r\032\037\n\rTagListStatus\022\016\n\006vlan" +
      "id\030\001 \003(\r\032\233\001\n\022VlanIngressMapping\022B\n\006confi" +
      "g\030\001 \001(\01322.opi_api.network.v1alpha1.VlanI" +
      "ngressEgressSetting\022A\n\005state\030\002 \001(\01322.opi" +
      "_api.network.v1alpha1.VlanIngressEgressS" +
      "etting\032\232\001\n\021VlanEgressMapping\022B\n\006config\030\001" +
      " \001(\01322.opi_api.network.v1alpha1.VlanIngr" +
      "essEgressSetting\022A\n\005state\030\002 \001(\01322.opi_ap" +
      "i.network.v1alpha1.VlanIngressEgressSett" +
      "ing*\227\001\n\tTpidTypes\022\032\n\026TPID_TYPES_UNSPECIF" +
      "IED\020\000\022\025\n\021TPID_TYPES_0X8100\020\001\022\025\n\021TPID_TYP" +
      "ES_0X88A8\020\002\022\025\n\021TPID_TYPES_0X9100\020\003\022\025\n\021TP" +
      "ID_TYPES_0X9200\020\004\022\022\n\016TPID_TYPES_ANY\020\005*\207\001" +
      "\n\017VlanStackAction\022!\n\035VLAN_STACK_ACTION_U" +
      "NSPECIFIED\020\000\022\032\n\026VLAN_STACK_ACTION_PUSH\020\001" +
      "\022\031\n\025VLAN_STACK_ACTION_POP\020\002\022\032\n\026VLAN_STAC" +
      "K_ACTION_SWAP\020\003*[\n\nVlanIfMode\022\034\n\030VLAN_IF" +
      "_MODE_UNSPECIFIED\020\000\022\027\n\023VLAN_IF_MODE_ACCE" +
      "SS\020\001\022\026\n\022VLAN_IF_MODE_TRUNK\020\002Bu\n\030opi_api." +
      "network.v1alpha1B\023OpenconfigVlanProtoP\001Z" +
      "Bgithub.com/opiproject/opi-api/network/o" +
      "pinetcommon/v1alpha1/gen/gob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_descriptor,
        new java.lang.String[] { "VlanInterfaceMode", "NativeVlan", "AccessVlan", "TrunkVlans", });
    internal_static_opi_api_network_v1alpha1_VlanSwitchedIf_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_opi_api_network_v1alpha1_VlanSwitchedIf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanSwitchedIf_descriptor,
        new java.lang.String[] { "Config", "State", });
    internal_static_opi_api_network_v1alpha1_VlanIngressEgressSetting_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_opi_api_network_v1alpha1_VlanIngressEgressSetting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIngressEgressSetting_descriptor,
        new java.lang.String[] { "Vlanstackaction", "VlanId", "Tpid", });
    internal_static_opi_api_network_v1alpha1_VlanIf_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_opi_api_network_v1alpha1_VlanIf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_descriptor,
        new java.lang.String[] { "Match", "Ingressmapping", "Egressmapping", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_descriptor.getNestedTypes().get(0);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_descriptor,
        new java.lang.String[] { "Singletagged", "Singletaggedlist", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_descriptor.getNestedTypes().get(0);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_descriptor,
        new java.lang.String[] { "Config", "State", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagConfig_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_descriptor.getNestedTypes().get(0);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagConfig_descriptor,
        new java.lang.String[] { "VlanId", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagState_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_descriptor.getNestedTypes().get(1);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTagged_SingleTagState_descriptor,
        new java.lang.String[] { "VlanId", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_descriptor.getNestedTypes().get(1);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_descriptor,
        new java.lang.String[] { "Config", "Status", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListConfig_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_descriptor.getNestedTypes().get(0);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListConfig_descriptor,
        new java.lang.String[] { "VlanId", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListStatus_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_descriptor.getNestedTypes().get(1);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanMatch_SingleTaggedList_TagListStatus_descriptor,
        new java.lang.String[] { "Vlanid", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanIngressMapping_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_descriptor.getNestedTypes().get(1);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanIngressMapping_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanIngressMapping_descriptor,
        new java.lang.String[] { "Config", "State", });
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanEgressMapping_descriptor =
      internal_static_opi_api_network_v1alpha1_VlanIf_descriptor.getNestedTypes().get(2);
    internal_static_opi_api_network_v1alpha1_VlanIf_VlanEgressMapping_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opi_api_network_v1alpha1_VlanIf_VlanEgressMapping_descriptor,
        new java.lang.String[] { "Config", "State", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}