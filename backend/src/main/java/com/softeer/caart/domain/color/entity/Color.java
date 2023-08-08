package com.softeer.caart.domain.color.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "color_id")
	private Long id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Boolean isExterior;

	@Embedded
	private Image image;

	@Builder
	public Color(String name, Integer price, String imageUrl, Boolean isExterior) {
		this.name = name;
		this.price = price;
		this.image = Image.from(imageUrl);
		this.isExterior = isExterior;
	}

	public Boolean isExterior() {
		return this.isExterior;
	}

	public Boolean isInterior() {
		return !this.isExterior;
	}
}
