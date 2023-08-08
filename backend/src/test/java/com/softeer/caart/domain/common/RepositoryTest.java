package com.softeer.caart.domain.common;

import static com.softeer.caart.domain.option.entity.Badge.*;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.softeer.caart.domain.option.entity.CarOption;
import com.softeer.caart.domain.option.repository.CarOptionRepository;
import com.softeer.caart.domain.trim.entity.MainOptionOfTrim;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.domain.trim.repository.MainOptionOfTrimRepository;
import com.softeer.caart.domain.trim.repository.TrimRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SoftAssertionsExtension.class)
public class RepositoryTest {
	@InjectSoftAssertions
	protected SoftAssertions softly;

	@Autowired
	protected TrimRepository trimRepository;
	@Autowired
	protected MainOptionOfTrimRepository mainOptionOfTrimRepository;
	@Autowired
	protected CarOptionRepository carOptionRepository;

	protected Trim LeBlanc;
	protected Trim Exclusive;

	protected CarOption 알로이힐;
	protected CarOption 서라운드뷰모니터;

	protected MainOptionOfTrim 메인옵션1OfLeBlanc;
	protected MainOptionOfTrim 메인옵션2OfLeBlanc;

	@BeforeEach
	void initDummyData() {
		initTrim();
		initCarOption();
		initMainOptionOfTrim();
	}

	private void initTrim() {
		LeBlanc = Trim.builder()
			.name("Le Blanc")
			.description("필수적인 옵션만 모은")
			.price(41980000)
			.imageUrl("tmp")
			.build();

		Exclusive = Trim.builder()
			.name("Exclusive")
			.description("합리적인 당신을 위한")
			.price(38960000)
			.imageUrl("tmp")
			.build();
	}

	private void initCarOption() {
		알로이힐 = CarOption.builder()
			.name("20인치 알로이 휠")
			.description("-")
			.imageUrl("tmp")
			.price(0)
			.badge(NONE)
			.isSetOption(false)
			.isAdditionalOption(false)
			.build();

		서라운드뷰모니터 = CarOption.builder()
			.name("서라운드 뷰 모니터")
			.description(
				"차량 앞/뒤/좌/우 360도 모든 상황을 AVN화면을 통해 볼 수 있는 장치로 고화질 카메라 및 디지털 영상 전송 방식을 적용하여 영상 경계선 없이 선명하고 깨끗한 화질을 제공합니다.")
			.imageUrl("tmp")
			.price(0)
			.badge(NONE)
			.isSetOption(false)
			.isAdditionalOption(false)
			.build();
	}

	private void initMainOptionOfTrim() {
		메인옵션1OfLeBlanc = new MainOptionOfTrim(LeBlanc, 알로이힐);
		메인옵션2OfLeBlanc = new MainOptionOfTrim(LeBlanc, 서라운드뷰모니터);
	}
}
