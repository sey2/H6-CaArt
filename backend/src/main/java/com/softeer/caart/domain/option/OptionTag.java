package com.softeer.caart.domain.option;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.tag.Tag;

@Entity
@Table(name = "rel_car_option_tag")
public class OptionTag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_car_option_tag_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "car_option_id", nullable = false)
	private CarOption carOption;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "tag_id", nullable = false)
	private Tag tag;
}
