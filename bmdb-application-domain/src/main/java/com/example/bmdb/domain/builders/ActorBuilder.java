package com.example.bmdb.domain.builders;

import com.example.bmdb.domain.Actor;
import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActorBuilder {
    //for testing purposes
    private String name;
    private LocalDate born;
    private String biography;
    private List<Media> filmography;
    private Sex sex;

    public ActorBuilder() {
        this.filmography = new ArrayList<>();
    }

    public ActorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ActorBuilder setBorn(LocalDate born) {
        this.born = born;
        return this;
    }

    public ActorBuilder setBiography(String biography) {
        this.biography = biography;
        return this;
    }

    public ActorBuilder addFilm(Media film) {
        this.filmography.add(film);
        return this;
    }

    public ActorBuilder setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public Actor buildActor() {
        return new Actor(name, born, biography, filmography, sex);
    }
}
