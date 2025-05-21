package uacs.cip.nutrient.supplement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacs.cip.nutrient.supplement.entity.LogSupplement;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface LogSupplementRepository extends JpaRepository<LogSupplement, Long> {
    List<LogSupplement> findByDate(LocalDate date);
    List<LogSupplement> findByDateBetween(LocalDate start, LocalDate end);
}
