package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.Option

data class DefaultOptionResponse(
    val totalElements: Int,
    val totalPages: Int,
    val baseOptions: List<Option>
)