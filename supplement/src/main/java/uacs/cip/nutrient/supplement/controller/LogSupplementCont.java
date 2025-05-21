package uacs.cip.nutrient.supplement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uacs.cip.nutrient.supplement.entity.LogSupplement;
import uacs.cip.nutrient.supplement.service.LogSupplementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplements/logs")
public class LogSupplementCont {
    @Autowired
    private LogSupplementService logSupplementService;

    @GetMapping
    public List<LogSupplement> getAllLogs(){
        return logSupplementService.getAllLogs();
    }

    @GetMapping("/{id}")
    public Optional<LogSupplement> getLog(@PathVariable Long id){
        return logSupplementService.getLog(id);
    }

    @GetMapping("/date")
    public List<LogSupplement> getLogByDate(@RequestParam LocalDate date){
        return logSupplementService.getLogByDate(date);
    }

    @GetMapping("/dateRange")
    public List<LogSupplement> getLogByDateRange(@RequestParam LocalDate start, @RequestParam LocalDate end){
        return logSupplementService.getLogByDateRange(start, end);
    }

    @PostMapping
    public LogSupplement createLog(@RequestBody LogSupplement logSupplement){
        return logSupplementService.saveLog(logSupplement);
    }

    @PutMapping("/{id}")
    public LogSupplement updateLog(@PathVariable Long id, @RequestBody LogSupplement logSupplement){
        logSupplement.setId(id);
        return logSupplementService.saveLog(logSupplement);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id){
        logSupplementService.deleteLog(id);
    }
}
