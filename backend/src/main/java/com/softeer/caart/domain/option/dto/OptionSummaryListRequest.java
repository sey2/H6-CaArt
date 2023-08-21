package com.softeer.caart.domain.option.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OptionSummaryListRequest {
	@NotNull(message = "해당 값은 비어있을 수 없습니다.")
	private Long trimId;
	@NotNull(message = "해당 값은 비어있을 수 없습니다.")
	private Long engineId;
	@NotNull(message = "해당 값은 비어있을 수 없습니다.")
	private Long bodyTypeId;
	@NotNull(message = "해당 값은 비어있을 수 없습니다.")
	private Long wdId;
}
