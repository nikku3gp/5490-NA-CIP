package uacs.cip.nutrient.supplement.controller;
import uacs.cip.nutrient.supplement.entity.NutrientSummary;
import uacs.cip.nutrient.supplement.service.NutrientSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/supplements/summary")
public class NutrientSumCont {
    @Autowired
    private NutrientSumService nutrientSumService;

    @GetMapping
    public List<NutrientSummary> getSummary(@RequestParam LocalDate date){
        List<NutrientSummary> summs = nutrientSumService.getSummaryForDate(date);
        return summs;
    }
}
