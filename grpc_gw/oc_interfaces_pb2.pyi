from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

DESCRIPTOR: _descriptor.FileDescriptor
DOWN: InterfaceState
ETHERNET: InterfaceType
LOOPBACK: InterfaceType
UP: InterfaceState

class Config(_message.Message):
    __slots__ = ["description", "enabled", "loopback_mode", "mtu", "name", "type"]
    DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
    ENABLED_FIELD_NUMBER: _ClassVar[int]
    LOOPBACK_MODE_FIELD_NUMBER: _ClassVar[int]
    MTU_FIELD_NUMBER: _ClassVar[int]
    NAME_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    description: str
    enabled: bool
    loopback_mode: bool
    mtu: int
    name: str
    type: InterfaceType
    def __init__(self, name: _Optional[str] = ..., type: _Optional[_Union[InterfaceType, str]] = ..., mtu: _Optional[int] = ..., loopback_mode: bool = ..., description: _Optional[str] = ..., enabled: bool = ...) -> None: ...

class Counters(_message.Message):
    __slots__ = ["carrier_transitions", "in_broadcast_pkts", "in_discards", "in_errors", "in_fcs_errors", "in_multicast_pkts", "in_octets", "in_packets", "in_unicast_pkts", "in_unknown_protos", "last_clear", "out_broadcast_pkts", "out_discards", "out_errors", "out_multicast_pkts", "out_octets", "out_packets", "out_unicast_pkts"]
    CARRIER_TRANSITIONS_FIELD_NUMBER: _ClassVar[int]
    IN_BROADCAST_PKTS_FIELD_NUMBER: _ClassVar[int]
    IN_DISCARDS_FIELD_NUMBER: _ClassVar[int]
    IN_ERRORS_FIELD_NUMBER: _ClassVar[int]
    IN_FCS_ERRORS_FIELD_NUMBER: _ClassVar[int]
    IN_MULTICAST_PKTS_FIELD_NUMBER: _ClassVar[int]
    IN_OCTETS_FIELD_NUMBER: _ClassVar[int]
    IN_PACKETS_FIELD_NUMBER: _ClassVar[int]
    IN_UNICAST_PKTS_FIELD_NUMBER: _ClassVar[int]
    IN_UNKNOWN_PROTOS_FIELD_NUMBER: _ClassVar[int]
    LAST_CLEAR_FIELD_NUMBER: _ClassVar[int]
    OUT_BROADCAST_PKTS_FIELD_NUMBER: _ClassVar[int]
    OUT_DISCARDS_FIELD_NUMBER: _ClassVar[int]
    OUT_ERRORS_FIELD_NUMBER: _ClassVar[int]
    OUT_MULTICAST_PKTS_FIELD_NUMBER: _ClassVar[int]
    OUT_OCTETS_FIELD_NUMBER: _ClassVar[int]
    OUT_PACKETS_FIELD_NUMBER: _ClassVar[int]
    OUT_UNICAST_PKTS_FIELD_NUMBER: _ClassVar[int]
    carrier_transitions: int
    in_broadcast_pkts: int
    in_discards: int
    in_errors: int
    in_fcs_errors: int
    in_multicast_pkts: int
    in_octets: int
    in_packets: int
    in_unicast_pkts: int
    in_unknown_protos: int
    last_clear: int
    out_broadcast_pkts: int
    out_discards: int
    out_errors: int
    out_multicast_pkts: int
    out_octets: int
    out_packets: int
    out_unicast_pkts: int
    def __init__(self, in_octets: _Optional[int] = ..., in_packets: _Optional[int] = ..., in_unicast_pkts: _Optional[int] = ..., in_broadcast_pkts: _Optional[int] = ..., in_multicast_pkts: _Optional[int] = ..., in_discards: _Optional[int] = ..., in_errors: _Optional[int] = ..., in_unknown_protos: _Optional[int] = ..., in_fcs_errors: _Optional[int] = ..., out_octets: _Optional[int] = ..., out_packets: _Optional[int] = ..., out_unicast_pkts: _Optional[int] = ..., out_broadcast_pkts: _Optional[int] = ..., out_multicast_pkts: _Optional[int] = ..., out_discards: _Optional[int] = ..., out_errors: _Optional[int] = ..., carrier_transitions: _Optional[int] = ..., last_clear: _Optional[int] = ...) -> None: ...

