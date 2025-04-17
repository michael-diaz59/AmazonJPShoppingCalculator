package com.onix.comprasamazon.utilities.domain

class GatewayException: Exception() {
    var typeGatewayException: TypeGatewayException=TypeGatewayException.Null
    var additionalInfo: Map<String, Any> = mapOf()
}

enum class TypeGatewayException{
    DataIntegrityViolationException, IllegalArgument, DataAccessException, UnKnow, Null
}