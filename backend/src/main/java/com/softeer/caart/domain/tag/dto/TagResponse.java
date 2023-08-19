package com.softeer.caart.domain.tag.dto;

import com.softeer.caart.domain.Image;
import com.softeer.caart.domain.tag.entity.Tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TagResponse {
	private Long tagId;
	private String tagName;
	private String tagImage;
	private String tagIcon;
	private String tagIconSelected;
	private Integer priority;

	private TagResponse(Tag tag, String tagImage) {
		this.tagId = tag.getId();
		this.tagName = tag.getName();
		this.tagImage = tagImage;
		this.tagIcon = tag.getIcon();
		this.tagIconSelected = tag.getIconSelected();
		this.priority = tag.getPriority();
	}

	public static TagResponse from(Tag tag) {
		Image tagImage = tag.getImage();
		if (tagImage.isNull()) {
			return new TagResponse(tag, null);
		}
		return new TagResponse(tag, tagImage.getUrl());
	}
}
