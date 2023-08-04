package org.softeer_2nd.caArt

object DummyItemFactory {
    fun createDummyItems(): List<ItemTestData> {
        return arrayListOf(ItemTestData("모델", "펠리세이드 디젤 2.2 2WD, Le Blanc", "7인승","42,450,000원",""),
            ItemTestData("색상", "외장 - 어비스 블랙펄", "내장 어비스 블랙펄", "-원", "-원"),
            ItemTestData("옵션", "컴포트 II", "내장 어비스 블랙펄", "1,090,000원", "790,000원"),
            )
    }
}