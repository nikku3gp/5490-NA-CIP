package com.photo.judging.service;
import com.photo.judging.entity.Submission;
import com.photo.judging.repository.JudgeRepo;
import com.photo.judging.repository.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    @Autowired
    private JudgeRepo judgeRepo;
    @Autowired
    private SubmissionRepo submissionRepo;

    public List<Submission> getAllSubmissions(){
        return submissionRepo.findAll();
    }

    public Optional<Submission> getSubmission(Long id){
        return submissionRepo.findById(id);
    }

    public Submission saveSubmission(Submission submission){
        return submissionRepo.save(submission);
    }

    public void deleteSubmission(Long id){
        submissionRepo.deleteById(id);
    }

   /* public List<Score> getSubmissionScore(Long subId){
        Optional<Submission> optionalSubmission = submissionRepo.findById(subId);

        if (optionalSubmission.isPresent()){
            Submission submission = optionalSubmission.get();
            List<Score> scoreSet = submission.getScores();
            return new ArrayList<>(scoreSet);
        }else{
            return new ArrayList<>();
        }
    }*/
}
