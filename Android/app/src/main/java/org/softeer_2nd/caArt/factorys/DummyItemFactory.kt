package org.softeer_2nd.caArt.factorys

import org.softeer_2nd.caArt.R
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
            OptionColorDummyItem("Top1", R.drawable.img_option_color1),
            OptionColorDummyItem("Top2", R.drawable.img_option_color2),
            OptionColorDummyItem("Top3", R.drawable.img_option_color3)
        )
    }

    fun createOptionExteriorColorDummyItems(): List<OptionColorDummyItem> {
        return arrayListOf(
            OptionColorDummyItem("Top1", R.color.black),
            OptionColorDummyItem("Top2", R.color.white),
            OptionColorDummyItem("Top3", R.color.gray_500)
        )
    }
}