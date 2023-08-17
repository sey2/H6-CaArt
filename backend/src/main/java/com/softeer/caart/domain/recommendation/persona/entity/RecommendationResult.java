package com.softeer.caart.domain.recommendation.persona.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.model.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RecommendationResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recommendation_result_id")
	private Long id;

	@Column(name = "palisage_image", nullable = false)
	private String palisageImage;

	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;

	@ManyToOne
	@JoinColumn(name = "exterior_color_id", nullable = false)
	private Color exteriorColor;

	@ManyToOne
	@JoinColumn(name = "interior_color_id", nullable = false)
	private Color interiorColor;

	@ManyToOne
	@JoinColumn(name = "recommended_option_id_1", nullable = false)
	private AdditionalOptionInfo firstOption;

	@Column(name = "recommendation_explanation_1", nullable = false, length = 100)
	private String firstExplanation;

	@ManyToOne
	@JoinColumn(name = "recommended_option_id_2", nullable = false)
	private AdditionalOptionInfo secondOption;

	@Column(name = "recommendation_explanation_2", nullable = false, length = 100)
	private String secondExplanation;

	public List<Color> getRecommendedColorList() {
		return List.of(exteriorColor, interiorColor);
	}

	public List<AdditionalOptionInfo> getRecommendedOptionList() {
		return List.of(firstOption, secondOption);
	}

	public Integer calcTotalPrice() {
		return model.calcModelPrice()
			+ exteriorColor.getPrice() + interiorColor.getPrice()
			+ firstOption.getPrice() + secondOption.getPrice();
	}
}
