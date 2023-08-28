package com.softeer.caart.domain.tag.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.domain.Sort.Direction.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.tag.dto.TagResponse;
import com.softeer.caart.domain.tag.entity.Tag;
import com.softeer.caart.domain.tag.repository.TagRepository;

class TagServiceTest extends ServiceTest {
	@InjectMocks
	private TagService tagService;

	@Mock
	private TagRepository tagRepository;

	@Test
	@DisplayName("priority 순으로 태그를 가져온다")
	void getTagsOrderByPriority() {
		// given
		doReturn(new ArrayList<Tag>(Arrays.asList(메인태그_우선순위10, 전체태그_우선순위5))).when(tagRepository)
			.findAll(Sort.by(Sort.Direction.DESC, "priority"));

		// when
		List<TagResponse> tags = tagService.getBasicOptionTags();
		TagResponse firstTag = tags.get(0);
		TagResponse secondTag = tags.get(1);

		// then
		softly.assertThat(firstTag.getTagName()).isEqualTo(메인태그_우선순위10.getName());
		softly.assertThat(secondTag.getTagName()).isEqualTo(전체태그_우선순위5.getName());
	}

	@Test
	@DisplayName("추가 옵션 목록에는 메인 태그와 엔터테인먼트 태그가 존재하지 않는다")
	void notExistMainAndEntertainment() {
		// given
		Tag coldAndHotTag = Tag.builder()
			.name("추위/더위")
			.imageUrl("")
			.icon("")
			.iconSelected("")
			.priority(1)
			.build();
		ReflectionTestUtils.setField(coldAndHotTag, "id", 1L);

		doReturn(List.of(coldAndHotTag)).when(tagRepository).findAll(Sort.by(DESC, "priority"));

		// when
		List<TagResponse> tags = tagService.getAdditionalOptionTags();

		// then
		for (TagResponse tag : tags) {
			assertNotEquals("메인", tag.getTagName());
			assertNotEquals("엔터테인먼트", tag.getTagName());
		}

	}
}
