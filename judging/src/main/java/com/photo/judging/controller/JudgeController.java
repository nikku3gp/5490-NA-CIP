package com.photo.judging.controller;
import com.photo.judging.entity.Judge;
import com.photo.judging.entity.Score;
import com.photo.judging.service.JudgeService;
import com.photo.judging.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;
    @Autowired
    private ScoreService scoreService;

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

    @GetMapping("/{judgeId}/scores")
    public List<Score> getJudgeScore(@PathVariable Long judgeId){
        return judgeService.getJudgeScore(judgeId);
    }
    @PostMapping("/{judgeId}/submissions/{subId}/scores")
    public ResponseEntity<Score> addScore(@PathVariable Long judgeId, @PathVariable Long subId, @RequestBody Map<String, Integer> val, @RequestBody Map<String, String> com){
        int value = val.get("value");
        String comment = com.get("comment");
        Score score = scoreService.addScore(value, comment, judgeId, subId);
        return ResponseEntity.ok(score);
    }
}
