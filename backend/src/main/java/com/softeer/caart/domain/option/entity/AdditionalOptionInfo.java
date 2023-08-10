package com.softeer.caart.domain.option.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "additional_option_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdditionalOptionInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "additional_option_info_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "base_option_info_id", nullable = false)
	private BaseOptionInfo details;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Boolean isSetOption = false;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Badge badge;

	private String summary = null;  // 세트 옵션의 경우 null, 설명이 없는 옵션의 경우 "-"

	@Embedded
	private Position position;

	@OneToMany(mappedBy = "mainOptionInfo")
	private List<SubOptionInfo> subOptions;

	@Builder
	public AdditionalOptionInfo(BaseOptionInfo details, Integer price, Boolean isSetOption, Badge badge, String summary,
		Position position) {
		this.details = details;
		this.price = price;
		this.isSetOption = isSetOption;
		this.badge = badge;
		this.summary = summary;
		this.position = position;
	}
}
