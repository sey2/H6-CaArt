package com.softeer.caart.global.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OpenAiFeign", url = "https://dxts501dik.execute-api.ap-northeast-2.amazonaws.com/stage/generate-reason")
public interface OpenAiFeign {

	@PostMapping
	String getRecommendationMessage(@RequestBody List<String> reasons);
}
