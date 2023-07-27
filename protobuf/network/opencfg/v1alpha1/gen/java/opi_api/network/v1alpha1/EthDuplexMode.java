// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: openconfig_ethernet.proto

package opi_api.network.v1alpha1;

/**
 * <pre>
 * Ethernet Duplex Mode Definitions
 * </pre>
 *
 * Protobuf enum {@code opi_api.network.v1alpha1.EthDuplexMode}
 */
public enum EthDuplexMode
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * Unspecified - interface will negotiate duplex speed directly
   * </pre>
   *
   * <code>ETH_DUPLEX_MODE_UNSPECIFIED = 0;</code>
   */
  ETH_DUPLEX_MODE_UNSPECIFIED(0),
  /**
   * <pre>
   * Specify Full Duplex mode in autonegotiation
   * </pre>
   *
   * <code>ETH_DUPLEX_MODE_FULL = 1;</code>
   */
  ETH_DUPLEX_MODE_FULL(1),
  /**
   * <pre>
   * Specify Half Duplex mode in autonegotiation
   * </pre>
   *
   * <code>ETH_DUPLEX_MODE_HALF = 2;</code>
   */
  ETH_DUPLEX_MODE_HALF(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * Unspecified - interface will negotiate duplex speed directly
   * </pre>
   *
   * <code>ETH_DUPLEX_MODE_UNSPECIFIED = 0;</code>
   */
  public static final int ETH_DUPLEX_MODE_UNSPECIFIED_VALUE = 0;
  /**
   * <pre>
   * Specify Full Duplex mode in autonegotiation
   * </pre>
   *
   * <code>ETH_DUPLEX_MODE_FULL = 1;</code>
   */
  public static final int ETH_DUPLEX_MODE_FULL_VALUE = 1;
  /**
   * <pre>
   * Specify Half Duplex mode in autonegotiation
   * </pre>
   *
   * <code>ETH_DUPLEX_MODE_HALF = 2;</code>
   */
  public static final int ETH_DUPLEX_MODE_HALF_VALUE = 2;


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
  public static EthDuplexMode valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EthDuplexMode forNumber(int value) {
    switch (value) {
      case 0: return ETH_DUPLEX_MODE_UNSPECIFIED;
      case 1: return ETH_DUPLEX_MODE_FULL;
      case 2: return ETH_DUPLEX_MODE_HALF;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EthDuplexMode>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EthDuplexMode> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EthDuplexMode>() {
          public EthDuplexMode findValueByNumber(int number) {
            return EthDuplexMode.forNumber(number);
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
    return opi_api.network.v1alpha1.OpenconfigEthernetProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final EthDuplexMode[] VALUES = values();

  public static EthDuplexMode valueOf(
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

  private EthDuplexMode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:opi_api.network.v1alpha1.EthDuplexMode)
}

