package com.onix.comprasamazon.utilities.domain

class AppError(

) {
    var errorTitle:String=""
    var errorDescriptionE: String=""
    var errorType:ErrorType =ErrorType.Null
}

enum class ErrorType {
    WarningError, FatalError, Null
}