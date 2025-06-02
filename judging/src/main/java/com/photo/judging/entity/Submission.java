package com.photo.judging.entity;
import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    //@ManyToOne
   // private List<Score> scores = new ArrayList<>();

    /*@ManyToOne
    @JoinTable(
            name = "subs",
            joinColumns = @JoinColumn(name="subId"),
            inverseJoinColumns = @JoinColumn(name = "judgeId")
    )
    @JsonIgnore
    private List<Judge> judges = new ArrayList<>();*/
    public Submission() {
    }

    public Submission (String title, String category, String UploadedAt, String PhotographerName, String imgUrl) {
        this.title = title;
        this.Category = category;
        this.UploadedAt = UploadedAt;
        this.PhotographerName = PhotographerName;
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
