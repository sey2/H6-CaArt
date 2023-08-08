package com.softeer.caart.domain.option.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.option.entity.CarOption;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CarOptionResponse {
	private Long id;
	private String name;
	private Integer price;
	private String description;
	private String image;
	private List<String> tags;
	private List<ChildCarOptionResponse> childOptions;

	private CarOptionResponse(CarOption option) {
		this.id = option.getId();
		this.name = option.getName();
		this.price = option.getPrice();
		this.description = option.getDescription();
		this.image = option.getImage().getUrl();
		this.tags = option.getTags().stream()
			.map(optionTag -> optionTag.getTag().getName())
			.sorted()
			.collect(Collectors.toList());
		this.childOptions = option.getChildOptions().stream()
			.map(ChildCarOptionResponse::from)
			.sorted(Comparator.comparing(ChildCarOptionResponse::getName))
			.collect(Collectors.toList());
	}

	public static CarOptionResponse from(CarOption option) {
		return new CarOptionResponse(option);
	}
}
