package com.softeer.caart.domain.trim.entity;

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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rel_trim_car_main_option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MainOptionOfTrim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_trim_car_main_option_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "trim_id", nullable = false)
	private Trim trim;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_option_id", nullable = false)
	private CarOption mainOption;

	public MainOptionOfTrim(Trim trim, CarOption mainOption) {
		this.trim = trim;
		this.mainOption = mainOption;
	}
}

