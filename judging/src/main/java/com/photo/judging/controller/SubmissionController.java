package com.photo.judging.controller;
import com.photo.judging.entity.Submission;
import com.photo.judging.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @GetMapping
    public List<Submission> getAllSubmissions(){
        return submissionService.getAllSubmissions();
    }

    @GetMapping("/{id}")
    public Optional<Submission> getSubmission(@PathVariable Long id){
        return submissionService.getSubmission(id);
    }

    @PostMapping
    public Submission createSubmission(@RequestBody Submission submission){
        return submissionService.saveSubmission(submission);
    }

    @PutMapping("/{id}")
    public Submission updateSubmission(@PathVariable Long id, @RequestBody Submission submission){
        submission.setId(id);
        return submissionService.saveSubmission(submission);
    }

    @DeleteMapping("/{id}")
    public void deleteSubmission(@PathVariable Long id){
        submissionService.deleteSubmission(id);
    }

}
