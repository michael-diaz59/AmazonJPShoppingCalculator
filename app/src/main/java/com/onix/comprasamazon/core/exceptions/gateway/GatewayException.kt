package com.onix.comprasamazon.core.exceptions.gateway

class GatewayException(var typeGatewayException: TypeGatewayException = TypeGatewayException.Null,
                       var additionalInfo: Map<String, Any> = mapOf()): Exception() {

}