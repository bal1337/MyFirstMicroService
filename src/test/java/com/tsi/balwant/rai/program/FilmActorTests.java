package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmActorTests {
    private int Expected;
    private int Actual;

    private FilmActor testFilmActor = new FilmActor(1, 1);

    @Test
    void testGetActor_id() {
        Expected = 1;
        Actual = testFilmActor.getActorId();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Category ID");
    }

    @Test
    void testSetActor_id() {
        Expected = 7;
        testFilmActor.setActorId(Expected);
        Actual = testFilmActor.getActorId();
        Assertions.assertEquals(Expected, Actual, "Category ID set incorrectly");
    }

    @Test
    void testGetFilm_id() {
        Expected = 1;
        Actual = testFilmActor.getFilmId();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
    void testSetFilm_id() {
        Expected = 7;
        testFilmActor.setFilmId(Expected);
        Actual = testFilmActor.getFilmId();
        Assertions.assertEquals(Expected, Actual, "Film ID set incorrectly");
    }


}

