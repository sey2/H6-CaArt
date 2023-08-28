package com.softeer.caart.domain.tag.entity;

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
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Embedded
	private Image image;

	@Column(nullable = false)
	private String icon;

	@Column(nullable = false)
	private String iconSelected;

	@Column(nullable = false)
	private Integer priority;

	public boolean isMainTag() {
		return name.equals("대표");
	}

	public boolean isEntertainmentTag() {
		return name.equals("엔터테인먼트");
	}

	@Builder
	public Tag(String name, String imageUrl, String icon, String iconSelected, Integer priority) {
		this.name = name;
		this.image = Image.from(imageUrl);
		this.icon = icon;
		this.iconSelected = iconSelected;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Tag{" +
			"id=" + id +
			", name='" + name + '\'' +
			", image=" + image +
			", icon='" + icon + '\'' +
			", iconSelected='" + iconSelected + '\'' +
			", priority=" + priority +
			'}';
	}
}
