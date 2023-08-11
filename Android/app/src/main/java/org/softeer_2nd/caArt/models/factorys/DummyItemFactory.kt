package org.softeer_2nd.caArt.models.factorys

import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.models.dummys.OptionChangePopUpDummyItem
import org.softeer_2nd.caArt.models.datas.Option
import org.softeer_2nd.caArt.models.dummys.OptionTrimMoreDetailDummyItem
import org.softeer_2nd.caArt.models.dummys.OptionColorDummyItem
import org.softeer_2nd.caArt.models.dummys.OptionSelectionDummyItem
import org.softeer_2nd.caArt.models.dummys.OptionTrimSelectionDummyItem


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

    fun createSelectionTrimItemDummyItems(): List<OptionTrimSelectionDummyItem> {
        return arrayListOf(
            OptionTrimSelectionDummyItem(
                "Exclusive",
                "합리적인 가격의 인기 옵션",
                "디젤 2.2 ・ 7인승 ・ 2WD",
                "43,460,000원"
            ),
            OptionTrimSelectionDummyItem(
                "Le Blanc (르블랑)",
                "필수적인 옵션만 모은",
                "디젤 2.2 ・ 7인승 ・ 2WD",
                "40,440,000원"
            ),
            OptionTrimSelectionDummyItem(
                "Prestige",
                "가치있는 드라이빙 경험을 주는",
                "디젤 2.2 ・ 7인승 ・ 2WD",
                "47,720,000원"
            ),
            OptionTrimSelectionDummyItem(
                "Caligraphy",
                "남들과 차별화된 경험",
                "디젤 2.2 ・ 7인승 ・ 2WD",
                "52,540,000원"
            )
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

    fun createTrimMoreExteriorDetailItem(): List<OptionTrimMoreDetailDummyItem> {
        return arrayListOf(
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/eb63693b-8048-4657-9982-4af6b2f94e88"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/cedfafbc-c507-4300-8827-d194e024d3e8"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/83456bef-6975-4803-ad20-21e1b8470239"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/49bf8a47-6a23-462a-a646-b097b975e7bc"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/49bf8a47-6a23-462a-a646-b097b975e7b")
        )
    }

    fun createTrimMoreInteriorDetailItem(): List<OptionTrimMoreDetailDummyItem> {
        return arrayListOf(
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/cb1f6699-ba72-414b-bc27-7e0fbfcb9e2c"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/3f2501e4-a266-444e-bcfd-7870af2d4738"),
        )
    }

    fun createTrimMoreDefaultDetailItem(): List<OptionTrimMoreDetailDummyItem> {
        return arrayListOf(
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/8cf13d19-d76f-401b-afef-1d9393881216"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/dd00cc97-de91-47d8-8eb9-03312233508a"),
            OptionTrimMoreDetailDummyItem("https://github.com/softeerbootcamp-2nd/H6-CaArt/assets/54762273/6df8efd6-b047-4f8e-bc8a-03659e10000f")
        )
    }
}