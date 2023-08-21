package com.softeer.caart.domain.recommendation.carmaster.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.composition.entity.BodyType;
import com.softeer.caart.domain.composition.entity.CarEngine;
import com.softeer.caart.domain.composition.entity.WheelDrive;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;
import com.softeer.caart.domain.trim.entity.Trim;

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
	@Column(nullable = false)
	private Answer experience;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Answer family;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Answer purpose;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Answer value;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "trim_id", nullable = false)
	private Trim trim;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_engine_id", nullable = false)
	private CarEngine carEngine;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "body_type_id", nullable = false)
	private BodyType bodyType;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "wd_id", nullable = false)
	private WheelDrive wheelDrive;

	@Column(nullable = false)
	private Integer totalSum;

}
