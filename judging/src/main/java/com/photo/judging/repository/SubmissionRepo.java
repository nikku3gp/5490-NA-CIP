package com.photo.judging.repository;
import com.photo.judging.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission,Long> {
}
