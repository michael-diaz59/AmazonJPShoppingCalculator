package com.onix.comprasamazon.features.products.data.local

import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductGateway
import com.onix.comprasamazon.features.products.data.local.room.RoomProduct
import com.onix.comprasamazon.core.utilities.Either
import com.onix.comprasamazon.core.exceptions.gateway.GatewayException
import com.onix.comprasamazon.core.exceptions.gateway.TypeGatewayException
import com.onix.comprasamazon.features.products.data.local.room.DAOProduct
import javax.inject.Inject

class LocalProductManager @Inject constructor( private val productRoomDB: DAOProduct): ProductGateway{

    override suspend fun createProduct(product: BaseProduct): Either<GatewayException, Long> {
        val insert:Long

        var error: GatewayException

        val rEither : Either<GatewayException, Long>

        try {
            insert = productRoomDB.insert(RoomProduct.baseToRoom(product))
            if(insert!=0L){
                rEither = Either.right(insert)

            }else{
                error= GatewayException(TypeGatewayException.UnKnow,
                    mapOf<String,String>("descripcion" to "error desconocido")
                )
                rEither = Either.left(error)
            }

            return rEither

        }catch (e: Exception){
            error= GatewayException(TypeGatewayException.UnKnow,
                mapOf<String,String>("descripcion" to "error desconocido")
            )

            return  Either.left(error)
        }

    }

    override fun editProduct(product: BaseProduct): Either<GatewayException, Boolean> {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(product: BaseProduct): Either<GatewayException, Boolean> {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Either<GatewayException, List<BaseProduct>> {
        TODO("Not yet implemented")
    }
}