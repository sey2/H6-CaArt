package org.softeer_2nd.caArt.util

import org.softeer_2nd.caArt.model.data.BodyType
import org.softeer_2nd.caArt.model.data.Engine
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.data.TrimItemColor
import org.softeer_2nd.caArt.model.data.UserChoice
import org.softeer_2nd.caArt.model.data.WheelDrive

object UserChoiceConverter {
    fun trimToUserChoice(
        trim: Trim,
        engine: Engine,
        bodyType: BodyType,
        wheelDrive: WheelDrive
    ): UserChoice {
        return UserChoice(
            "모델",
            "펠리세이드 ${engine.itemName} ${wheelDrive.itemName} ${trim.trimName}",
            bodyType.itemName,
            StringFormatter.formatPriceString(trim.trimPrice) + "원",
            ""
        )
    }

    fun colorToUserChoice(exteriorColor: TrimItemColor, interiorColor: TrimItemColor): UserChoice {
        return UserChoice(
            "색상",
            exteriorColor.colorName,
            interiorColor.colorName,
            "-원",
            "-원"
        )
    }

    fun optionToUserChoice(options: List<Option>): UserChoice {
        return UserChoice(
            "옵션",
            options[0].optionName,
            options[1].optionName,
            StringFormatter.formatPriceString(options[0].optionPrice?:0) + "원",
            StringFormatter.formatPriceString(options[1].optionPrice?:0) + "원",
        )
    }
}