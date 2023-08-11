package com.softeer.caart.domain.option.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.tag.entity.Tag;

import lombok.Getter;

@Entity
@Table(name = "rel_tag_base_option_info")
@Getter
public class OptionTag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_tag_base_option_info_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "base_option_info_id", nullable = false)
	private BaseOptionInfo option;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "tag_id", nullable = false)
	private Tag tag;
}
