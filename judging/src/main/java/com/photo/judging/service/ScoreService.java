package com.photo.judging.service;
import com.photo.judging.entity.Judge;
import com.photo.judging.entity.Score;
import com.photo.judging.entity.Submission;
import com.photo.judging.repository.JudgeRepo;
import com.photo.judging.repository.ScoreRepo;
import com.photo.judging.repository.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepo scoreRepo;
    @Autowired
    private SubmissionRepo submissionRepo;
    @Autowired
    private JudgeRepo judgeRepo;

    public List<Score> getAllScores(){
        return scoreRepo.findAll();
    }

    public Optional<Score> getScore(Long id){
        return scoreRepo.findById(id);
    }

    public Score saveScore(Score score){
        return scoreRepo.save(score);
    }

    public void deleteScore(Long id){
        scoreRepo.deleteById(id);
    }

    public Score addScore(int value,String comment,Long judgeId, Long subId){
        Submission submission = submissionRepo.findById(subId).orElseThrow();
        Judge judge = judgeRepo.findById(judgeId).orElseThrow();
        Score score = new Score(value, comment, submission, judge);
        return scoreRepo.save(score);
    }
}
