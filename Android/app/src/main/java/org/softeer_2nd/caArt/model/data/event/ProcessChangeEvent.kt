package org.softeer_2nd.caArt.model.data.event

data class ProcessChangeEvent<PROCESS_DATA_TYPE>(
    val currentProcess: Int,
    val isLastProcess: Boolean,
    val data: PROCESS_DATA_TYPE? = null
)
