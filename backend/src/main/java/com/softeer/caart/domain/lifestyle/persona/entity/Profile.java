package com.softeer.caart.domain.lifestyle.persona.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;

@Getter
@Embeddable
public class Profile {

	@Column(name = "profile_image", nullable = false)
	private String image;

	@Column(name = "profile_name", nullable = false, length = 10)
	private String name;

	@Column(name = "profile_bio", nullable = false, length = 20)
	private String bio;

	@Column(name = "profile_age", nullable = false)
	private Integer age;

	@Column(name = "profile_message", nullable = false)
	private String message;
}
