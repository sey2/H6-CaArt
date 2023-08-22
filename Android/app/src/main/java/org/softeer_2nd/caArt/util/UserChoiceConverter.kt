package org.softeer_2nd.caArt.util

import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.UserChoiceBottomsheetState
import org.softeer_2nd.caArt.model.data.WheelDrive
import org.softeer_2nd.caArt.model.data.dto.ExteriorColor
import org.softeer_2nd.caArt.model.data.dto.InteriorColor

object UserChoiceConverter {
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
            StringFormatter.formatPriceString(trim.trimPrice) + "원",
            ""
        )
    }

    fun colorToUserChoice(exteriorColor: ExteriorColor, interiorColor: InteriorColor): UserChoiceBottomsheetState {
        return UserChoiceBottomsheetState(
            "색상",
            "외장 - ${exteriorColor.colorName}",
            "내장 - ${interiorColor.colorName}",
            "-원",
            "-원"
        )
    }

    fun optionToUserChoice(options: List<Option>): UserChoiceBottomsheetState {
        return UserChoiceBottomsheetState(
            "옵션",
            options[0].optionName,
            options[1].optionName,
            StringFormatter.formatPriceString(options[0].optionPrice?:0) + "원",
            StringFormatter.formatPriceString(options[1].optionPrice?:0) + "원",
        )
    }
}