package com.example.bmdb.domain.builders;

import com.example.bmdb.domain.*;

public class ReviewBuilder {
    private int id;
    private String text;
    private Media media;
    private User creator;
    private Rating rating;

    public ReviewBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ReviewBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ReviewBuilder setMedia(Media media) {
        this.media = media;
        return this;
    }

    public ReviewBuilder setCreator(User creator) {
        this.creator = creator;
        return this;
    }

    public ReviewBuilder setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public Review buildReview() {
        return new Review(id, text, media, creator, rating);
    }
}
