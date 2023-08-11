package com.softeer.caart.domain.option.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Position {

	@Column(nullable = false, name = "mobile_x")
	private Double mobileX;

	@Column(nullable = false, name = "mobile_y")
	private Double mobileY;

	@Column(nullable = false, name = "web_x")
	private Double webX;

	@Column(nullable = false, name = "web_y")
	private Double webY;
}
