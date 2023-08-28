package org.softeer_2nd.caArt.model.data.state

import org.softeer_2nd.caArt.model.data.Option

data class OptionDetailDialogState(
    val mainOption: Option,
    val optionList: List<Option>,
    val isSelected: Boolean
)