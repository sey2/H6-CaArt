package com.softeer.caart.domain.color.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softeer.caart.domain.trim.entity.Trim;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "rel_trim_color")
public class AvailableColor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_trim_color_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "trim_id", nullable = false)
	private Trim trim;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;

	@Column(name = "adoption_rate_twenty")
	private Double adoptionRateTwenty;

	@Column(name = "adoption_rate_thirty")
	private Double adoptionRateThirty;

	@Column(name = "adoption_rate_forty")
	private Double adoptionRateForty;

	@Column(name = "adoption_rate_fifty_or_above")
	private Double adoptionRateFiftyOrAbove;

	@Column(name = "adoption_rate_all")
	private Double adoptionRateAll;

	@Builder
	public AvailableColor(Trim trim, Color color) {
		this.trim = trim;
		this.color = color;
		this.adoptionRateTwenty = 0.0;
		this.adoptionRateThirty = 0.0;
		this.adoptionRateForty = 0.0;
		this.adoptionRateFiftyOrAbove = 0.0;
		this.adoptionRateAll = 0.0;
	}

	public void updateAdoptionRate(AgeGroup ageGroup, double adoptionRate) {
		switch (ageGroup) {
			case TWENTY:
				adoptionRateTwenty = adoptionRate;
				break;
			case THIRTY:
				adoptionRateThirty = adoptionRate;
				break;
			case FORTY:
				adoptionRateForty = adoptionRate;
				break;
			case FIFTY_OR_ABOVE:
				adoptionRateFiftyOrAbove = adoptionRate;
				break;
			case ALL:
				adoptionRateAll = adoptionRate;
				break;
		}
	}

	public double getAdoptionRate(AgeGroup ageGroup) {
		if (ageGroup == null) {
			return adoptionRateAll;
		}
		switch (ageGroup) {
			case TWENTY:
				return adoptionRateTwenty;
			case THIRTY:
				return adoptionRateThirty;
			case FORTY:
				return adoptionRateForty;
			case FIFTY_OR_ABOVE:
				return adoptionRateFiftyOrAbove;
			default:
				return adoptionRateAll;
		}
	}
}
