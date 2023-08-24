package com.softeer.caart.domain.recommendation.carmaster.dto;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Question.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.recommendation.carmaster.entity.CarMasterSurvey;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateSurveyRequest {
	@NotNull
	private final Answer experience;

	@NotNull
	private final Answer family;

	@NotNull
	private final Answer purpose;

	@NotNull
	private final Answer value;

	@NotNull
	private final Long trimId;

	@NotNull
	private final Long engineId;

	@NotNull
	private final Long bodyTypeId;

	@NotNull
	private final Long wdId;

	@NotNull
	private final Long additionalOptionId1;

	@NotEmpty
	@Size(max = 50, message = "사유는 50자 이내로 입력해주세요.")
	private final String reason1;

	@NotNull
	private final Long additionalOptionId2;

	@NotEmpty
	@Size(max = 50, message = "사유는 50자 이내로 입력해주세요.")
	private final String reason2;

	@NotNull
	private final Integer totalSum;

	@Builder
	public CreateSurveyRequest(Answer experience, Answer family, Answer purpose, Answer value, Long trimId,
		Long engineId,
		Long bodyTypeId, Long wdId, Long additionalOptionId1, String reason1, Long additionalOptionId2, String reason2,
		Integer totalSum) {
		this.experience = experience;
		this.family = family;
		this.purpose = purpose;
		this.value = value;
		this.trimId = trimId;
		this.engineId = engineId;
		this.bodyTypeId = bodyTypeId;
		this.wdId = wdId;
		this.additionalOptionId1 = additionalOptionId1;
		this.reason1 = reason1;
		this.additionalOptionId2 = additionalOptionId2;
		this.reason2 = reason2;
		this.totalSum = totalSum;
	}

	public CarMasterSurvey toCarMasterSurveyEntity(Model model) {
		return CarMasterSurvey.builder()
			.experience(this.experience)
			.family(this.family)
			.purpose(this.purpose)
			.value(this.value)
			.model(model)
			.totalSum(this.totalSum)
			.build();
	}

	public void validateAnswer() {
		experience.validateAnswer(EXPERIENCE);
		family.validateAnswer(FAMILY);
		purpose.validateAnswer(PURPOSE);
		value.validateAnswer(VALUE);
	}
}
