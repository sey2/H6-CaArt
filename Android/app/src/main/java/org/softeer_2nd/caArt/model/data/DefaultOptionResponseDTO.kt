package org.softeer_2nd.caArt.model.data

data class DefaultOptionResponseDTO(
    val totalElements: Int,
    val totalPages: Int,
    val baseOptions: List<Option>
)