class Interface(_message.Message):
    __slots__ = ["config", "holdtime", "name", "state", "subinterfaces"]
    class HoldTime(_message.Message):
        __slots__ = ["hold_config", "hold_state"]
        class Hold_Config(_message.Message):
            __slots__ = ["down", "up"]
            DOWN_FIELD_NUMBER: _ClassVar[int]
            UP_FIELD_NUMBER: _ClassVar[int]
            down: int
            up: int
            def __init__(self, up: _Optional[int] = ..., down: _Optional[int] = ...) -> None: ...
        class Hold_State(_message.Message):
            __slots__ = ["down", "up"]
            DOWN_FIELD_NUMBER: _ClassVar[int]
            UP_FIELD_NUMBER: _ClassVar[int]
            down: int
            up: int
            def __init__(self, up: _Optional[int] = ..., down: _Optional[int] = ...) -> None: ...
        HOLD_CONFIG_FIELD_NUMBER: _ClassVar[int]
        HOLD_STATE_FIELD_NUMBER: _ClassVar[int]
        hold_config: Interface.HoldTime.Hold_Config
        hold_state: Interface.HoldTime.Hold_State
        def __init__(self, hold_config: _Optional[_Union[Interface.HoldTime.Hold_Config, _Mapping]] = ..., hold_state: _Optional[_Union[Interface.HoldTime.Hold_State, _Mapping]] = ...) -> None: ...
    class Subinterfaces(_message.Message):
        __slots__ = ["subinterface"]
        class Subinterface(_message.Message):
            __slots__ = ["index", "state", "subif_config"]
            class Subif_Config(_message.Message):
                __slots__ = ["description", "enabled", "index"]
                DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
                ENABLED_FIELD_NUMBER: _ClassVar[int]
                INDEX_FIELD_NUMBER: _ClassVar[int]
                description: str
                enabled: bool
                index: int
                def __init__(self, index: _Optional[int] = ..., description: _Optional[str] = ..., enabled: bool = ...) -> None: ...
            INDEX_FIELD_NUMBER: _ClassVar[int]
            STATE_FIELD_NUMBER: _ClassVar[int]
            SUBIF_CONFIG_FIELD_NUMBER: _ClassVar[int]
            index: int
            state: State
            subif_config: Interface.Subinterfaces.Subinterface.Subif_Config
            def __init__(self, index: _Optional[int] = ..., subif_config: _Optional[_Union[Interface.Subinterfaces.Subinterface.Subif_Config, _Mapping]] = ..., state: _Optional[_Union[State, _Mapping]] = ...) -> None: ...
        SUBINTERFACE_FIELD_NUMBER: _ClassVar[int]
        subinterface: _containers.RepeatedCompositeFieldContainer[Interface.Subinterfaces.Subinterface]
        def __init__(self, subinterface: _Optional[_Iterable[_Union[Interface.Subinterfaces.Subinterface, _Mapping]]] = ...) -> None: ...
    CONFIG_FIELD_NUMBER: _ClassVar[int]
    HOLDTIME_FIELD_NUMBER: _ClassVar[int]
    NAME_FIELD_NUMBER: _ClassVar[int]
    STATE_FIELD_NUMBER: _ClassVar[int]
    SUBINTERFACES_FIELD_NUMBER: _ClassVar[int]
    config: Config
    holdtime: Interface.HoldTime
    name: str
    state: State
    subinterfaces: Interface.Subinterfaces
    def __init__(self, name: _Optional[str] = ..., config: _Optional[_Union[Config, _Mapping]] = ..., state: _Optional[_Union[State, _Mapping]] = ..., holdtime: _Optional[_Union[Interface.HoldTime, _Mapping]] = ..., subinterfaces: _Optional[_Union[Interface.Subinterfaces, _Mapping]] = ...) -> None: ...

