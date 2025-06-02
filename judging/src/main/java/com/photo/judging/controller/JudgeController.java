package com.photo.judging.controller;
import com.photo.judging.entity.Judge;
import com.photo.judging.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;

    @GetMapping
    public List<Judge> getAllJudges(){
        return judgeService.getAllJudges();
    }

    @GetMapping("/{id}")
    public Optional<Judge> getJudge(@PathVariable Long id){
        return judgeService.getJudge(id);
    }

    @PostMapping
    public Judge createJudge(@RequestBody Judge judge){
        return judgeService.saveJudge(judge);
    }

    @PutMapping("/{id}")
    public Judge updateJudge(@PathVariable Long id, @RequestBody Judge judge){
        judge.setId(id);
        return judgeService.saveJudge(judge);
    }

    @DeleteMapping("/{id}")
    public void deleteJudge(@PathVariable Long id){
        judgeService.deleteJudge(id);
    }
}
