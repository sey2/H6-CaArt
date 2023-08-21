package com.softeer.caart.domain.model.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.composition.entity.BodyType;
import com.softeer.caart.domain.composition.entity.CarEngine;
import com.softeer.caart.domain.composition.entity.WheelDrive;
import com.softeer.caart.domain.trim.entity.Trim;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

	@Builder
	public Model(CarEngine carEngine, BodyType bodyType, WheelDrive wheelDrive, Trim trim) {
		this.carEngine = carEngine;
		this.bodyType = bodyType;
		this.wheelDrive = wheelDrive;
		this.trim = trim;
	}

	public Integer calcModelPrice() {
		return carEngine.getPrice() + wheelDrive.getPrice() + trim.getPrice();
	}
}
