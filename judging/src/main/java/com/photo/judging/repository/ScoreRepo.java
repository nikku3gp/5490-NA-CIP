package com.photo.judging.repository;
import com.photo.judging.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScoreRepo extends JpaRepository<Score, Long> {
}
