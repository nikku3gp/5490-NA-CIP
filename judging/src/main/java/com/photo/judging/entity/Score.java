package com.photo.judging.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int value;
    private String comment;
    @OneToMany
    @JoinColumn(name="subId")
    private Submission submission;
    @OneToMany
    @JoinColumn(name="judgeId")
    private Judge judge;
    public Score() {
    }

    public Score(int value, String comment, Submission submission, Judge judge) {
        this.value = value;
        this.comment = comment;
        this.submission = submission;
        this.judge = judge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }
}
