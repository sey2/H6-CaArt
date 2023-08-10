package com.softeer.caart.domain.trim.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rel_trim_base_option_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MainOptionOfTrim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_trim_base_option_info_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "trim_id", nullable = false)
	private Trim trim;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "base_option_info_id", nullable = false)
	private BaseOptionInfo mainOption;

	public MainOptionOfTrim(Trim trim, BaseOptionInfo mainOption) {
		this.trim = trim;
		this.mainOption = mainOption;
	}
}

