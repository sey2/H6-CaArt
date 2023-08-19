package com.softeer.caart.domain.option.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Position {

	@Id
	@GeneratedValue
	@Column(name = "position_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "additional_option_info_id", nullable = false)
	private AdditionalOptionInfo option;

	@Column(nullable = false)
	private Double x;

	@Column(nullable = false)
	private Double y;

	@Column(nullable = false)
	private Boolean isMobile;

}
