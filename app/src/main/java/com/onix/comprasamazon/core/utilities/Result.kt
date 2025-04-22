package com.onix.comprasamazon.core.utilities

import com.onix.comprasamazon.core.exceptions.errors.AppError

class ResultO<T> private constructor(
    private var isSuccessful: Boolean = false,
    private var error: AppError? = null,
    private var value: T? = null
) {

    companion object {
        fun <T> success(value: T): ResultO<T> {
            return ResultO(true, null, value)
        }

        fun  <T> failure(error: AppError): ResultO<T> {
            return ResultO(false, error)
        }
    }

    fun getValue(): T? {
        if (isSuccessful) {
            return this.value
        }
        println("Trying to access a null value, error: $error")
        return null
    }

    fun isSuccessful(): Boolean {
        return isSuccessful
    }

    fun getError(): AppError? {
        return error
    }
}