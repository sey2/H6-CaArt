package org.softeer_2nd.caArt.model.factory

import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.model.dummy.OptionChangePopUpDummyItem
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.event.SurveyQuestion
import org.softeer_2nd.caArt.model.dummy.OptionTrimMoreDetailDummyItem
import org.softeer_2nd.caArt.model.dummy.OptionColorDummyItem
import org.softeer_2nd.caArt.model.dummy.OptionSelectionDummyItem
import org.softeer_2nd.caArt.model.dummy.TrimDescriptionDummyItem


object DummyItemFactory {
    fun createOptionSelectionDummyItems(): List<OptionSelectionDummyItem> {
        return arrayListOf(
            OptionSelectionDummyItem("모델", "펠리세이드 디젤 2.2 2WD, Le Blanc", "7인승", "42,450,000원", ""),
            OptionSelectionDummyItem("색상", "외장 - 어비스 블랙펄", "내장 - 어비스 블랙펄", "-원", "-원"),
            OptionSelectionDummyItem("옵션", "컴포트 II", "내장 어비스 블랙펄", "1,090,000원", "790,000원"),
        )
    }

    fun createOptionInteriorColorDummyItems(): List<OptionColorDummyItem> {
        return arrayListOf(
            OptionColorDummyItem("Caligraphy", R.drawable.img_option_color1),
            OptionColorDummyItem("CoolGray", R.drawable.img_option_color2),
            OptionColorDummyItem("Brown", R.drawable.img_option_color3),
            OptionColorDummyItem("Navy", R.drawable.img_option_color3),
            OptionColorDummyItem("Black_Edition", R.drawable.img_option_color3)
        )
    }

    fun createOptionExteriorColorDummyItems(): List<OptionColorDummyItem> {
        return arrayListOf(
            OptionColorDummyItem("black", R.color.black),
            OptionColorDummyItem("white", R.color.white),
            OptionColorDummyItem("gray", R.color.gray_500),
            OptionColorDummyItem("blue", R.color.blue_500),
            OptionColorDummyItem("purple", R.color.purple_200)
        )
    }

    fun createOptionInteriorOtherColorDummyItems(): List<OptionColorDummyItem> {
        return arrayListOf(
            OptionColorDummyItem("Caligraphy", R.drawable.img_option_color1),
            OptionColorDummyItem("Caligraphy", R.drawable.img_option_color2),
            OptionColorDummyItem("Caligraphy", R.drawable.img_option_color3),
            OptionColorDummyItem("Caligraphy", R.drawable.img_option_color1),
            OptionColorDummyItem("Exclusive", R.drawable.img_option_color2),
            OptionColorDummyItem("Prestige", R.drawable.img_option_color3),
            OptionColorDummyItem("Prestige", R.drawable.img_option_color1),
            OptionColorDummyItem("Prestige", R.drawable.img_option_color2)
        )
    }

    fun createOptionExteriorOtherColorDummyItems(): List<OptionColorDummyItem> {
        return arrayListOf(
            OptionColorDummyItem("Caligraphy", R.color.black),
            OptionColorDummyItem("Caligraphy", R.color.gray_500),
            OptionColorDummyItem("Caligraphy", R.color.gray_700),
            OptionColorDummyItem("Caligraphy", R.color.gray_800),
            OptionColorDummyItem("Caligraphy", R.color.purple_200),
        )
    }

    fun createInteriorColorOptionChangeDummyItems(): List<OptionChangePopUpDummyItem> {
        return arrayListOf(
            OptionChangePopUpDummyItem("인조 가죽 블랙(블랙)", "0원")
        )
    }

    fun createDefaultOptionChangeDummyItems(): List<OptionChangePopUpDummyItem> {
        return arrayListOf(
            OptionChangePopUpDummyItem("주차 보조 시스템", "400,000원"),
            OptionChangePopUpDummyItem("컴포트 II", "400,000원")
        )
    }

    fun createCurrentTrimOptionDummyItems(): List<OptionChangePopUpDummyItem> {
        return arrayListOf(
            OptionChangePopUpDummyItem("Le Blanc(르블랑)", "40,440,000원"),
        )
    }

