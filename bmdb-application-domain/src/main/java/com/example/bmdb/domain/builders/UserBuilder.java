package com.example.bmdb.domain.builders;

import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
    private String name;
    private String email;
    private String passWord;
    private List<Review> reviews;

    public UserBuilder() {
        this.reviews = new ArrayList<>();
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public UserBuilder addReview(Review review) {
        this.reviews.add(review);
        return this;
    }

    public User buildUser() {
        return new User(name, email, passWord, reviews);
    }
}
