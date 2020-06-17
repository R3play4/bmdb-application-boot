package com.example.bmdb.domain.builders;

import com.example.bmdb.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MediaBuilder {
    private BigDecimal id;
    private String title;
    private String description;
    private LocalDate premier;
    private List<Review> reviews;
    private List<Actor> cast;

    public MediaBuilder() {
        this.reviews = new ArrayList<>();
        this.cast = new ArrayList<>();
    }

    public MediaBuilder setId(BigDecimal id) {
        this.id = id;
        return this;
    }

    public BigDecimal getId() {
        return id;
    }

    public MediaBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MediaBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MediaBuilder setPremier(LocalDate premier) {
        this.premier = premier;
        return this;
    }

    public MediaBuilder addReview(Review review) {
        this.reviews.add(review);
        return this;
    }

    public MediaBuilder addCast(Actor actor) {
        this.cast.add(actor);
        return this;
    }

    public Movie buildMovie() {
        return new Movie(id, title, description, premier, reviews, cast);
    }

    public Series buildSeries() {
        return new Series(id, title, description, premier, reviews, cast);
    }
}
