# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import oc_interfaces_pb2 as oc__interfaces__pb2


class NetInterfaceStub(object):
    """Service functions for Network Interface exported by the server
    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.NetInterfaceGet = channel.unary_unary(
                '/opi_api.network.v1.NetInterface/NetInterfaceGet',
                request_serializer=oc__interfaces__pb2.NetInterfaceGetRequest.SerializeToString,
                response_deserializer=oc__interfaces__pb2.NetInterfaceGetResponse.FromString,
                )
        self.NetInterfaceList = channel.unary_unary(
                '/opi_api.network.v1.NetInterface/NetInterfaceList',
                request_serializer=oc__interfaces__pb2.NetInterfaceListRequest.SerializeToString,
                response_deserializer=oc__interfaces__pb2.NetInterfaceListResponse.FromString,
                )
        self.NetInterfaceUpdate = channel.unary_unary(
                '/opi_api.network.v1.NetInterface/NetInterfaceUpdate',
                request_serializer=oc__interfaces__pb2.NetInterfaceUpdateRequest.SerializeToString,
                response_deserializer=oc__interfaces__pb2.NetInterfaceUpdateResponse.FromString,
                )


class NetInterfaceServicer(object):
    """Service functions for Network Interface exported by the server
    """

    def NetInterfaceGet(self, request, context):
        """Retrieves the interface information for a given interface
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def NetInterfaceList(self, request, context):
        """Retrieves the set of interfaces on the device
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def NetInterfaceUpdate(self, request, context):
        """A method for setting or changing configuration of an interface
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_NetInterfaceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'NetInterfaceGet': grpc.unary_unary_rpc_method_handler(
                    servicer.NetInterfaceGet,
                    request_deserializer=oc__interfaces__pb2.NetInterfaceGetRequest.FromString,
                    response_serializer=oc__interfaces__pb2.NetInterfaceGetResponse.SerializeToString,
            ),
            'NetInterfaceList': grpc.unary_unary_rpc_method_handler(
                    servicer.NetInterfaceList,
                    request_deserializer=oc__interfaces__pb2.NetInterfaceListRequest.FromString,
                    response_serializer=oc__interfaces__pb2.NetInterfaceListResponse.SerializeToString,
            ),
            'NetInterfaceUpdate': grpc.unary_unary_rpc_method_handler(
                    servicer.NetInterfaceUpdate,
                    request_deserializer=oc__interfaces__pb2.NetInterfaceUpdateRequest.FromString,
                    response_serializer=oc__interfaces__pb2.NetInterfaceUpdateResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'opi_api.network.v1.NetInterface', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class NetInterface(object):
    """Service functions for Network Interface exported by the server
    """

    @staticmethod
    def NetInterfaceGet(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/opi_api.network.v1.NetInterface/NetInterfaceGet',
            oc__interfaces__pb2.NetInterfaceGetRequest.SerializeToString,
            oc__interfaces__pb2.NetInterfaceGetResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def NetInterfaceList(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/opi_api.network.v1.NetInterface/NetInterfaceList',
            oc__interfaces__pb2.NetInterfaceListRequest.SerializeToString,
            oc__interfaces__pb2.NetInterfaceListResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def NetInterfaceUpdate(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/opi_api.network.v1.NetInterface/NetInterfaceUpdate',
            oc__interfaces__pb2.NetInterfaceUpdateRequest.SerializeToString,
            oc__interfaces__pb2.NetInterfaceUpdateResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
