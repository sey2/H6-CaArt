package com.softeer.caart.domain.option.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.tag.entity.Tag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "position_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "additional_option_info_id", nullable = false)
	private AdditionalOptionInfo option;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", nullable = false)
	private Tag tag;

	@Column(name = "web_x", nullable = false)
	private Double webX;

	@Column(name = "web_y", nullable = false)
	private Double webY;

	@Column(name = "mobile_x", nullable = false)
	private Double mobileX;

	@Column(name = "mobile_y", nullable = false)
	private Double mobileY;
}