class Interfaces(_message.Message):
    __slots__ = ["interface"]
    INTERFACE_FIELD_NUMBER: _ClassVar[int]
    interface: _containers.RepeatedCompositeFieldContainer[Interface]
    def __init__(self, interface: _Optional[_Iterable[_Union[Interface, _Mapping]]] = ...) -> None: ...

class NetInterfaceGetRequest(_message.Message):
    __slots__ = ["name"]
    NAME_FIELD_NUMBER: _ClassVar[int]
    name: str
    def __init__(self, name: _Optional[str] = ...) -> None: ...

class NetInterfaceGetResponse(_message.Message):
    __slots__ = ["interface"]
    INTERFACE_FIELD_NUMBER: _ClassVar[int]
    interface: Interface
    def __init__(self, interface: _Optional[_Union[Interface, _Mapping]] = ...) -> None: ...

class NetInterfaceListRequest(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class NetInterfaceListResponse(_message.Message):
    __slots__ = ["interface"]
    INTERFACE_FIELD_NUMBER: _ClassVar[int]
    interface: _containers.RepeatedCompositeFieldContainer[Interface]
    def __init__(self, interface: _Optional[_Iterable[_Union[Interface, _Mapping]]] = ...) -> None: ...

class NetInterfaceUpdateRequest(_message.Message):
    __slots__ = ["interface"]
    INTERFACE_FIELD_NUMBER: _ClassVar[int]
    interface: Interface
    def __init__(self, interface: _Optional[_Union[Interface, _Mapping]] = ...) -> None: ...

class NetInterfaceUpdateResponse(_message.Message):
    __slots__ = ["result"]
    RESULT_FIELD_NUMBER: _ClassVar[int]
    result: int
    def __init__(self, result: _Optional[int] = ...) -> None: ...

class State(_message.Message):
    __slots__ = ["admin_status", "counters", "cpu", "description", "enabled", "ifindex", "last_change", "logical", "loopback_mode", "management", "mtu", "name", "oper_status", "type"]
    ADMIN_STATUS_FIELD_NUMBER: _ClassVar[int]
    COUNTERS_FIELD_NUMBER: _ClassVar[int]
    CPU_FIELD_NUMBER: _ClassVar[int]
    DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
    ENABLED_FIELD_NUMBER: _ClassVar[int]
    IFINDEX_FIELD_NUMBER: _ClassVar[int]
    LAST_CHANGE_FIELD_NUMBER: _ClassVar[int]
    LOGICAL_FIELD_NUMBER: _ClassVar[int]
    LOOPBACK_MODE_FIELD_NUMBER: _ClassVar[int]
    MANAGEMENT_FIELD_NUMBER: _ClassVar[int]
    MTU_FIELD_NUMBER: _ClassVar[int]
    NAME_FIELD_NUMBER: _ClassVar[int]
    OPER_STATUS_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    admin_status: InterfaceState
    counters: Counters
    cpu: bool
    description: str
    enabled: bool
    ifindex: int
    last_change: int
    logical: bool
    loopback_mode: bool
    management: bool
    mtu: int
    name: str
    oper_status: InterfaceState
    type: InterfaceType
    def __init__(self, name: _Optional[str] = ..., type: _Optional[_Union[InterfaceType, str]] = ..., mtu: _Optional[int] = ..., loopback_mode: bool = ..., description: _Optional[str] = ..., enabled: bool = ..., ifindex: _Optional[int] = ..., admin_status: _Optional[_Union[InterfaceState, str]] = ..., oper_status: _Optional[_Union[InterfaceState, str]] = ..., last_change: _Optional[int] = ..., logical: bool = ..., management: bool = ..., cpu: bool = ..., counters: _Optional[_Union[Counters, _Mapping]] = ...) -> None: ...

class InterfaceType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

class InterfaceState(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []
