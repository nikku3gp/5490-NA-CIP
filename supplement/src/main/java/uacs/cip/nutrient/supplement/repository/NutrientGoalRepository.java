package uacs.cip.nutrient.supplement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacs.cip.nutrient.supplement.entity.NutrientGoal;

import java.util.Optional;
@Repository
public interface NutrientGoalRepository extends JpaRepository<NutrientGoal, Long> {
    Optional<NutrientGoal> findByNutrientType(String nutrientType);
}
