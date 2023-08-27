package org.softeer_2nd.caArt.model.data

import org.softeer_2nd.caArt.CaArtApplication
import org.softeer_2nd.caArt.R

data class Trim(
    val trimId: Int,
    val description: String,
    val exteriorColors: List<TrimItemColor>,
    val interiorColors: List<TrimItemColor>,
    val mainOptions: List<TrimMainItem>,
    var trimImage: String,
    var trimName: String,
    var trimPrice: Long,
    var isChecked: Boolean = false,
    var compositionPrice: Long
) {
    companion object {
        private val trimNameIdMap = mapOf(
            CaArtApplication.getApplicationContext().getString(R.string.exclusive) to 0,
            CaArtApplication.getApplicationContext().getString(R.string.le_blanc) to 1,
            CaArtApplication.getApplicationContext().getString(R.string.prestige) to 2,
            CaArtApplication.getApplicationContext().getString(R.string.caligraphy) to 3,
        )

        fun String.toTrimId() = trimNameIdMap[this]
    }
}
