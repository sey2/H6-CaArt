package org.softeer_2nd.caArt.util

import java.text.NumberFormat
import java.util.Locale

object StringFormatter {
    private val priceFormatter = NumberFormat.getNumberInstance(Locale.KOREA)
    fun formatPriceString(price: Long): String {
        return priceFormatter.format(price)
    }
}
