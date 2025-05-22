package uacs.cip.nutrient.supplement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uacs.cip.nutrient.supplement.config.WebMvcConfig;
import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import uacs.cip.nutrient.supplement.service.NutrientGoalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/supplements/goals")
public class NutrientGoalCont {
    private static final Logger logger = LoggerFactory.getLogger(NutrientGoalCont.class);
    @Autowired
    private NutrientGoalService nutrientGoalService;

    @GetMapping
    public List<NutrientGoal> getAllGoals(){

        return nutrientGoalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public Optional<NutrientGoal> getGoal(@PathVariable Long id){
        logger.warn("Bleh");
        return nutrientGoalService.getGoal(id);
    }

    @GetMapping("/{nutrientType}")
    public Optional<NutrientGoal> getGoalByType(@PathVariable String nutrientType){
        return nutrientGoalService.getGoalByType(nutrientType);
    }

    @PostMapping
    public NutrientGoal createGoal(@RequestBody NutrientGoal nutrientGoal){
        return nutrientGoalService.saveGoal(nutrientGoal);
    }

    @PutMapping("/{id}")
    public NutrientGoal updateGoal(@PathVariable Long id, @RequestBody NutrientGoal nutrientGoal){
        nutrientGoal.setId(id);
        return nutrientGoalService.saveGoal(nutrientGoal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id){

        nutrientGoalService.deleteGoal(id);
    }
}
