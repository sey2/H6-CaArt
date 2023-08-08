package com.softeer.caart.domain.option.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.Image;

import lombok.Getter;

@Entity
@Table(name = "child_car_option")
@Getter
public class ChildCarOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "child_car_option_id")
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Embedded
	private Image image;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_option_id", nullable = false)
	private CarOption parentOption;
}
