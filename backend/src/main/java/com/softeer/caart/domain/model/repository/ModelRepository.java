package com.softeer.caart.domain.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

public interface ModelRepository extends JpaRepository<Model, Long> {

	@Query(value = "SELECT * FROM model WHERE trim_id = :trimId AND car_engine_id = :engineId AND body_type_id = :bodyTypeId AND wd_id = :wdId", nativeQuery = true)
	Optional<Model> findModelByTrimIdAndCompositionsId(Long trimId, Long engineId, Long bodyTypeId, Long wdId);

	@Query(value = "select count(*) "
		+ "from purchase p "
		+ "group by p.model_id "
		+ "order by p.model_id",
		nativeQuery = true)
	List<Long> countPurchasedModel();

	/**
	 * @return 추천 가장 많이 받은 모델 1개
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
