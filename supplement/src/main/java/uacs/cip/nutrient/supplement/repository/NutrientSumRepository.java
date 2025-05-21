package uacs.cip.nutrient.supplement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacs.cip.nutrient.supplement.entity.NutrientSummary;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface NutrientSumRepository extends JpaRepository<NutrientSummary, Long>{
    Optional<NutrientSummary> findByDate(LocalDate date);
}
