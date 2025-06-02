package com.photo.judging.config;
import com.photo.judging.entity.Judge;
import com.photo.judging.entity.Submission;
import com.photo.judging.repository.JudgeRepo;
import com.photo.judging.repository.SubmissionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitialization {
    @Bean
    CommandLineRunner initData(SubmissionRepo submissionRepo, JudgeRepo judgeRepo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Submission> savedSubmissions = submissionRepo.saveAll(
                        List.of(
                                new Submission("First", "Landscape", "pinterest", "Mike","https://pinterest.com"),
                                new Submission("Second", "Portrait", "pinterest", "Jason","https://pinterest.com"),
                                new Submission("Third", "Landscape", "pinterest", "Porter","https://pinterest.com"),
                                new Submission("Fourth", "Portrait", "tumblr", "Mike","https://tumblr.com"),
                                new Submission("Fifth", "Portrait", "Instagram", "Mike","https://instagram.com")
                        )
                );
                List<Judge> savedJudges = judgeRepo.saveAll(
                        List.of(
                                new Judge("Mike", "Wazowski", "photographer"),
                                new Judge("Layla", "ABC", "photographer"),
                                new Judge("Lena", "OPS", "Chef")
                        )
                );
                //submissionRepo.saveAll(savedSubmissions);
                //judgeRepo.saveAll(savedJudges);

            }
        };
    }
}
