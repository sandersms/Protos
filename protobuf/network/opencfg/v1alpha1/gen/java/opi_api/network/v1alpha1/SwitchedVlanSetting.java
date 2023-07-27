// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: openconfig_vlan.proto

package opi_api.network.v1alpha1;

/**
 * <pre>
 * Switched VLAN Configuration Settings that are part of the Ethernet interface
 * </pre>
 *
 * Protobuf type {@code opi_api.network.v1alpha1.SwitchedVlanSetting}
 */
public final class SwitchedVlanSetting extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:opi_api.network.v1alpha1.SwitchedVlanSetting)
    SwitchedVlanSettingOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SwitchedVlanSetting.newBuilder() to construct.
  private SwitchedVlanSetting(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SwitchedVlanSetting() {
    vlanInterfaceMode_ = 0;
    trunkVlans_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SwitchedVlanSetting();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SwitchedVlanSetting(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            vlanInterfaceMode_ = rawValue;
            break;
          }
          case 16: {

            nativeVlan_ = input.readUInt32();
            break;
          }
          case 24: {

            accessVlan_ = input.readUInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            trunkVlans_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return opi_api.network.v1alpha1.OpenconfigVlanProto.internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return opi_api.network.v1alpha1.OpenconfigVlanProto.internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            opi_api.network.v1alpha1.SwitchedVlanSetting.class, opi_api.network.v1alpha1.SwitchedVlanSetting.Builder.class);
  }

  public static final int VLAN_INTERFACE_MODE_FIELD_NUMBER = 1;
  private int vlanInterfaceMode_;
  /**
   * <pre>
   * Setting for the VLAN interface to access or trunk mode
   * </pre>
   *
   * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
   * @return The enum numeric value on the wire for vlanInterfaceMode.
   */
  @java.lang.Override public int getVlanInterfaceModeValue() {
    return vlanInterfaceMode_;
  }
  /**
   * <pre>
   * Setting for the VLAN interface to access or trunk mode
   * </pre>
   *
   * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
   * @return The vlanInterfaceMode.
   */
  @java.lang.Override public opi_api.network.v1alpha1.VlanIfMode getVlanInterfaceMode() {
    @SuppressWarnings("deprecation")
    opi_api.network.v1alpha1.VlanIfMode result = opi_api.network.v1alpha1.VlanIfMode.valueOf(vlanInterfaceMode_);
    return result == null ? opi_api.network.v1alpha1.VlanIfMode.UNRECOGNIZED : result;
  }

  public static final int NATIVE_VLAN_FIELD_NUMBER = 2;
  private int nativeVlan_;
  /**
   * <pre>
   * VLAN ID when the mode is set to trunk mode
   * </pre>
   *
   * <code>uint32 native_vlan = 2;</code>
   * @return The nativeVlan.
   */
  @java.lang.Override
  public int getNativeVlan() {
    return nativeVlan_;
  }

  public static final int ACCESS_VLAN_FIELD_NUMBER = 3;
  private int accessVlan_;
  /**
   * <pre>
   * VLAN ID when the mode is set to access mode
   * </pre>
   *
   * <code>uint32 access_vlan = 3;</code>
   * @return The accessVlan.
   */
  @java.lang.Override
  public int getAccessVlan() {
    return accessVlan_;
  }

  public static final int TRUNK_VLANS_FIELD_NUMBER = 4;
  private volatile java.lang.Object trunkVlans_;
  /**
   * <pre>
   * Allowed VLANs may be specified for trunk mode interfaces
   * </pre>
   *
   * <code>string trunk_vlans = 4;</code>
   * @return The trunkVlans.
   */
  @java.lang.Override
  public java.lang.String getTrunkVlans() {
    java.lang.Object ref = trunkVlans_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      trunkVlans_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Allowed VLANs may be specified for trunk mode interfaces
   * </pre>
   *
   * <code>string trunk_vlans = 4;</code>
   * @return The bytes for trunkVlans.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTrunkVlansBytes() {
    java.lang.Object ref = trunkVlans_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      trunkVlans_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (vlanInterfaceMode_ != opi_api.network.v1alpha1.VlanIfMode.VLAN_IF_MODE_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, vlanInterfaceMode_);
    }
    if (nativeVlan_ != 0) {
      output.writeUInt32(2, nativeVlan_);
    }
    if (accessVlan_ != 0) {
      output.writeUInt32(3, accessVlan_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(trunkVlans_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, trunkVlans_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (vlanInterfaceMode_ != opi_api.network.v1alpha1.VlanIfMode.VLAN_IF_MODE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, vlanInterfaceMode_);
    }
    if (nativeVlan_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, nativeVlan_);
    }
    if (accessVlan_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, accessVlan_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(trunkVlans_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, trunkVlans_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof opi_api.network.v1alpha1.SwitchedVlanSetting)) {
      return super.equals(obj);
    }
    opi_api.network.v1alpha1.SwitchedVlanSetting other = (opi_api.network.v1alpha1.SwitchedVlanSetting) obj;

    if (vlanInterfaceMode_ != other.vlanInterfaceMode_) return false;
    if (getNativeVlan()
        != other.getNativeVlan()) return false;
    if (getAccessVlan()
        != other.getAccessVlan()) return false;
    if (!getTrunkVlans()
        .equals(other.getTrunkVlans())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VLAN_INTERFACE_MODE_FIELD_NUMBER;
    hash = (53 * hash) + vlanInterfaceMode_;
    hash = (37 * hash) + NATIVE_VLAN_FIELD_NUMBER;
    hash = (53 * hash) + getNativeVlan();
    hash = (37 * hash) + ACCESS_VLAN_FIELD_NUMBER;
    hash = (53 * hash) + getAccessVlan();
    hash = (37 * hash) + TRUNK_VLANS_FIELD_NUMBER;
    hash = (53 * hash) + getTrunkVlans().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static opi_api.network.v1alpha1.SwitchedVlanSetting parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(opi_api.network.v1alpha1.SwitchedVlanSetting prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Switched VLAN Configuration Settings that are part of the Ethernet interface
   * </pre>
   *
   * Protobuf type {@code opi_api.network.v1alpha1.SwitchedVlanSetting}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:opi_api.network.v1alpha1.SwitchedVlanSetting)
      opi_api.network.v1alpha1.SwitchedVlanSettingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return opi_api.network.v1alpha1.OpenconfigVlanProto.internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return opi_api.network.v1alpha1.OpenconfigVlanProto.internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              opi_api.network.v1alpha1.SwitchedVlanSetting.class, opi_api.network.v1alpha1.SwitchedVlanSetting.Builder.class);
    }

    // Construct using opi_api.network.v1alpha1.SwitchedVlanSetting.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      vlanInterfaceMode_ = 0;

      nativeVlan_ = 0;

      accessVlan_ = 0;

      trunkVlans_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return opi_api.network.v1alpha1.OpenconfigVlanProto.internal_static_opi_api_network_v1alpha1_SwitchedVlanSetting_descriptor;
    }

    @java.lang.Override
    public opi_api.network.v1alpha1.SwitchedVlanSetting getDefaultInstanceForType() {
      return opi_api.network.v1alpha1.SwitchedVlanSetting.getDefaultInstance();
    }

    @java.lang.Override
    public opi_api.network.v1alpha1.SwitchedVlanSetting build() {
      opi_api.network.v1alpha1.SwitchedVlanSetting result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public opi_api.network.v1alpha1.SwitchedVlanSetting buildPartial() {
      opi_api.network.v1alpha1.SwitchedVlanSetting result = new opi_api.network.v1alpha1.SwitchedVlanSetting(this);
      result.vlanInterfaceMode_ = vlanInterfaceMode_;
      result.nativeVlan_ = nativeVlan_;
      result.accessVlan_ = accessVlan_;
      result.trunkVlans_ = trunkVlans_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof opi_api.network.v1alpha1.SwitchedVlanSetting) {
        return mergeFrom((opi_api.network.v1alpha1.SwitchedVlanSetting)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(opi_api.network.v1alpha1.SwitchedVlanSetting other) {
      if (other == opi_api.network.v1alpha1.SwitchedVlanSetting.getDefaultInstance()) return this;
      if (other.vlanInterfaceMode_ != 0) {
        setVlanInterfaceModeValue(other.getVlanInterfaceModeValue());
      }
      if (other.getNativeVlan() != 0) {
        setNativeVlan(other.getNativeVlan());
      }
      if (other.getAccessVlan() != 0) {
        setAccessVlan(other.getAccessVlan());
      }
      if (!other.getTrunkVlans().isEmpty()) {
        trunkVlans_ = other.trunkVlans_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      opi_api.network.v1alpha1.SwitchedVlanSetting parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (opi_api.network.v1alpha1.SwitchedVlanSetting) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int vlanInterfaceMode_ = 0;
    /**
     * <pre>
     * Setting for the VLAN interface to access or trunk mode
     * </pre>
     *
     * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
     * @return The enum numeric value on the wire for vlanInterfaceMode.
     */
    @java.lang.Override public int getVlanInterfaceModeValue() {
      return vlanInterfaceMode_;
    }
    /**
     * <pre>
     * Setting for the VLAN interface to access or trunk mode
     * </pre>
     *
     * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
     * @param value The enum numeric value on the wire for vlanInterfaceMode to set.
     * @return This builder for chaining.
     */
    public Builder setVlanInterfaceModeValue(int value) {
      
      vlanInterfaceMode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Setting for the VLAN interface to access or trunk mode
     * </pre>
     *
     * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
     * @return The vlanInterfaceMode.
     */
    @java.lang.Override
    public opi_api.network.v1alpha1.VlanIfMode getVlanInterfaceMode() {
      @SuppressWarnings("deprecation")
      opi_api.network.v1alpha1.VlanIfMode result = opi_api.network.v1alpha1.VlanIfMode.valueOf(vlanInterfaceMode_);
      return result == null ? opi_api.network.v1alpha1.VlanIfMode.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Setting for the VLAN interface to access or trunk mode
     * </pre>
     *
     * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
     * @param value The vlanInterfaceMode to set.
     * @return This builder for chaining.
     */
    public Builder setVlanInterfaceMode(opi_api.network.v1alpha1.VlanIfMode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      vlanInterfaceMode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Setting for the VLAN interface to access or trunk mode
     * </pre>
     *
     * <code>.opi_api.network.v1alpha1.VlanIfMode vlan_interface_mode = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVlanInterfaceMode() {
      
      vlanInterfaceMode_ = 0;
      onChanged();
      return this;
    }

    private int nativeVlan_ ;
    /**
     * <pre>
     * VLAN ID when the mode is set to trunk mode
     * </pre>
     *
     * <code>uint32 native_vlan = 2;</code>
     * @return The nativeVlan.
     */
    @java.lang.Override
    public int getNativeVlan() {
      return nativeVlan_;
    }
    /**
     * <pre>
     * VLAN ID when the mode is set to trunk mode
     * </pre>
     *
     * <code>uint32 native_vlan = 2;</code>
     * @param value The nativeVlan to set.
     * @return This builder for chaining.
     */
    public Builder setNativeVlan(int value) {
      
      nativeVlan_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * VLAN ID when the mode is set to trunk mode
     * </pre>
     *
     * <code>uint32 native_vlan = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearNativeVlan() {
      
      nativeVlan_ = 0;
      onChanged();
      return this;
    }

    private int accessVlan_ ;
    /**
     * <pre>
     * VLAN ID when the mode is set to access mode
     * </pre>
     *
     * <code>uint32 access_vlan = 3;</code>
     * @return The accessVlan.
     */
    @java.lang.Override
    public int getAccessVlan() {
      return accessVlan_;
    }
    /**
     * <pre>
     * VLAN ID when the mode is set to access mode
     * </pre>
     *
     * <code>uint32 access_vlan = 3;</code>
     * @param value The accessVlan to set.
     * @return This builder for chaining.
     */
    public Builder setAccessVlan(int value) {
      
      accessVlan_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * VLAN ID when the mode is set to access mode
     * </pre>
     *
     * <code>uint32 access_vlan = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccessVlan() {
      
      accessVlan_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object trunkVlans_ = "";
    /**
     * <pre>
     * Allowed VLANs may be specified for trunk mode interfaces
     * </pre>
     *
     * <code>string trunk_vlans = 4;</code>
     * @return The trunkVlans.
     */
    public java.lang.String getTrunkVlans() {
      java.lang.Object ref = trunkVlans_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        trunkVlans_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Allowed VLANs may be specified for trunk mode interfaces
     * </pre>
     *
     * <code>string trunk_vlans = 4;</code>
     * @return The bytes for trunkVlans.
     */
    public com.google.protobuf.ByteString
        getTrunkVlansBytes() {
      java.lang.Object ref = trunkVlans_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        trunkVlans_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Allowed VLANs may be specified for trunk mode interfaces
     * </pre>
     *
     * <code>string trunk_vlans = 4;</code>
     * @param value The trunkVlans to set.
     * @return This builder for chaining.
     */
    public Builder setTrunkVlans(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      trunkVlans_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Allowed VLANs may be specified for trunk mode interfaces
     * </pre>
     *
     * <code>string trunk_vlans = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearTrunkVlans() {
      
      trunkVlans_ = getDefaultInstance().getTrunkVlans();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Allowed VLANs may be specified for trunk mode interfaces
     * </pre>
     *
     * <code>string trunk_vlans = 4;</code>
     * @param value The bytes for trunkVlans to set.
     * @return This builder for chaining.
     */
    public Builder setTrunkVlansBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      trunkVlans_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:opi_api.network.v1alpha1.SwitchedVlanSetting)
  }

  // @@protoc_insertion_point(class_scope:opi_api.network.v1alpha1.SwitchedVlanSetting)
  private static final opi_api.network.v1alpha1.SwitchedVlanSetting DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new opi_api.network.v1alpha1.SwitchedVlanSetting();
  }

  public static opi_api.network.v1alpha1.SwitchedVlanSetting getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SwitchedVlanSetting>
      PARSER = new com.google.protobuf.AbstractParser<SwitchedVlanSetting>() {
    @java.lang.Override
    public SwitchedVlanSetting parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SwitchedVlanSetting(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SwitchedVlanSetting> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SwitchedVlanSetting> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public opi_api.network.v1alpha1.SwitchedVlanSetting getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

