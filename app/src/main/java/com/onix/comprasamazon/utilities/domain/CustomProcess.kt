package com.onix.comprasamazon.utilities.domain

class CustomProcess private constructor(private var isSuccessful: Boolean = false,private var error: AppError? = null) {
    companion object {
        fun success(): CustomProcess {
            return CustomProcess(true, null)
        }

        fun failure(error: AppError): CustomProcess {
            return CustomProcess(false, error)
        }
    }

    fun getError():AppError?{
        return error
    }

    fun isSuccessful():Boolean{
        return isSuccessful
    }
}