package org.softeer_2nd.caArt.model.repository

import org.softeer_2nd.caArt.model.data.Option
import org.softeer_2nd.caArt.model.data.OptionTag
import org.softeer_2nd.caArt.model.network.OptionApiService
import javax.inject.Inject

class CarOptionRepository@Inject constructor(
    private val optionApiService: OptionApiService
) {

    suspend fun fetchOptions(): List<Option> {
        return optionApiService.getOptionList().data?: listOf()
    }

    suspend fun fetchOptionTags():List<OptionTag>{
        return optionApiService.getOptionTagList().data?:listOf()
    }
}