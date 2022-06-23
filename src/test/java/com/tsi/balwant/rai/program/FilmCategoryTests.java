package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmCategoryTests {
    private int Expected;
    private int Actual;

    private FilmCategory testFilmCategory = new FilmCategory(1, 1);

    @Test
    void testGetCategory_id(){
        Expected = 1;
        Actual = testFilmCategory.getCategoryId();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Category ID");
    }

    @Test
    void testSetCategory_id(){
        Expected = 7;
        testFilmCategory.setCategoryId(Expected);
        Actual = testFilmCategory.getCategoryId();
        Assertions.assertEquals(Expected, Actual , "Category ID set incorrectly");
    }

    @Test
    void testGetFilm_id(){
        Expected = 1;
        Actual = testFilmCategory.getFilmId();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
    void testSetFilm_id(){
        Expected = 7;
        testFilmCategory.setFilmId(Expected);
        Actual = testFilmCategory.getFilmId();
        Assertions.assertEquals(Expected, Actual , "Film ID set incorrectly");
    }


}
