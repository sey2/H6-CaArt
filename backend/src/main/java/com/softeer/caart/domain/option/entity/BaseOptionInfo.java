package com.softeer.caart.domain.option.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.softeer.caart.domain.Image;
import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.global.ResultCode;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "base_option_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseOptionInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "base_option_info_id")
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(nullable = true)
	private String description;

	@Column(nullable = false)
	private Boolean isBasic;

	@Embedded
	private Image image;

	@OneToMany(mappedBy = "option")
	private List<OptionTag> tags = new ArrayList<>();

	@Builder
	public BaseOptionInfo(String name, String description, Boolean isBasic, String imageUrl) {
		this.name = name;
		this.description = description;
		this.isBasic = isBasic;
		this.image = Image.from(imageUrl);
	}

	public boolean isOptionTypeBasic() {
		return this.isBasic;
	}

	public void validateBasicOption() {
		if (!isOptionTypeBasic()) {
			throw new InvalidOptionException(ResultCode.INVALID_BASIC_OPTION);
		}
	}
}
