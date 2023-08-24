package com.softeer.caart.domain.option.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
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

import com.softeer.caart.domain.option.dto.response.BaseOptionResponse;
import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.global.ResultCode;

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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_option_info_id", nullable = false)
	private BaseOptionInfo details;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Boolean isSetOption = false;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Badge badge;

	@Column(nullable = false)
	private String summary;

	@OneToMany(mappedBy = "option")
	private List<Position> positions;

	@OneToMany(mappedBy = "superOption")
	private List<SubOptionInfo> subOptions = new ArrayList<>();

	@Builder
	public AdditionalOptionInfo(BaseOptionInfo details, Integer price, Boolean isSetOption, Badge badge, String summary,
		List<SubOptionInfo> subOptions) {
		this.details = details;
		this.price = price;
		this.isSetOption = isSetOption;
		this.badge = badge;
		this.summary = summary;
		this.subOptions = subOptions;
	}

	public boolean isOptionTypeSet() {
		return this.isSetOption;
	}

	public void validateAdditionalOption() {
		if (details.isOptionTypeBasic()) {
			throw new InvalidOptionException(ResultCode.INVALID_ADDITIONAL_OPTION);
		}
	}

	public List<String> getTagNames() {
		return details.getTags().stream()
			.map(optionTag -> optionTag.getTag().getName())
			.sorted()
			.collect(Collectors.toList());
	}

	public List<BaseOptionResponse> getSubOptions() {
		if (!isOptionTypeSet()) {
			return new ArrayList<>();
		}
		return subOptions.stream()
			.map(subOptionInfo -> BaseOptionResponse.from(subOptionInfo.getDetails()))
			.sorted(Comparator.comparing(BaseOptionResponse::getOptionName))
			.collect(Collectors.toList());
	}

	public String getBadgeName() {
		return this.badge.getName();
	}
}
