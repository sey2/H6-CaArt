package com.softeer.caart.domain.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.softeer.caart.domain.composition.entity.BodyType;
import com.softeer.caart.domain.composition.entity.CarEngine;
import com.softeer.caart.domain.composition.entity.WheelDrive;
import com.softeer.caart.domain.trim.entity.Trim;

class ModelTest {
	private CarEngine engine;
	private BodyType bodyType;
	private WheelDrive wheelDrive;
	private Trim trim;
	private Model model;

	@BeforeEach
	void init() {
		engine = CarEngine.builder()
			.price(1)
			.build();
		wheelDrive = WheelDrive.builder()
			.price(1)
			.build();
		trim = Trim.builder()
			.price(1)
			.build();
		ReflectionTestUtils.setField(trim, "id", 1L);

		model = Model.builder()
			.carEngine(engine)
			.bodyType(bodyType)
			.wheelDrive(wheelDrive)
			.trim(trim)
			.build();
	}

	@Test
	@DisplayName("모델의 가격을 가져온다 (엔진 가격 + 구동방식 가격 + 트림 가격)")
	void calcModelPrice() {
		// given
		int enginePrice = engine.getPrice();
		int wdPrice = wheelDrive.getPrice();
		int trimPrice = trim.getPrice();
		int sum = enginePrice + wdPrice + trimPrice;

		// when
		int modelPrice = model.calcModelPrice();

		// then
		assertEquals(sum, modelPrice);
	}

	@Test
	@DisplayName("trim의 id를 가져온다")
	void getTrimId() {
		// given
		Long trimId = trim.getId();

		// when
		Long trimIdOfModel = model.getTrimId();

		// then
		assertEquals(trimId, trimIdOfModel);
	}
}