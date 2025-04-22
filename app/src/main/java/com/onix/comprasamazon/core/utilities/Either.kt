package com.onix.comprasamazon.core.utilities

class Either<l,R> private constructor(
    private var right: R? = null,
    private var left: l? = null
) {
    companion object {
        fun <L,R> right(right: R): Either<L, R> {
            return Either(right=right, left = null)
        }

        fun <l,R> left(left: l): Either<l, R> {
            return Either(right=null,left=left)
        }
    }

    fun getRight(): R? {
        return right
    }

    fun getLeft(): l? {
        return left
    }


    fun isRight(): Boolean {
        return right != null
    }
}