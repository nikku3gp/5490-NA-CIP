package com.photo.judging.controller;
import com.photo.judging.entity.Judge;
import com.photo.judging.entity.Score;
import com.photo.judging.service.ScoreService;
import com.photo.judging.service.SubmissionService;
import com.photo.judging.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scores")
public class ServiceController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private JudgeService judgeService;

    @GetMapping
    public List<Score> getAllScores(){
        return scoreService.getAllScores();
    }
    @PutMapping("/{id}")
    public Score updateScore(@PathVariable Long id, @RequestBody Score score){
        score.setId(id);
        return scoreService.saveScore(score);
    }

}
