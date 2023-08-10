package com.softeer.caart.domain.option.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "sub_option_info")
@Getter
public class SubOptionInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_option_info_id")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_option_info_id", nullable = false)
	private BaseOptionInfo details;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "additional_option_info_id", nullable = false)
	private AdditionalOptionInfo superOption;
}
