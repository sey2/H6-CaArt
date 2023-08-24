package com.softeer.caart.domain.recommendation.carmaster.entity;

import static javax.persistence.FetchType.*;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarMasterSurvey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_master_survey_id")
	private Long id;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "experience_code", nullable = false)
	private Answer experience;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "family_code", nullable = false)
	private Answer family;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "purpose_code", nullable = false)
	private Answer purpose;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "value_code", nullable = false)
	private Answer value;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;

	@Column(nullable = false)
	private Integer totalSum;

	@OneToMany(mappedBy = "survey")
	private List<RecommendedOption> recommendedOptions;
}
