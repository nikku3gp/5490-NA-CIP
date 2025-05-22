package uacs.cip.nutrient.supplement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uacs.cip.nutrient.supplement.entity.Deficiency;
import uacs.cip.nutrient.supplement.service.DeficiencyService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/supplements/deficiency")
public class DeficiencyCont {
    @Autowired
    public DeficiencyService deficiencyService;

    @GetMapping
    public List<Deficiency> getAlert(@RequestParam LocalDate date){
        List<Deficiency> alert = deficiencyService.getDeficiencyFroDate(date);
        return alert;
    }
}
