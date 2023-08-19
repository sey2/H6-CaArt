package org.softeer_2nd.caArt.model.data

data class Persona(
    var coverLetter: String,
    val personaId: Int,
    val profileImage: String,
    val tags: List<String>
)