package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTests {
    @Test
    void testGetCategoryName(){
        Category testLanguage = new Category(7,"RomCom");
        testLanguage.setCategoryId(7);
        Assertions.assertEquals("RomCom", testLanguage.getName(), "Could not find category name");
    }
    @Test
    void testSetCategoryName(){
        Category testLanguage = new Category();
        testLanguage.setName("RomCom");
        testLanguage.setCategoryId(7);
        Assertions.assertEquals("RomCom", testLanguage.getName(), "Failed to set the category name");
    }
    @Test
    void testGetCategoryId(){
        Category testLanguage = new Category(7,"RomCom");
        testLanguage.setCategoryId(7);
        Assertions.assertEquals(7, testLanguage.getCategoryId(), "Could not retrieve category ID");
    }
    @Test
    void testSetCategoryId(){
        Category testLanguage = new Category(7,"RomCom");
        testLanguage.setCategoryId(7);
        Assertions.assertEquals(7, testLanguage.getCategoryId(), "Category ID was not set correctly");
    }

}