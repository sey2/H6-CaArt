package com.softeer.caart.domain.option.entity;

public enum Badge {

	H_GENUINE_ACCESSORIES("H Genuine Accessories"),
	N_PERFORMANCE("N Performance"),
	NONE(null);

	private final String name;

	Badge(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
