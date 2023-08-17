package com.softeer.caart.domain.recommendation.lifestyle.dto;

import java.util.List;

import com.softeer.caart.domain.recommendation.lifestyle.entity.QuestionType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LifestyleQuestionDto {

	@Getter
	public static class QuestionDto {
		private final String question;
		private final String keyword;
		private final List<ChoiceDto> choices;

		public QuestionDto(QuestionType questionType) {
			this.question = questionType.getQuestion();
			this.keyword = questionType.getKeyword();
			this.choices = QuestionType.getChoiceDtoList(questionType);
		}
	}

	@Getter
	public static class BudgetQuestionDto {
		private final String question;
		private final String keyword;
		private final Integer minBudget;
		private final Integer maxBudget;
		private final Integer budgetUnit;

		public BudgetQuestionDto() {
			this.question = QuestionType.BUDGET.getQuestion();
			this.keyword = QuestionType.BUDGET.getKeyword();
			this.minBudget = 4200;
			this.maxBudget = 6900;
			this.budgetUnit = 300;
		}
	}

	@Getter
	@AllArgsConstructor(access = AccessLevel.PUBLIC)
	public static class ChoiceDto {
		private final Integer id;
		private final String content;
	}
}
