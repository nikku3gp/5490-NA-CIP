package com.photo.judging.entity;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String Category;
    private String UploadedAt;
    private String PhotographerName;
    private String imgUrl;

    public Submission() {
    }

    public Submission(Long id, String title, String category, String uploadedAt, String photographerName, String imgUrl) {
        this.id = id;
        this.title = title;
        Category = category;
        UploadedAt = uploadedAt;
        PhotographerName = photographerName;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getUploadedAt() {
        return UploadedAt;
    }

    public void setUploadedAt(String uploadedAt) {
        UploadedAt = uploadedAt;
    }

    public String getPhotographerName() {
        return PhotographerName;
    }

    public void setPhotographerName(String photographerName) {
        PhotographerName = photographerName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
