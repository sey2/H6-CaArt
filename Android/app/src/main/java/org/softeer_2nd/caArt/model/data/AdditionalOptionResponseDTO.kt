package org.softeer_2nd.caArt.model.data

data class AdditionalOptionResponseDTO(
    val additionalOptions: List<Option>,
    val totalElements: Int,
    val totalPages: Int
)