package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.CaArtApplication
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.ResultChoiceOption
import org.softeer_2nd.caArt.model.data.state.Model
import org.softeer_2nd.caArt.model.data.state.RecommendCompleteResultState
import org.softeer_2nd.caArt.model.data.state.RecommendationCardState

data class RecommendCompleteResultDTO(
    val colors: List<Any>,
    val model: Model,
    val options: List<Option>,
    val palisadeImage: String,
    val recommendationCard: RecommendationCardState?,
    val totalPrice: Long
) {
    companion object {
        fun RecommendCompleteResultDTO.toState(): RecommendCompleteResultState {

            val resultOptions = mutableListOf<ResultChoiceOption>()
            val option1 = options[0]
            val option2 = options[1]
            val convertedOption = ResultChoiceOption(
                optionTitle = CaArtApplication.getApplicationContext().getString(R.string.option),
                topOptionImgUrl = option1.optionImage,
                topOptionPrice = option1.optionPrice,
                topOptionTitle = option1.optionName,
                topOptionToolTipText = option1.recommendationMessage ?: "",
                bottomOptionImgUrl = option2.optionImage,
                bottomOptionPrice = option2.optionPrice,
                bottomOptionTitle = option2.optionName,
                bottomOptionToolTipText = option2.recommendationMessage ?: "",
            )
            //TODO 컬러 완성 후 Color를 covert하는걸로 수정
            val convertedColor = ResultChoiceOption(
                optionTitle = CaArtApplication.getApplicationContext().getString(R.string.color),
                topOptionImgUrl = option1.optionImage,
                topOptionPrice = option1.optionPrice,
                topOptionTitle = option1.optionName,
                topOptionToolTipText = option1.recommendationMessage ?: "",
                bottomOptionImgUrl = option1.optionImage,
                bottomOptionPrice = option1.optionPrice,
                bottomOptionTitle = option1.optionName,
                bottomOptionToolTipText = option1.recommendationMessage ?: "",
            )

            resultOptions.apply {
                add(convertedOption)
                add(convertedColor)
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