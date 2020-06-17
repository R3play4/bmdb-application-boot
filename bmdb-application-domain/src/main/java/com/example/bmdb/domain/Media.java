package com.example.bmdb.domain;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Media {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue
    private BigDecimal id;
    private String title;

    private String description;
    private LocalDate premier;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "media", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> cast;

    public Media() {
        this.cast = new ArrayList<>();
    }

    public Media(BigDecimal id, String title, String description, LocalDate premier, List<Review> reviews, List<Actor> cast) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.premier = premier;
        this.reviews = reviews;
        this.cast = cast;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPremier() {
        return premier;
    }

    public void setPremier(LocalDate premier) {
        this.premier = premier;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void addActor(Actor actor) {
        this.cast.add(actor);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
