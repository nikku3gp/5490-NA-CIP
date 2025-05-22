package uacs.cip.nutrient.supplement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacs.cip.nutrient.supplement.entity.Deficiency;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface DeficiencyRepository extends JpaRepository<Deficiency, Long> {
    List<Deficiency> getDeficiencyForDate(LocalDate date);
}
