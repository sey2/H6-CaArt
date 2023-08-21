package com.softeer.caart.domain.color.entity;

import java.util.List;
import java.util.stream.Collectors;

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
public class Color {

	private static final int EXTERIOR_MAIN_PREVIEW_IDX = 11;
	private static final int INTERIOR_MAIN_PREVIEW_IDX = 0;

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

	@OneToMany(mappedBy = "color")
	private List<ColorPreview> colorPreviews;

	@OneToMany(mappedBy = "color")
	private List<AvailableColor> relationsWithTrims;

	@Builder
	public Color(String name, Integer price, String imageUrl, Boolean isExterior) {
		this.name = name;
		this.price = price;
		this.image = Image.from(imageUrl);
		this.isExterior = isExterior;
	}

	public Boolean isExteriorColor() {
		return this.isExterior;
	}

	public Boolean isInteriorColor() {
		return !this.isExterior;
	}

	public List<String> getImageUrlListOfColorPreview() {
		return colorPreviews.stream()
			.map(colorPreview -> colorPreview.getImage().getUrl())
			.collect(Collectors.toList());
	}

	public String getImageUrlOfMainColorPreview() {
		if (isExterior) {
			return colorPreviews.get(EXTERIOR_MAIN_PREVIEW_IDX).getImage().getUrl();
		}
		return colorPreviews.get(INTERIOR_MAIN_PREVIEW_IDX).getImage().getUrl();
	}
}
