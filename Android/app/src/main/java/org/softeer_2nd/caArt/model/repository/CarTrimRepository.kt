package org.softeer_2nd.caArt.model.repository

import org.softeer_2nd.caArt.model.data.Compositions
import org.softeer_2nd.caArt.model.data.Trim
import org.softeer_2nd.caArt.model.network.TrimApiService
import javax.inject.Inject

class CarTrimRepository @Inject constructor(
    private val service: TrimApiService
) : BaseNetworkRepository() {

    suspend fun fetchTrims(): List<Trim> {
        return safeApiCall { service.getTrimList() }.data ?: listOf()
    }

    suspend fun fetchComposition(): Compositions {
        return safeApiCall { service.getComposition() }.data
            ?: throw NullPointerException("Composition API Data is Null")
    }
}