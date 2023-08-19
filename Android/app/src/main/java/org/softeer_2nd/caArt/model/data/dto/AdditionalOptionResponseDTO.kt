package org.softeer_2nd.caArt.model.data.dto

import org.softeer_2nd.caArt.model.data.Option

data class AdditionalOptionResponseDTO(
    val additionalOptions: List<Option>,
    val totalElements: Int,
    val totalPages: Int
)