    fun createChangeTrimOptionDummyItems(): List<OptionChangePopUpDummyItem> {
        return arrayListOf(
            OptionChangePopUpDummyItem("Calligraphy", "+ 400,000원"),
        )
    }

    fun createAdditionalOptionGrouopItem(): List<Option> = List(5) {
        Option(
            name = "option ${it + 1}",
            description = "desc".repeat(50),
            group = "group1",
            isDefaultOption = false,
            price = 999999999,
            url = "https://cdn.autotribune.co.kr/news/photo/202101/4849_30727_3533.jpg"
        )
    }

    fun createAdditionalSingleOptionItem(): List<Option> = listOf<Option>(
        Option(
            name = "option",
            description = "desc",
            group = null,
            isDefaultOption = false,
            price = 9999999,
            url = "https://cdn.pixabay.com/photo/2023/05/05/21/00/cute-7973191_1280.jpg"
        )
    )

    fun createDefaultSingleOptionItem(): List<Option> = listOf<Option>(
        Option(
            name = "option",
            description = "desc",
            group = null,
            isDefaultOption = true,
            price = 0,
            url = "https://cdn.autotribune.co.kr/news/photo/202101/4849_30727_3533.jpg"
        )
    )

    fun createTrimEngineDescriptionItem(): List<TrimDescriptionDummyItem> {
        return arrayListOf(
            TrimDescriptionDummyItem(
                "디젤 2.2",
                "강한 성능 높은 연비 효율",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/5.jpg",
                "높은 토크로 파워풀한 드라이빙이 가능하며, 차급대비 연비 효율이 우수합니다.",
                "295/6,000PS/rpm",
                "36.2/5,200kgf-m/rpm"
            ),
            TrimDescriptionDummyItem(
                "가솔린 2.2",
                "강한 성능 높은 연비 효율",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/6.jpg",
                "고마력의 우수한 가속 성능을 확보하여, 넉넉하고 안정감 있는 주행이 가능합니다. 엔진의 진동이 적어 편안하고 조용한 드라이빙 감성을 제공합니다.",
                "asdasdas",
                "asdas"
            )
        )
    }

    fun createTrimBodyDescriptionItem(): List<TrimDescriptionDummyItem> {
        return arrayListOf(
            TrimDescriptionDummyItem(
                "7인승",
                "7인승 매우 편안",
                "ttps://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/bodytype/7.jpg",
                "기존 8인승 시트(1열 2명, 2열 3명, 3열 3명)에서 2열 가운데 시트를 없애 2열 탑승객의 편의는 물론, 3열 탑승객의 승하차가 편리합니다"
            ),
            TrimDescriptionDummyItem(
                "8인승",
                "8인승 매우 편안",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/bodytype/8.jpg",
                "1열 2명, 2열 3명, 3열 3명이 탑승할 수 있는 구조로, 많은 인원이 탑승할 수 있도록 배려하였습니다."
            )
        )
    }

    fun createTrimDrivenDescriptionItem(): List<TrimDescriptionDummyItem> {
        return arrayListOf(
            TrimDescriptionDummyItem(
                "2WD",
                "2륜 구동 방식",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/wd/9.jpg",
                "엔진에서 전달되는 동력이 전/후륜 바퀴 중 한쪽으로만 전달되어 차량을 움직이는 방식입니다. 차체가 가벼워 연료 효율이 높습니다."
            ),
            TrimDescriptionDummyItem(
                "4WD",
                "4륜 구동 방식",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/wd/10.jpg",
                "전자식 상시 4륜 구동 시스템입니다. 도로의 상황이나 주행 환경에 맞춰 전후륜 구동력을 자동배분하여 주행 안전성을 높여줍니다.",
            )
        )
    }

    fun createDescriptionDummyItems(): List<List<TrimDescriptionDummyItem>> {
        return arrayListOf(
            createTrimEngineDescriptionItem(),
            createTrimBodyDescriptionItem(),
            createTrimDrivenDescriptionItem()
        )
    }

    fun createSurveyQuestionDummyItem(): List<SurveyQuestion> {
        return List(3) { questionIndex ->
            SurveyQuestion(
                question = "$questionIndex 나이를 알려주세요.",
                answerOptions = List(5) { "${it * 10}" }
            )
        }
    }
}