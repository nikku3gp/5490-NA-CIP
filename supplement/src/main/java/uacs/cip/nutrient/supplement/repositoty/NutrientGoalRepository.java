package uacs.cip.nutrient.supplement.repositoty;

import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface NutrientGoalRepository extends JpaRepository<NutrientGoal, Long> {
    Optional<NutrientGoal> findByNutrientType(String nutrientType);
}
