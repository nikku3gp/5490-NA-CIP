package uacs.cip.nutrient.supplement.config;

import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import uacs.cip.nutrient.supplement.entity.LogSupplement;
import uacs.cip.nutrient.supplement.repository.NutrientGoalRepository;
import uacs.cip.nutrient.supplement.repository.LogSupplementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(NutrientGoalRepository nutrientGoalRepo, LogSupplementRepository logSupplementRepo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<NutrientGoal> savedGoals = nutrientGoalRepo.saveAll(
                        List.of(
                                new NutrientGoal("Vitamin C", 90.0),
                                new NutrientGoal("Iron", 18.0),
                                new NutrientGoal("Calcium", 1000.0)
                        ));
                List<LogSupplement> savedLogs = logSupplementRepo.saveAll(
                        List.of(
                                new LogSupplement("Vitamin C", "EmergenC", 60.0, LocalDate.now()),
                                new LogSupplement("Iron", "IronC", 60.0, LocalDate.now()),
                                new LogSupplement("Calcium", "Calc", 60.0, LocalDate.now()),
                                new LogSupplement("Vitamin C", "EmergenC", 40.0, LocalDate.now().minusDays(1)),
                                new LogSupplement("Iron", "IronC", 9, LocalDate.now().minusDays(3))
                        ));
            }
        };
    }
}
