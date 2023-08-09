// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: openconfig_ethernet.proto

package opi_api.network.v1alpha1;

/**
 * <pre>
 * Ethernet Forward Error Correction Mode Definitions
 * </pre>
 *
 * Protobuf enum {@code opi_api.network.v1alpha1.EthFecMode}
 */
public enum EthFecMode
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * Unspecified
   * </pre>
   *
   * <code>ETH_FEC_MODE_UNSPECIFIED = 0;</code>
   */
  ETH_FEC_MODE_UNSPECIFIED(0),
  /**
   * <pre>
   * Firecode for NRZ channels with less then 100G
   * </pre>
   *
   * <code>ETH_FEC_MODE_FC = 1;</code>
   */
  ETH_FEC_MODE_FC(1),
  /**
   * <pre>
   * RS528 is used for channels with NRZ modulation. This FEC is designed to
   * comply with IEEE 802.3, Clause 91.
   * </pre>
   *
   * <code>ETH_FEC_MODE_RS528 = 2;</code>
   */
  ETH_FEC_MODE_RS528(2),
  /**
   * <pre>
   * RS544 is used for channels with PAM4 modulation
   * </pre>
   *
   * <code>ETH_FEC_MODE_RS544 = 3;</code>
   */
  ETH_FEC_MODE_RS544(3),
  /**
   * <pre>
   * RS544-2x-interleave is used for channels with PAM4 modulation
   * </pre>
   *
   * <code>ETH_FEC_MODE_RS544_2X_INTERLEAVE = 4;</code>
   */
  ETH_FEC_MODE_RS544_2X_INTERLEAVE(4),
  /**
   * <pre>
   * FEC is administratively disabled
   * </pre>
   *
   * <code>ETH_FEC_MODE_DISABLED = 5;</code>
   */
  ETH_FEC_MODE_DISABLED(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * Unspecified
   * </pre>
   *
   * <code>ETH_FEC_MODE_UNSPECIFIED = 0;</code>
   */
  public static final int ETH_FEC_MODE_UNSPECIFIED_VALUE = 0;
  /**
   * <pre>
   * Firecode for NRZ channels with less then 100G
   * </pre>
   *
   * <code>ETH_FEC_MODE_FC = 1;</code>
   */
  public static final int ETH_FEC_MODE_FC_VALUE = 1;
  /**
   * <pre>
   * RS528 is used for channels with NRZ modulation. This FEC is designed to
   * comply with IEEE 802.3, Clause 91.
   * </pre>
   *
   * <code>ETH_FEC_MODE_RS528 = 2;</code>
   */
  public static final int ETH_FEC_MODE_RS528_VALUE = 2;
  /**
   * <pre>
   * RS544 is used for channels with PAM4 modulation
   * </pre>
   *
   * <code>ETH_FEC_MODE_RS544 = 3;</code>
   */
  public static final int ETH_FEC_MODE_RS544_VALUE = 3;
  /**
   * <pre>
   * RS544-2x-interleave is used for channels with PAM4 modulation
   * </pre>
   *
   * <code>ETH_FEC_MODE_RS544_2X_INTERLEAVE = 4;</code>
   */
  public static final int ETH_FEC_MODE_RS544_2X_INTERLEAVE_VALUE = 4;
  /**
   * <pre>
   * FEC is administratively disabled
   * </pre>
   *
   * <code>ETH_FEC_MODE_DISABLED = 5;</code>
   */
  public static final int ETH_FEC_MODE_DISABLED_VALUE = 5;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static EthFecMode valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EthFecMode forNumber(int value) {
    switch (value) {
      case 0: return ETH_FEC_MODE_UNSPECIFIED;
      case 1: return ETH_FEC_MODE_FC;
      case 2: return ETH_FEC_MODE_RS528;
      case 3: return ETH_FEC_MODE_RS544;
      case 4: return ETH_FEC_MODE_RS544_2X_INTERLEAVE;
      case 5: return ETH_FEC_MODE_DISABLED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EthFecMode>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EthFecMode> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EthFecMode>() {
          public EthFecMode findValueByNumber(int number) {
            return EthFecMode.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return opi_api.network.v1alpha1.OpenconfigEthernetProto.getDescriptor().getEnumTypes().get(2);
  }

  private static final EthFecMode[] VALUES = values();

  public static EthFecMode valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private EthFecMode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:opi_api.network.v1alpha1.EthFecMode)
}
