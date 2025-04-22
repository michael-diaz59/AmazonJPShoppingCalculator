package com.onix.comprasamazon.features.products.data.local

import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductGateway
import com.onix.comprasamazon.features.products.data.local.room.RoomProduct
import com.onix.comprasamazon.core.utilities.Either
import com.onix.comprasamazon.core.exceptions.gateway.GatewayException
import com.onix.comprasamazon.core.exceptions.gateway.TypeGatewayException
import com.onix.comprasamazon.features.products.data.local.room.DAOProduct
import javax.inject.Inject
import kotlin.toString

class LocalProductManager @Inject constructor(private val productRoomDB: DAOProduct) :
    ProductGateway {

    override suspend fun createProduct(product: BaseProduct): Either<GatewayException, Long> {
        val insert: Long

        var error: GatewayException

        val rEither: Either<GatewayException, Long>

        try {
            insert = productRoomDB.insert(RoomProduct.baseToRoom(product))
            if (insert != 0L) {
                rEither = Either.right(insert)

            } else {
                error = GatewayException(
                    TypeGatewayException.UnKnow,
                    mapOf<String, String>("objeto" to product.toString()),
                    "error desconocido",
                    Exception()
                )
                rEither = Either.left(error)
            }

            return rEither

        } catch (e: SQLiteConstraintException) {
            println("SQLiteConstraintException")
            println(e)
            error = GatewayException(
                TypeGatewayException.DataIntegrityViolationException,
                mapOf<String, String>("objeto" to product.toString()),
                e.message.toString(),
                e
            )
            return Either.left(error)
        } catch (e: SQLiteException) {
            error = GatewayException(
                TypeGatewayException.IllegalArgument,
                mapOf<String, String>("objeto" to product.toString()),
                e.message.toString(),
                e
            )
            return Either.left(error)
        }catch (e: Exception) {
            error = GatewayException(
                TypeGatewayException.UnKnow,
                mapOf<String, String>("objeto" to product.toString()),
                e.message.toString(),
                e
            )

            return Either.left(error)
        }
    }

    override suspend fun editProduct(product: BaseProduct): Either<GatewayException, Boolean> {
        val edit: Int

        var error: GatewayException

        var rEither: Either<GatewayException, Boolean>
        try {
            edit=productRoomDB.update(RoomProduct.baseToRoom(product))
            if (edit != 0) {
                rEither = Either.right(true)

            } else {
                error = GatewayException(
                    TypeGatewayException.UnKnow,
                    mapOf<String, String>("descripcion" to "error desconocido"),
                   "error desconocido",Throwable()
                )
                rEither = Either.left(error)
            }
        }catch (e:Exception){
            error = GatewayException(
                TypeGatewayException.UnKnow,
                mapOf<String, String>("objeto" to product.toString()),
                e.message.toString(),
                e
            )
            rEither=Either.left(error)
        }
        return rEither

    }

    override suspend fun deleteProduct(product: BaseProduct): Either<GatewayException, Boolean> {
        val delete: Int

        var error: GatewayException

        var rEither: Either<GatewayException, Boolean>
        try {
            delete=productRoomDB.delete(RoomProduct.baseToRoom(product))
            if (delete != 0) {
                rEither = Either.right(true)

            } else {
                error = GatewayException(
                    TypeGatewayException.UnKnow,
                    mapOf<String, String>("descripcion" to "error desconocido"),"error desconocido",Throwable()
                )
                rEither = Either.left(error)
            }
        }catch (e:Exception){
            error = GatewayException(
                TypeGatewayException.UnKnow,
                mapOf<String, String>("objeto" to product.toString()),
                e.message.toString(),
                e
            )
            rEither=Either.left(error)
        }
        return rEither
    }

    override suspend fun getProducts(): Either<GatewayException, List<BaseProduct>> {
        val get: List<BaseProduct>

        val error: GatewayException

        var rEither: Either<GatewayException, List<BaseProduct>>
        try {
            get=productRoomDB.getAll()
            rEither = Either.right(get)

        }catch (e:Exception){
            error = GatewayException(
                TypeGatewayException.UnKnow,
                mapOf<String, String>("objeto" to "ninguno"),
                e.message.toString(),
                e
            )
            rEither=Either.left(error)
        }

        return rEither
    }
}