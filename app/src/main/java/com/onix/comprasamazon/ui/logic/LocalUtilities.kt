package com.onix.comprasamazon.ui.logic

import android.content.Context
import android.content.res.Configuration
import java.util.Locale


class LocalUtilities {
    fun Context.updateLocale(locale: Locale): Context {
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        return createConfigurationContext(config)
    }
}