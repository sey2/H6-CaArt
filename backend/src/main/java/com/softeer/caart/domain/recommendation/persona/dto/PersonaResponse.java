package com.softeer.caart.domain.recommendation.persona.dto;

import java.util.List;

import com.softeer.caart.domain.recommendation.persona.entity.Persona;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonaResponse {

	private Long personaId;
	private String profileImage;
	private String coverLetter;
	private List<String> tags;

	public static PersonaResponse from(Persona persona) {
		return PersonaResponse.builder()
			.personaId(persona.getId())
			.profileImage(persona.getProfile().getImage())
			.coverLetter(persona.getCoverLetter())
			.tags(persona.getTagNameList())
			.build();
	}
}
