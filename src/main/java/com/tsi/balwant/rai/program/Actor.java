package com.tsi.balwant.rai.program;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="actor")

public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int actor_id;

    //Attributes
    private String first_name;
    private String last_name;


    //@ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    //@JsonIgnore
    //private Set<Film> film = newHashSet<>();

    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;

    }

    //Empty Constructor
    public Actor(){
    }

    //Getters and Setters

    //needed to Many-to-Many mapping
    //public Set<Film> getFilm() {return film; }
    //public void setFilm(Set<Film> films) {this.film = films;}


    public int getActorById() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
