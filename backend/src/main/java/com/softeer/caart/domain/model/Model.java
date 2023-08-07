package com.softeer.caart.domain.model;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.composition.BodyType;
import com.softeer.caart.domain.composition.engine.CarEngine;
import com.softeer.caart.domain.composition.wd.WheelDrive;
import com.softeer.caart.domain.trim.Trim;

@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_engine_id", nullable = false)
	private CarEngine carEngine;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "body_type_id", nullable = false)
	private BodyType bodyType;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "wd_id", nullable = false)
	private WheelDrive wheelDrive;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "trim_id", nullable = false)
	private Trim trim;
}
