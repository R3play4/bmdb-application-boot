package com.example.bmdb.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue
    //private int id;
    @Id
    private String name;
    private LocalDate born;
    private String biography;

    // CascadeType.PERSIST ?
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Media> filmography;
    private Sex sex;

    public Actor() {
        this.filmography = new ArrayList<>();
    }

    public Actor(String name, LocalDate born, String biography, List<Media> filmography, Sex sex) {
        this.name = name;
        this.born = born;
        this.biography = biography;
        this.filmography = filmography;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }


    public List<Media> getFilmography() {
        return filmography;
    }

    public void addFilm(Media media) {
        this.filmography.add(media);
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
