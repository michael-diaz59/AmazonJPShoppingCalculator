package com.onix.comprasamazon.core.domain

import com.onix.comprasamazon.core.exceptions.errors.AppError
import com.onix.comprasamazon.core.exceptions.errors.ErrorType


abstract class UseCase<T> {
    protected var value: T?=null
    protected var isSuccessful: Boolean = false
    protected var appError: AppError?=null



    fun getValueCase(): T? {
        return value
    }

    fun getError(): AppError {
        val errorR= AppError()
        if (appError == null) {
            println("error in order of execute or creation of responseError");
            errorR.errorTitle = "error no mapeado"
            errorR.errorDescriptionE =
                "por favor comunicarse con el desarrollador al correo michaeldiaz595@gmail.com describiendo los pasos para generar el error"
            errorR.errorType = ErrorType.FatalError
            return errorR;
        }
        return appError as AppError


    }


    fun getState(): Boolean {
        return isSuccessful && value!=null
    }
}