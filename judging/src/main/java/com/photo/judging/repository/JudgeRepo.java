package com.photo.judging.repository;
import com.photo.judging.entity.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRepo extends JpaRepository<Judge, Long> {
}
