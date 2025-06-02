package com.photo.judging.service;
import com.photo.judging.entity.Judge;
import com.photo.judging.entity.Submission;
import com.photo.judging.repository.JudgeRepo;
import com.photo.judging.repository.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JudgeService {
    @Autowired
    private JudgeRepo judgeRepo;
    @Autowired
    private SubmissionRepo submissionRepo;

    public List<Judge> getAllJudges(){
        return judgeRepo.findAll();
    }

    public Optional<Judge> getJudge(Long id){
        return judgeRepo.findById(id);
    }

    public Judge saveJudge(Judge judge){
        return judgeRepo.save(judge);
    }

    public void deleteJudge(Long id){
        judgeRepo.deleteById(id);
    }

   /* public List<Score> getJudgeScore(Long judgeId){
        Optional<Judge> optionalJudge = judgeRepo.findById(judgeId);

        if (optionalJudge.isPresent()){
            Judge judge = optionalJudge.get();
            List<Score> scoreSet = judge.getSubmissions();
            return new ArrayList<>(scoreSet);
        }else{
            return new ArrayList<>();
        }
    }
*/
}
