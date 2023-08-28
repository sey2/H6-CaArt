package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.CaArtApplication
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.data.ChoiceColorItem
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.ResultChoiceOption
import org.softeer_2nd.caArt.model.data.state.Model
import org.softeer_2nd.caArt.model.data.state.RecommendCompleteResultState
import org.softeer_2nd.caArt.model.data.state.RecommendationCardState

data class RecommendCompleteResult(
    val colors: List<ChoiceColorItem>,
    val model: Model,
    val options: List<Option>,
    val palisadeImage: String,
    val recommendationCard: RecommendationCardState?,
    val totalPrice: Long
) {
    companion object {

        fun RecommendCompleteResult.toState(): RecommendCompleteResultState {
            val resultOptionList = MutableList<Option?>(2) { null }
            val resultColorList = MutableList<ChoiceColorItem?>(2) { null }

            for (i in 0 until 2) {
                if (options.size > i) resultOptionList[i] = options[i]
                if (colors.size > i) resultColorList[i] = colors[i]
            }

            val resultOptions = mutableListOf<ResultChoiceOption>()
            val option1 = resultOptionList[0]
            val option2 = resultOptionList[1]
            val interiorColor = resultColorList[1]
            val exteriorColor = resultColorList[0]
            val convertedOption = ResultChoiceOption(
                optionTitle = CaArtApplication.getApplicationContext().getString(R.string.option),
                topOptionImgUrl = option1?.optionImage,
                topOptionPrice = option1?.optionPrice ?: 0,
                topOptionTitle = option1?.optionName ?: "-",
                topOptionToolTipText = option1?.recommendationMessage ?: "",
                bottomOptionImgUrl = option2?.optionImage,
                bottomOptionPrice = option2?.optionPrice ?: 0,
                bottomOptionTitle = option2?.optionName ?: "-",
                bottomOptionToolTipText = option2?.recommendationMessage ?: "",
            )

            val convertedColor = ResultChoiceOption(
                optionTitle = CaArtApplication.getApplicationContext().getString(R.string.color),
                topOptionImgUrl = exteriorColor?.imgUrl ?: "",
                topOptionPrice = exteriorColor?.colorPrice,
                topOptionTitle = "외장 - ${exteriorColor?.colorName}",
                topOptionToolTipText = exteriorColor?.recommendationMessage ?: "",
                bottomOptionImgUrl = interiorColor?.imgUrl ?: "",
                bottomOptionPrice = interiorColor?.colorPrice,
                bottomOptionTitle = "내장 - ${interiorColor?.colorName}",
                bottomOptionToolTipText = interiorColor?.recommendationMessage ?: "",
            )

            resultOptions.apply {
                add(convertedColor)
                add(convertedOption)
            }
            return RecommendCompleteResultState(
                model = model,
                resultOptions = resultOptions,
                palisadeImage = palisadeImage,
                recommendationCard = recommendationCard,
                totalPrice = totalPrice
            )
        }
    }
}