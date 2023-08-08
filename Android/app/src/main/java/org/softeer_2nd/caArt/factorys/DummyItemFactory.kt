package org.softeer_2nd.caArt.factorys

import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.models.OptionChangePopUpDummyItem
import org.softeer_2nd.caArt.models.OptionColorDummyItem
import org.softeer_2nd.caArt.models.OptionSelectionDummyItem


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

}