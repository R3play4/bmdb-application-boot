package com.example.bmdb.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    private static int latestId = 0;

    @Id
    private int id;

    private String name;

    //@Id
    private String email;
    private String passWord;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "creator")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator", fetch = FetchType.EAGER)
    private List<Review> reviews;

    public User() {
    }

    public User(String name, String email, String passWord, List<Review> reviews) {
        latestId++;
        this.id = latestId;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
