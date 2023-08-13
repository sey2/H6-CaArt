package com.softeer.caart.domain.tag.service;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;

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
		List<TagResponse> tags = tagService.getTags();
		TagResponse firstTag = tags.get(0);
		TagResponse secondTag = tags.get(1);

		// then
		softly.assertThat(firstTag.getTagName()).isEqualTo(메인태그_우선순위10.getName());
		softly.assertThat(secondTag.getTagName()).isEqualTo(전체태그_우선순위5.getName());
	}
}