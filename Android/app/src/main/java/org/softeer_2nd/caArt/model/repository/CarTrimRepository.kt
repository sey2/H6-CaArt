package org.softeer_2nd.caArt.model.repository

import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.network.TrimApiService
import javax.inject.Inject

class CarTrimRepository @Inject constructor(
    private val service: TrimApiService
) {

    suspend fun fetchTrims(): List<Trim> {
        return service.getTrimList().data ?: listOf()
    }
}