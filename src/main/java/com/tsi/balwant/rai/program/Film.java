package com.tsi.balwant.rai.program;

import javax.persistence.*;


@Entity
@Table(name="film")
public class Film {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;
    String title;
    String description;
    String languageId;
    int length;
    String rating;







    //Constructors
    public Film(String title, String description,  String languageId, int length, String rating) {
        this.title = title;
        this.description = description;
        this.languageId = languageId;
        this.length = length;
        this.rating = rating;

    }
    public Film(){}

    //Methods
    public int getFilmId() {
        return filmId;
    }
    public void setFilmId(int filmId) {
        this.filmId = filmId;
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

    public String getLanguageId() {
        return languageId;
    }
    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }


}