package com.softeer.caart.domain.model;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.option.entity.CarOption;

@Entity
@Table(name = "rel_model_car_option")
public class AvailableOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_model_car_option_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_option_id", nullable = false)
	private CarOption carOption;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;
}
