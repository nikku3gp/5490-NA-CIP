package uacs.cip.nutrient.supplement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.nutrient.supplement.entity.LogSupplement;
import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import uacs.cip.nutrient.supplement.entity.NutrientSummary;
import uacs.cip.nutrient.supplement.repository.LogSupplementRepository;
import uacs.cip.nutrient.supplement.repository.NutrientGoalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NutrientSumService {
    @Autowired
    private NutrientGoalRepository nutrientGoalRepository;
    @Autowired
    private LogSupplementRepository logSupplementRepository;

    public List<NutrientSummary> getSummaryForDate(LocalDate date){
        //get all logs and goals
        List<LogSupplement> logs = logSupplementRepository.findByDate(date);
        List<NutrientGoal> goals = nutrientGoalRepository.findAll();
        //map the nutrient type and the amount
        Map<String, Double> consumedByNutrient = logs.stream().collect(Collectors.groupingBy(LogSupplement::getNutrientType, Collectors.summingDouble(LogSupplement::getAmount)));
        //create a list to store all goals and check if goal is met
        List<NutrientSummary> summs = new ArrayList<>();
        for(NutrientGoal goal:goals){
            String nutrient = goal.getNutrientType();
            double consumed = consumedByNutrient.getOrDefault(nutrient, 0.0);
            boolean met = consumed >= goal.getTargetAmount();

            summs.add(new NutrientSummary(nutrient, consumed, goal.getTargetAmount(), met, date));
        }

        return summs;
    }
}
