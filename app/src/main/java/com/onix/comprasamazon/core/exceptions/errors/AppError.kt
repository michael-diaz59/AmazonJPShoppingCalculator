package com.onix.comprasamazon.core.exceptions.errors

class AppError(

) {
    var errorTitle:String=""
    var errorDescriptionE: String=""
    var errorType: ErrorType = ErrorType.Null

    fun copy(appError: AppError){
        errorTitle=appError.errorTitle
        errorDescriptionE=appError.errorDescriptionE
        errorType=appError.errorType

    }
}