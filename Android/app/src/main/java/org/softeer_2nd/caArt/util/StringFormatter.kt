package org.softeer_2nd.caArt.util

import java.text.NumberFormat
import java.util.Locale

object StringFormatter {
    private val priceFormatter = NumberFormat.getNumberInstance(Locale.KOREA)
    fun formatPriceString(price: Long): String {
        return priceFormatter.format(price)
    }
    fun combineCarComposition(
        engineType: String?,
        seatingCapacity: String?,
        driveConfiguration: String?
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
    fun Long.setFormattedPrice(): String {
        val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
        val formattedPrice = formatter.format(this)
        return "${formattedPrice}"
    }

    fun String.setFormattedPrice(): String {
        val unformattedNumber = this.replace(",", "").toLongOrNull() ?: return this
        val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
        return formatter.format(unformattedNumber)
    }

    fun String.toIntOrNullWithComma(): Int? {
        val sanitizedString = this.replace(",", "").replace("원","")
        return sanitizedString.toIntOrNull()
    }

    fun extractColorFromUrl(url: String): String {
        val regex = ".*/outside/(.*?)/.*".toRegex()
        val matchResult = regex.find(url)
        return matchResult?.groupValues?.get(1) ?: ""
    }

    fun String.extractExteriorPreviewBaseUrl(): String? {
        val regex = Regex("(https://[^/]+/preview/outside/)")
        return regex.find(this)?.value
    }
}
