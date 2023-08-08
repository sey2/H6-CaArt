package com.softeer.caart.domain.option.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.softeer.caart.domain.Image;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CarOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_option_id")
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Embedded
	private Image image;

	@Column(nullable = false)
	private Integer price;

	@Enumerated(value = EnumType.STRING)
	private Badge badge;

	@Column(nullable = false)
	private Boolean isSetOption = false;

	@Column(nullable = false)
	private Boolean isAdditionalOption = false;

	@Builder
	public CarOption(String name, String description, String imageUrl, Integer price, Badge badge, Boolean isSetOption,
		Boolean isAdditionalOption) {
		this.name = name;
		this.description = description;
		this.image = Image.from(imageUrl);
		this.price = price;
		this.badge = badge;
		this.isSetOption = isSetOption;
		this.isAdditionalOption = isAdditionalOption;
	}
}
