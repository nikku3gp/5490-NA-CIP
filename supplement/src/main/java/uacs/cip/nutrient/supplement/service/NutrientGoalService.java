package uacs.cip.nutrient.supplement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.nutrient.supplement.entity.NutrientGoal;
import uacs.cip.nutrient.supplement.repositoty.NutrientGoalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NutrientGoalService {
    @Autowired
    private NutrientGoalRepository nutrientGoalRepository;

    public List<NutrientGoal> getAllGoals(){
        return nutrientGoalRepository.findAll();
    }

    public Optional<NutrientGoal> getGoal(Long id){
        return nutrientGoalRepository.findById(id);
    }

    public Optional<NutrientGoal> getGoalByType(String nutrientType){
        return nutrientGoalRepository.findByNutrientType(nutrientType);
    }

    public NutrientGoal saveGoal(NutrientGoal nutrientGoal){
        return nutrientGoalRepository.save(nutrientGoal);
    }

    public void deleteGoal(Long id){
        nutrientGoalRepository.deleteById(id);
    }
}
