package com.softeer.caart.domain.option.dto.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OptionSummaryListRequest {
	@NotNull(message = "trimId는 필수입니다. (type: Long)")
	private Long trimId;
	@NotNull(message = "engineId는 필수입니다. (type: Long)")
	private Long engineId;
	@NotNull(message = "bodyTypeId는 필수입니다. (type: Long)")
	private Long bodyTypeId;
	@NotNull(message = "wdId는 필수입니다. (type: Long)")
	private Long wdId;
}
