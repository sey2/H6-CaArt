package com.softeer.caart.domain.composition.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.softeer.caart.domain.Image;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "body_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BodyType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "body_type_id")
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String summary;

	@Embedded
	private Image image;

	@Builder
	public BodyType(String name, String description, String imageUrl, String summary) {
		this.name = name;
		this.description = description;
		this.image = Image.from(imageUrl);
		this.summary = summary;
	}
}
