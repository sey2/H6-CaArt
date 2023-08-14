package com.softeer.caart.domain.trim.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.softeer.caart.domain.Image;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Trim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trim_id")
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Integer price;

	@Embedded
	private Image image;

	@OneToMany(mappedBy = "trim")
	private List<MainOptionOfTrim> mainOptions = new ArrayList<>();

	@OneToMany(mappedBy = "trim")
	private List<AvailableColor> colors = new ArrayList<>();

	@Builder
	public Trim(String name, String description, Integer price, String imageUrl) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = Image.from(imageUrl);
	}
}
