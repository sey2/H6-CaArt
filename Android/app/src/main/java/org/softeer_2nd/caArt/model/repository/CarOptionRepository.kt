package org.softeer_2nd.caArt.model.repository

import org.softeer_2nd.caArt.model.data.AdditionalOptionResponseDTO
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
import org.softeer_2nd.caArt.model.network.OptionApiService
import retrofit2.http.Query
import javax.inject.Inject

class CarOptionRepository @Inject constructor(
    private val optionApiService: OptionApiService
) {

    private val tagList = mutableListOf<OptionTag>()
    private var mainTag: OptionTag? = null

    private val additionalTagList = mutableListOf<OptionTag>()


    suspend fun fetchOptionTags(): List<OptionTag> {
        val tagList = optionApiService.getOptionTagList().data ?: listOf()
        this.tagList.clear()
        additionalTagList.clear()
        this.tagList.addAll(tagList)
        additionalTagList.addAll(tagList)
        mainTag = tagList.find { it.tagId == 9 }
        additionalTagList.remove(mainTag)
        return tagList
    }

    suspend fun fetchAdditionalOptionList(
        tagId: Int?,
        trimId: Int,
        engineId: Int,
        bodyTypeId: Int,
        wheelDriveID: Int,
    ): List<Option> {
        val optionList = optionApiService.getAdditionalOptionList(
            tagId, trimId, engineId, bodyTypeId, wheelDriveID
        ).data?.additionalOptions ?: listOf()
        return optionList
    }

    suspend fun fetchDefaultOptionList(
        tagId: Int?,
        trimId: Int,
        engineId: Int,
        bodyTypeId: Int,
        wheelDriveID: Int,
    ): List<Option> {
        val optionList = optionApiService.getDefaultOptionList(
            tagId, trimId, engineId, bodyTypeId, wheelDriveID
        ).data?.baseOptions ?: listOf()

        return optionList
    }

    fun getAdditionalTagList() = additionalTagList

    fun getTagList() = tagList
}