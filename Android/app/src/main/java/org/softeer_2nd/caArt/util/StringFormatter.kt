package org.softeer_2nd.caArt.util

import java.text.NumberFormat
import java.util.Locale

object StringFormatter {
    private val priceFormatter = NumberFormat.getNumberInstance(Locale.KOREA)
    fun formatPriceString(price: Long): String {
        return priceFormatter.format(price)
    }

    fun combineCarComposition(
        engineType: String,
        seatingCapacity: String,
        driveConfiguration: String
    ): String {
        return "$engineType ・ $seatingCapacity ・ $driveConfiguration"
    }

    fun replaceWebNewLine(old: String?): String? {
        old ?: return null
        return old.replace("\\n", "\n")
    }

    fun getImageUrlFromIndex(index: Int): String {
        return String.format("%03d", index + 1)
    }
}
