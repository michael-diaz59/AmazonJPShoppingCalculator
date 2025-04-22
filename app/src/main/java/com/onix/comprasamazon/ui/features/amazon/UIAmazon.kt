package com.onix.comprasamazon.ui.features.amazon

import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon

class UIAmazon(
    override var id: Long = 0L,
    override var amazonToPay: Double = 0.0,
    override var amazonRealToPay: Double = 0.0
) : BaseAmazon() {
    companion object {
        fun baseToUI(amazon: BaseAmazon): UIAmazon {
            return UIAmazon(amazon.id, amazon.amazonToPay, amazon.amazonRealToPay)

        }
    }

    fun copyBase(amazon: BaseAmazon) {
        id = amazon.id
        amazonToPay = amazon.amazonToPay
        amazonRealToPay = amazon.amazonRealToPay

    }

}