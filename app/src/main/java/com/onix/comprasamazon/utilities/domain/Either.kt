package com.onix.comprasamazon.utilities.domain

class Either<l,R> private constructor(
    private var right: R? = null,
    private var left: l? = null
) {
    companion object {
        fun <R> right(right: R): Either<Nothing,R> {
            return Either(right)
        }

        fun <l> left(left: l): Either<l, Nothing> {
            return Either(left=left)
        }
    }

    fun isRight(): Boolean {
        return right != null
    }
}