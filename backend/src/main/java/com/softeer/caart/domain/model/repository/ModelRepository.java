package com.softeer.caart.domain.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

public interface ModelRepository extends JpaRepository<Model, Long> {

	/**
	 * 트림, 엔진, 바디 타입, 구동 방식에 대한 모델을 조회한다.
	 */
	@Query(value = "SELECT m "
		+ "FROM Model m "
		+ "WHERE m.trim.id = :trimId "
		+ "AND m.carEngine.id = :engineId "
		+ "AND m.bodyType.id = :bodyTypeId "
		+ "AND m.wheelDrive.id = :wdId")
	Optional<Model> findModelByTrimIdAndCompositionsId(Long trimId, Long engineId, Long bodyTypeId, Long wdId);

	/**
	 * 모델별 구매 횟수를 조회한다. (모델 아이디에 대해 오름차순 정렬)
	 */
	@Query(value = "select count(*) "
		+ "from purchase p "
		+ "group by p.model_id "
		+ "order by p.model_id",
		nativeQuery = true)
	List<Long> countPurchasedModel();

	/**
	 * 운전 경력(experience), 가족 구성원(family), 운전 목적(purpose), 가치관(value), 예산 범위(minBudget~maxBudget)에 대해
	 * 카마스터 설문으로부터 가장 많이 추천 받은 모델 1개를 조회한다.
	 */
	@Query(value = "SELECT m.* FROM model m "
		+ "WHERE m.model_id = (SELECT cms.model_id"
		+ "                  FROM car_master_survey cms"
		+ "                  WHERE 1 = 1"
		+ "                    AND cms.experience_code = :#{#experience.name()}"
		+ "                    AND cms.purpose_code = :#{#purpose.name()}"
		+ "                    AND cms.value_code = :#{#value.name()}"
		+ "                    AND cms.family_code = :#{#family.name()}"
		+ "                    AND cms.total_sum BETWEEN :minBudget AND :maxBudget"
		+ "                  GROUP BY cms.model_id"
		+ "                  ORDER BY COUNT(*) DESC"
		+ "                  LIMIT 1)", nativeQuery = true)
	Optional<Model> findMostRecommendedModelByCondition(Answer experience, Answer family, Answer purpose, Answer value,
		int minBudget, int maxBudget);
}
