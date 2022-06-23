package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmTests {

    @Test
    void testGetFilmId(){

        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(1, testFilm.getFilmId(), "Failed to retrieve film ID");
    }
    @Test
    void testSetFilmId(){

        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(1, testFilm.getFilmId(), "No film ID set for this film");
    }
    @Test
    void testGetFilmTitle(){

        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("DeadPool", testFilm.getTitle(), "No title could be retrieved for this film");
    }
    @Test
    void testSetFilmTitle(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        testFilm.setTitle("DeadPool");
        Assertions.assertEquals("DeadPool", testFilm.getTitle(), "No title set for this film");
    }
    @Test
    void testGetFilmDescription(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("Film by Marvel", testFilm.getDescription(), "Failed to retrieve film description");
    }
    @Test
    void testSetFilmDescription(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        testFilm.setDescription("Film by MarvelReplaced");
        Assertions.assertEquals("Film by MarvelReplaced", testFilm.getDescription(), "No description set for this film");
    }


    @Test
    void testGetFilmLanguageId(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals("1", testFilm.getLanguageId(), "Language ID could not be retrieved for this film");
    }
    @Test
    void testSetFilmLanguageId(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        testFilm.setLanguageId("1");
        Assertions.assertEquals("1", testFilm.getLanguageId(), "Language ID has not been set for this film");
    }
    @Test
    void testGetFilmLength(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        Assertions.assertEquals(120, testFilm.getLength(), "Could not retrieve length of film");
    }
    @Test
    void testSetFilmLength(){
        Film testFilm = new Film("DeadPool", "Film by Marvel", "1",  120, "18");
        testFilm.setFilmId(1);
        testFilm.setLength(120);
        Assertions.assertEquals(120, testFilm.getLength(), "The length of this film was not set");
    }
}

