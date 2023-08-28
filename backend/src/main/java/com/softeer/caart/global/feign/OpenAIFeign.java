package com.softeer.caart.global.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.softeer.caart.domain.recommendation.lifestyle.dto.response.ReasonDto;

@FeignClient(name = "OpenAIFeign", url = "${openAI.api.uri}")
public interface OpenAIFeign {

	/**
	 * LM Model : gpt-3.5 turbo
	 * 추천 사유 문장을 한 문장으로 요약하며 ~해요" 체로 끝나도록 한다.
	 * "
	 */
	@PostMapping("/generate-reason")
	ReasonDto summaryReasons(@RequestBody List<String> reasons);
}
