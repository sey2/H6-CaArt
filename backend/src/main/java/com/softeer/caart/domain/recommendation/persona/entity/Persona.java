package com.softeer.caart.domain.recommendation.persona.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.softeer.caart.domain.recommendation.persona.dto.PersonaDetailsResponse;
import com.softeer.caart.domain.tag.entity.Tag;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id")
	private Long id;

	@Embedded
	private Profile profile;

	@Column(name = "cover_letter", nullable = false, length = 100)
	private String coverLetter;

	@Column(name = "cover_image", nullable = false)
	private String coverImage;

	@Column(name = "interview_question_1", nullable = false)
	private String firstQuestion;

	@Column(name = "interview_answer_1", nullable = false)
	private String firstAnswer;

	@Column(name = "interview_question_2", nullable = false)
	private String secondQuestion;

	@Column(name = "interview_answer_2", nullable = false)
	private String secondAnswer;

	@Column(name = "recommendation_message", nullable = false, length = 50)
	private String recommendationMessage;

	@OneToOne
	@JoinColumn(name = "recommendation_result_id", nullable = false)
	private RecommendationResult recommendationResult;

	@ManyToOne
	@JoinColumn(name = "tag_id_1", nullable = false)
	private Tag firstTag;

	@ManyToOne
	@JoinColumn(name = "tag_id_2", nullable = false)
	private Tag secondTag;

	public List<String> getTagNameList() {
		return List.of(firstTag.getName(), secondTag.getName());
	}

	public List<PersonaDetailsResponse.InterviewDto> getInterviewList() {
		return List.of(
			PersonaDetailsResponse.InterviewDto.builder().question(firstQuestion).answer(firstAnswer).build(),
			PersonaDetailsResponse.InterviewDto.builder().question(secondQuestion).answer(secondAnswer).build());
	}
}
