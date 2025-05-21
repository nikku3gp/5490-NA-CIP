package uacs.cip.nutrient.supplement.service;
import uacs.cip.nutrient.supplement.entity.NutrientSummary;
import uacs.cip.nutrient.supplement.repositoty.NutrientSumRepository;
import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import uacs.cip.nutrient.supplement.repositoty.NutrientGoalRepository;
import uacs.cip.nutrient.supplement.entity.LogSupplement;
import uacs.cip.nutrient.supplement.repositoty.LogSupplementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NutrientSumService {
    @Autowired
    private NutrientSumRepository nutrientSumRepository;
    @Autowired
    private NutrientGoalRepository nutrientGoalRepository;
    @Autowired
    private LogSupplementRepository logSupplementRepository;

    public List<NutrientSummary> getSummaryForDate(LocalDate date){
        //get all logs and goals
        List<LogSupplement> logs = logSupplementRepository.findByDate(date);
        List<NutrientGoal> goals = nutrientGoalRepository.findAll();
        //map the nutrient type to the goal
        Map<String, Double> consumedByNutrient = logs.stream().collect(Collectors.groupingBy(LogSupplement::getNutrientType, Collectors.summingDouble(LogSupplement::getAmount)));
        //create a list to store all goals and return them
        List<NutrientSummary> summs = new ArrayList<>();
        for(NutrientGoal goal:goals){
            String nutrient = goal.getNutrientType();
            double consumed = consumedByNutrient.getOrDefault(nutrient, 0.0);
            boolean met = consumed >= goal.getTargetAmount();

            summs.add(new NutrientSummary(nutrient, consumed, goal.getTargetAmount(), met));
        }

        return summs;
    }
}
