package org.softeer_2nd.caArt.util

import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.UserChoiceBottomsheetState
import org.softeer_2nd.caArt.model.data.WheelDrive
import org.softeer_2nd.caArt.model.data.dto.ExteriorColor
import org.softeer_2nd.caArt.model.data.dto.InteriorColor
import kotlin.math.min

object UserChoiceConverter {

    private const val DISPLAY_OPTION_LIMIT = 2

    fun trimToUserChoice(
        trim: Trim,
        engine: Engine,
        bodyType: BodyType,
        wheelDrive: WheelDrive
    ): UserChoiceBottomsheetState {
        return UserChoiceBottomsheetState(
            "모델",
            "펠리세이드 ${engine.itemName} ${wheelDrive.itemName} ${trim.trimName}",
            bodyType.itemName,
            StringFormatter.formatPriceString(trim.trimPrice + engine.enginePrice!! + wheelDrive.wheelDrivePrice!!) + "원",
            ""
        )
    }

    fun colorToUserChoice(
        exteriorColor: ExteriorColor,
        interiorColor: InteriorColor
    ): UserChoiceBottomsheetState {
        return UserChoiceBottomsheetState(
            "색상",
            "외장 - ${exteriorColor.colorName}",
            "내장 - ${interiorColor.colorName}",
            "-원",
            "-원"
        )
    }

    fun optionToUserChoice(options: List<Option>): UserChoiceBottomsheetState {

        val displayOptionList = MutableList<Option?>(DISPLAY_OPTION_LIMIT) { null }
        val lastIndex = min(options.size, DISPLAY_OPTION_LIMIT)
        for (i in 0 until lastIndex) {
            displayOptionList[i] = options[i]
        }

        return UserChoiceBottomsheetState(
            "옵션",
            displayOptionList[0]?.optionName ?: "-",
            displayOptionList[1]?.optionName ?: "-",
            StringFormatter.formatPriceString(displayOptionList[0]?.optionPrice ?: 0) + "원",
            StringFormatter.formatPriceString(displayOptionList[1]?.optionPrice ?: 0) + "원",
        )
    }
}