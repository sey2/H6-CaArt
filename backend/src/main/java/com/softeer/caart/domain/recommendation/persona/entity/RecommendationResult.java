package com.softeer.caart.domain.recommendation.persona.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.softeer.caart.domain.model.entity.Model;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recommended_option_id_1", nullable = false)
	private AdditionalOptionInfo firstOption;

	@Column(name = "recommendation_explanation_1", nullable = false, length = 100)
	private String firstExplanation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recommended_option_id_2", nullable = false)
	private AdditionalOptionInfo secondOption;

	@Column(name = "recommendation_explanation_2", nullable = false, length = 100)
	private String secondExplanation;

	@OneToOne(mappedBy = "recommendationResult")
	private Persona persona;

	public List<AdditionalOptionInfo> getRecommendedOptionList() {
		return List.of(firstOption, secondOption);
	}

	public List<String> getExplanationList() {
		return List.of(firstExplanation, secondExplanation);
	}

	public Integer calcTotalPrice() {
		return model.calcModelPrice()
			+ firstOption.getPrice() + secondOption.getPrice();
	}
}
