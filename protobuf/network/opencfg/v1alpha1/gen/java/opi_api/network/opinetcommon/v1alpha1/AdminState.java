// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: networktypes.proto

package opi_api.network.opinetcommon.v1alpha1;

/**
 * <pre>
 * admin state of control plane objects
 * </pre>
 *
 * Protobuf enum {@code opi_api.network.opinetcommon.v1alpha1.AdminState}
 */
public enum AdminState
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * unspecified
   * </pre>
   *
   * <code>ADMIN_STATE_UNSPECIFIED = 0;</code>
   */
  ADMIN_STATE_UNSPECIFIED(0),
  /**
   * <pre>
   * enable
   * </pre>
   *
   * <code>ADMIN_STATE_ENABLE = 1;</code>
   */
  ADMIN_STATE_ENABLE(1),
  /**
   * <pre>
   * disable
   * </pre>
   *
   * <code>ADMIN_STATE_DISABLE = 2;</code>
   */
  ADMIN_STATE_DISABLE(2),
  /**
   * <pre>
   * testing
   * </pre>
   *
   * <code>ADMIN_STATE_TESTING = 3;</code>
   */
  ADMIN_STATE_TESTING(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * unspecified
   * </pre>
   *
   * <code>ADMIN_STATE_UNSPECIFIED = 0;</code>
   */
  public static final int ADMIN_STATE_UNSPECIFIED_VALUE = 0;
  /**
   * <pre>
   * enable
   * </pre>
   *
   * <code>ADMIN_STATE_ENABLE = 1;</code>
   */
  public static final int ADMIN_STATE_ENABLE_VALUE = 1;
  /**
   * <pre>
   * disable
   * </pre>
   *
   * <code>ADMIN_STATE_DISABLE = 2;</code>
   */
  public static final int ADMIN_STATE_DISABLE_VALUE = 2;
  /**
   * <pre>
   * testing
   * </pre>
   *
   * <code>ADMIN_STATE_TESTING = 3;</code>
   */
  public static final int ADMIN_STATE_TESTING_VALUE = 3;


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
  public static AdminState valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static AdminState forNumber(int value) {
    switch (value) {
      case 0: return ADMIN_STATE_UNSPECIFIED;
      case 1: return ADMIN_STATE_ENABLE;
      case 2: return ADMIN_STATE_DISABLE;
      case 3: return ADMIN_STATE_TESTING;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AdminState>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AdminState> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AdminState>() {
          public AdminState findValueByNumber(int number) {
            return AdminState.forNumber(number);
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
    return opi_api.network.opinetcommon.v1alpha1.NetworkTypesProto.getDescriptor().getEnumTypes().get(5);
  }

  private static final AdminState[] VALUES = values();

  public static AdminState valueOf(
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

  private AdminState(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:opi_api.network.opinetcommon.v1alpha1.AdminState)
}
