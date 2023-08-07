package com.softeer.caart.domain.trim;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.softeer.caart.domain.Image;

@Entity
public class Trim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trim_id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Integer price;

	@Embedded
	private Image image;
}