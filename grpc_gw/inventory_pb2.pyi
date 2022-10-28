from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Mapping as _Mapping, Optional as _Optional, Union as _Union

API_STATUS_ERROR: APIStatus
API_STATUS_OK: APIStatus
DESCRIPTOR: _descriptor.FileDescriptor

class DeviceInfo(_message.Message):
    __slots__ = ["Description", "Name", "fw_version", "hw_version", "id", "mfg_date", "mfg_name", "part_no", "serial_no", "sw_version"]
    DESCRIPTION_FIELD_NUMBER: _ClassVar[int]
    Description: str
    FW_VERSION_FIELD_NUMBER: _ClassVar[int]
    HW_VERSION_FIELD_NUMBER: _ClassVar[int]
    ID_FIELD_NUMBER: _ClassVar[int]
    MFG_DATE_FIELD_NUMBER: _ClassVar[int]
    MFG_NAME_FIELD_NUMBER: _ClassVar[int]
    NAME_FIELD_NUMBER: _ClassVar[int]
    Name: str
    PART_NO_FIELD_NUMBER: _ClassVar[int]
    SERIAL_NO_FIELD_NUMBER: _ClassVar[int]
    SW_VERSION_FIELD_NUMBER: _ClassVar[int]
    fw_version: str
    hw_version: str
    id: str
    mfg_date: str
    mfg_name: str
    part_no: str
    serial_no: str
    sw_version: str
    def __init__(self, Name: _Optional[str] = ..., Description: _Optional[str] = ..., id: _Optional[str] = ..., mfg_name: _Optional[str] = ..., mfg_date: _Optional[str] = ..., hw_version: _Optional[str] = ..., fw_version: _Optional[str] = ..., sw_version: _Optional[str] = ..., serial_no: _Optional[str] = ..., part_no: _Optional[str] = ...) -> None: ...

class Empty(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class InventoryGetResponse(_message.Message):
    __slots__ = ["DevInfo", "status"]
    DEVINFO_FIELD_NUMBER: _ClassVar[int]
    DevInfo: DeviceInfo
    STATUS_FIELD_NUMBER: _ClassVar[int]
    status: APIStatus
    def __init__(self, status: _Optional[_Union[APIStatus, str]] = ..., DevInfo: _Optional[_Union[DeviceInfo, _Mapping]] = ...) -> None: ...

class APIStatus(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []
