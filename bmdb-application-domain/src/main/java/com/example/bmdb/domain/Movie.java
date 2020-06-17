
package com.example.bmdb.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie extends Media {
    public Movie() {
    }

    public Movie(BigDecimal id, String title, String description, LocalDate premier, List<Review> reviews, List<Actor> cast) {
        super(id, title, description, premier, reviews, cast);
    }
}
