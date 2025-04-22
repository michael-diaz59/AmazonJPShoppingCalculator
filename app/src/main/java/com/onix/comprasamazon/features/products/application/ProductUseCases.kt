package com.onix.comprasamazon.features.products.application

import com.onix.comprasamazon.core.utilities.CustomProcess
import com.onix.comprasamazon.core.utilities.ResultO
import com.onix.comprasamazon.features.products.domain.business.entitites.BaseProduct
import com.onix.comprasamazon.features.products.domain.infraestructure.ProductCases
import com.onix.comprasamazon.features.products.application.cases.CreateProductCase
import com.onix.comprasamazon.features.products.application.cases.DeleteProductCase
import com.onix.comprasamazon.features.products.application.cases.EditProductCase
import com.onix.comprasamazon.features.products.application.cases.GetProductCase
import com.onix.comprasamazon.features.products.data.local.LocalProductManager
import com.onix.comprasamazon.features.products.domain.business.useCases.CreateProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.DeleteProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.EditProduct
import com.onix.comprasamazon.features.products.domain.business.useCases.GetProducts
import javax.inject.Inject


class ProductUseCases @Inject constructor(
    private val create: CreateProduct,
    private val edit: EditProduct,
    private val delete: DeleteProduct,
    private val getProduct: GetProducts
    ):ProductCases {

    override suspend fun createProduct(product: BaseProduct): ResultO<Long> {
        create.execute(product)
        if(create.getState()){
            return ResultO.success(create.getValueCase()!!)
        }
        return ResultO.failure(create.getError())
    }

    override suspend fun editProduct(product: BaseProduct): CustomProcess {
        edit.execute(product)
        if(edit.getState()){
            return CustomProcess.success()
        }
        return CustomProcess.failure(edit.getError())
    }

    override suspend fun deleteProduct(product: BaseProduct): CustomProcess {
        delete.execute(product)
        if(delete.getState()){
            return CustomProcess.success()
        }
        return CustomProcess.failure(delete.getError())
    }

    override suspend fun getProducts(): ResultO<List<BaseProduct>> {
        getProduct.execute()
        if(getProduct.getState()){
            return ResultO.success(getProduct.getValueCase()!!)
        }
        return ResultO.failure(getProduct.getError())
    }
}