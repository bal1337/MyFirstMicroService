package com.tsi.balwant.rai.program;

import javax.persistence.*;

@Entity
@Table(name="film_category")

public class FilmCategory {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;
    int category_id;
    // Constructor

    public FilmCategory(int film_id, int category_id) {
        this.film_id = film_id;
        this.category_id = category_id;
    }

    public FilmCategory(){}

    // Getters
    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}