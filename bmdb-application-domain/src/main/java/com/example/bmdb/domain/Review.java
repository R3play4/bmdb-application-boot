package com.example.bmdb.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Review {
    /*
    @Id
    @GeneratedValue
    private int id;
    */

    @Id
    private String text;

    @ManyToOne (cascade = CascadeType.ALL)
    private Media media;

    @ManyToOne(cascade = CascadeType.ALL)
    private User creator;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    public Review() {
    }

    public Review(int id, String text, Media media, User creator, Rating rating) {
        //this.id = id;
        this.text = text;
        this.media = media;
        this.creator = creator;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
