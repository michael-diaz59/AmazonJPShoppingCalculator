package com.onix.comprasamazon.utilities.domain

class Result<T> private constructor(
    private var isSuccessful: Boolean = false,
    private var error: AppError? = null,
    private var value: T? = null
) {

    companion object {
        fun <T> success(value: T): Result<T> {
            return Result(true, null, value)
        }

        fun failure(error: AppError): Result<Nothing> {
            return Result(false, error)
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