package com.softeer.caart.domain.color.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.Image;

@Entity
public class ColorPreview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "color_preview_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;

	@Embedded
	private Image image;
}
