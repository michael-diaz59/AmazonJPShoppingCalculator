package com.onix.comprasamazon.features.products.repository

import com.onix.comprasamazon.features.buyer.domian.Buyer
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductGateway
import com.onix.comprasamazon.features.products.repository.room.RoomProduct
import com.onix.comprasamazon.utilities.domain.Either
import com.onix.comprasamazon.utilities.domain.GatewayException
import com.onix.comprasamazon.utilities.repository.room.DBRoom

class HandleProductRepository: ProductGateway{
    private val dao: RoomProduct= RoomProduct(buyer= 0 ,name = "")
    override fun createProduct(): Either<GatewayException, Boolean> {
        val roomProduct=DBRoom.
    }

    override fun editProduct(): Either<GatewayException, Boolean> {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(): Either<GatewayException, Boolean> {
        TODO("Not yet implemented")
    }

    override fun getProducts(): Either<GatewayException, List<BaseProduct>> {
        TODO("Not yet implemented")
    }
}