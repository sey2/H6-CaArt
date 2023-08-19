package org.softeer_2nd.caArt.model.data.dto

data class Budget(
    val budgetUnit: Long,
    val keyword: String,
    val maxBudget: Long,
    val minBudget: Long,
    val question: String
)