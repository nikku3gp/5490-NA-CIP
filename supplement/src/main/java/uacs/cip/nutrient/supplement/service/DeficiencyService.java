package uacs.cip.nutrient.supplement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.nutrient.supplement.entity.Deficiency;
import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import uacs.cip.nutrient.supplement.entity.LogSupplement;
import uacs.cip.nutrient.supplement.repository.NutrientGoalRepository;
import uacs.cip.nutrient.supplement.repository.LogSupplementRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DeficiencyService {
    @Autowired
    public NutrientGoalRepository nutrientGoalRepository;
    @Autowired
    public LogSupplementRepository logSupplementRepository;

    public List<Deficiency> getDeficiencyForDate(LocalDate date){
        //get all logs and goals
        List<LogSupplement> logs = logSupplementRepository.findByDate(date);
        List<NutrientGoal> goals = nutrientGoalRepository.findAll();
        //map nutrient type and amount
        Map<String, Double> consumedByNutrient = logs.stream().collect(Collectors.groupingBy(LogSupplement::getNutrientType,Collectors.summingDouble(LogSupplement::getAmount)));
        //create a list to store all deficiencies that haven't been met and by how much
        List<Deficiency> alerts = new ArrayList<>();
        for(NutrientGoal goal:goals){
            String nutrient = goal.getNutrientType();
            double consumed = consumedByNutrient.getOrDefault(nutrient, 0.0);
            double target = goal.getTargetAmount();
            if(consumed < target){
                double deficit = target - consumed;
                alerts.add(new Deficiency(nutrient, consumed, target, deficit, date));
            }
        }
        return alerts;
    }

}
