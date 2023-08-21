package com.softeer.caart.domain.recommendation.carmaster.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;

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
public class RecommendedOption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recommended_option_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "additional_option_info_id", nullable = false)
	private AdditionalOptionInfo option;

	@Column(nullable = false, length = 35)
	private String reason;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_master_survey_id", nullable = false)
	private CarMasterSurvey survey;
}
