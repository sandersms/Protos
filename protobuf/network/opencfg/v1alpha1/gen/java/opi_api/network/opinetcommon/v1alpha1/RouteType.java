// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: networktypes.proto

package opi_api.network.opinetcommon.v1alpha1;

/**
 * <pre>
 * route type
 * </pre>
 *
 * Protobuf enum {@code opi_api.network.opinetcommon.v1alpha1.RouteType}
 */
public enum RouteType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * unspecified
   * </pre>
   *
   * <code>ROUTE_TYPE_UNSPECIFIED = 0;</code>
   */
  ROUTE_TYPE_UNSPECIFIED(0),
  /**
   * <pre>
   * other
   * </pre>
   *
   * <code>ROUTE_TYPE_OTHER = 1;</code>
   */
  ROUTE_TYPE_OTHER(1),
  /**
   * <pre>
   * reject
   * </pre>
   *
   * <code>ROUTE_TYPE_REJECT = 2;</code>
   */
  ROUTE_TYPE_REJECT(2),
  /**
   * <pre>
   * local
   * </pre>
   *
   * <code>ROUTE_TYPE_LOCAL = 3;</code>
   */
  ROUTE_TYPE_LOCAL(3),
  /**
   * <pre>
   * remote
   * </pre>
   *
   * <code>ROUTE_TYPE_REMOTE = 4;</code>
   */
  ROUTE_TYPE_REMOTE(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * unspecified
   * </pre>
   *
   * <code>ROUTE_TYPE_UNSPECIFIED = 0;</code>
   */
  public static final int ROUTE_TYPE_UNSPECIFIED_VALUE = 0;
  /**
   * <pre>
   * other
   * </pre>
   *
   * <code>ROUTE_TYPE_OTHER = 1;</code>
   */
  public static final int ROUTE_TYPE_OTHER_VALUE = 1;
  /**
   * <pre>
   * reject
   * </pre>
   *
   * <code>ROUTE_TYPE_REJECT = 2;</code>
   */
  public static final int ROUTE_TYPE_REJECT_VALUE = 2;
  /**
   * <pre>
   * local
   * </pre>
   *
   * <code>ROUTE_TYPE_LOCAL = 3;</code>
   */
  public static final int ROUTE_TYPE_LOCAL_VALUE = 3;
  /**
   * <pre>
   * remote
   * </pre>
   *
   * <code>ROUTE_TYPE_REMOTE = 4;</code>
   */
  public static final int ROUTE_TYPE_REMOTE_VALUE = 4;


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
  public static RouteType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static RouteType forNumber(int value) {
    switch (value) {
      case 0: return ROUTE_TYPE_UNSPECIFIED;
      case 1: return ROUTE_TYPE_OTHER;
      case 2: return ROUTE_TYPE_REJECT;
      case 3: return ROUTE_TYPE_LOCAL;
      case 4: return ROUTE_TYPE_REMOTE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<RouteType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      RouteType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<RouteType>() {
          public RouteType findValueByNumber(int number) {
            return RouteType.forNumber(number);
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
    return opi_api.network.opinetcommon.v1alpha1.NetworkTypesProto.getDescriptor().getEnumTypes().get(3);
  }

  private static final RouteType[] VALUES = values();

  public static RouteType valueOf(
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

  private RouteType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:opi_api.network.opinetcommon.v1alpha1.RouteType)
}

