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

	@Column(nullable = false)
	private Double mobileX;

	@Column(nullable = false)
	private Double mobileY;

	@Column(nullable = false)
	private Double webX;

	@Column(nullable = false)
	private Double webY;
}
