package com.softeer.caart.domain.composition.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;

class CompositionRepositoryTest extends RepositoryTest {

	@Autowired
	private CarEngineRepository carEngineRepository;

	@Autowired
	private BodyTypeRepository bodyTypeRepository;

	@Autowired
	private WheelDriveRepository wheelDriveRepository;
	//
	// @Test
	// @DisplayName("존재하지 않는 엔진을 조회하는 경우 404 에러가 발생한다.")
	// void carEngineNotFound() {
	// 	assertThatThrownBy(() -> carEngineRepository.findById(-1L))
	// 		.isInstanceOf(EngineNotFoundException.class)
	// 		.hasMessage(ResultCode.ENGINE_NOT_FOUND.getMessage());
	// }
	//
	// @Test
	// @DisplayName("존재하지 않는 바디 타입을 조회하는 경우 404 에러가 발생한다.")
	// void bodyTypeNotFound() {
	//
	// }
	//
	// @Test
	// @DisplayName("존재하지 않는 구동 방식을 조회하는 경우 404 에러가 발생한다.")
	// void wdNotFound() {
	//
	// }
}
