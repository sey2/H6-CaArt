package com.softeer.caart.domain.tag.dto;

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
	private Integer priority;

	private TagResponse(Tag tag) {
		this.tagId = tag.getId();
		this.tagName = tag.getName();
		this.tagImage = tag.getImage().getUrl();
		this.priority = tag.getPriority();
	}

	public static TagResponse from(Tag tag) {
		return new TagResponse(tag);
	}
}
