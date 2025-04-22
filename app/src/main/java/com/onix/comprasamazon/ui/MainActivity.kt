package com.onix.comprasamazon.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.ui.platform.LocalContext
import com.onix.comprasamazon.ui.screens.calculatePurchase.interfaces.container.CalculatePurchase
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import androidx.core.content.edit
import com.onix.comprasamazon.ui.screens.calculatePurchase.CalculatePurchaseVM
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var calculatePurchase =CalculatePurchase()


    private val calculatePurchaseVM: CalculatePurchaseVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            calculatePurchaseVM.getProducts()
            calculatePurchaseVM.getAmazonPrice()
            calculatePurchase.Body()
        }
    }

    fun getSystemLanguage(): String {
        return Locale.getDefault().language
    }

    private fun getUserPreferredLanguage(): String {
        val sharedPrefs = getSharedPreferences("settings", MODE_PRIVATE)
        return sharedPrefs.getString("language", "es") ?: "es"
    }

    private fun setUserPreferredLanguage(language: String){
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        if(language=="es" || language=="en"){
            prefs.edit() { putString("language", language) }
        }

    }

    private fun setAppLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val config = resources.configuration
        config.setLocale(locale)
        createConfigurationContext(config)
    }
}

