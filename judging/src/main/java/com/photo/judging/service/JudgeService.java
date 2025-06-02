package com.photo.judging.service;
import com.photo.judging.entity.Judge;
import com.photo.judging.repository.JudgeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public class JudgeService {
    @Autowired
    private JudgeRepo judgeRepo;

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
}
