package com.photo.judging.service;
import com.photo.judging.entity.Submission;
import com.photo.judging.repository.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
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
}
