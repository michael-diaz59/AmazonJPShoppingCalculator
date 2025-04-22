package com.onix.comprasamazon.core.exceptions.gateway

class GatewayException(
    var typeGatewayException: TypeGatewayException = TypeGatewayException.Null,
    var additionalInfo: Map<String, Any> = mapOf(),
    override var  message: String="",
    override var cause:Throwable
): Exception() {

}