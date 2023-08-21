package org.softeer_2nd.caArt.model.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
import org.softeer_2nd.caArt.model.network.OptionApiService
import javax.inject.Inject

class CarOptionRepository @Inject constructor(
    private val optionApiService: OptionApiService
) {

    private var additionalTagList = emptyList<OptionTag>()
    private var defaultTagList = emptyList<OptionTag>()

    private var pageOffset: Int = 0
    private val PAGE_OPTION_COUNT = 8

    private val _totalOptionCount = MutableStateFlow<Int>(0)
    val totalOptionCount: StateFlow<Int> = _totalOptionCount

    private val _isLastPage = MutableStateFlow<Boolean>(false)
    val isLastPage: StateFlow<Boolean> = _isLastPage

    suspend fun fetchOptionTags(): List<OptionTag> {
        additionalTagList = optionApiService.getAdditionalOptionTagList().data ?: listOf()
        defaultTagList = optionApiService.getDefaultOptionTagList().data ?: listOf()

        return defaultTagList
    }

    suspend fun fetchFirstAdditionalOptionList(tagId: Int? = null): List<Option>? {
        _isLastPage.value = false
        pageOffset = 0

        return requestAdditionalOptionList(tagId, pageOffset)
    }

    suspend fun fetchNextAdditionalOptionList(tagId: Int? = null): List<Option>? {
        if (isLastPage.value) return null
        return requestAdditionalOptionList(tagId, pageOffset)
    }

    private suspend fun requestAdditionalOptionList(
        tagId: Int? = null,
        pageOffset: Int = 0
    ): List<Option>? {
        val trimId = 1
        val engineId = 1
        val bodyTypeId = 1
        val wheelDriveId = 1

        val requestResult = optionApiService.getAdditionalOptionList(
            tagId, trimId, engineId, bodyTypeId, wheelDriveId, pageOffset, PAGE_OPTION_COUNT
        ).data

        val totalOptionCount = requestResult?.totalElements
        val isLastPage = (pageOffset + 1) * PAGE_OPTION_COUNT >= (requestResult?.totalElements ?: 0)
        if (!isLastPage) this.pageOffset++

        _isLastPage.value = isLastPage
        _totalOptionCount.value = totalOptionCount ?: 0

        return requestResult?.additionalOptions
    }

    suspend fun fetchFirstDefaultOptionList(tagId: Int? = null): List<Option>? {
        _isLastPage.value = false
        pageOffset = 0

        return requestDefaultOptionList(tagId, pageOffset)
    }

    suspend fun fetchNextDefaultOptionList(tagId: Int? = null): List<Option>? {
        if (isLastPage.value) return null
        return requestDefaultOptionList(tagId, pageOffset)
    }

    private suspend fun requestDefaultOptionList(
        tagId: Int? = null,
        pageOffset: Int = 0
    ): List<Option>? {
        val trimId = 1
        val engineId = 1
        val bodyTypeId = 1
        val wheelDriveId = 1

        val requestResult = optionApiService.getDefaultOptionList(
            tagId, trimId, engineId, bodyTypeId, wheelDriveId, pageOffset, PAGE_OPTION_COUNT
        ).data

        val totalOptionCount = requestResult?.totalElements
        val isLastPage = (pageOffset + 1) * PAGE_OPTION_COUNT >= (requestResult?.totalElements ?: 0)
        if (!isLastPage) this.pageOffset++

        _isLastPage.value = isLastPage
        _totalOptionCount.value = totalOptionCount ?: 0

        return requestResult?.baseOptions
    }

    fun getAdditionalTagList() = additionalTagList

    fun getDefaultTagList() = defaultTagList

}