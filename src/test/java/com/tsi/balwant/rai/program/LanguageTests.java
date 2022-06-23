package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LanguageTests{
    @Test
    void testGetLanguageName(){
        Language testLanguage = new Language("Punjabi");
        testLanguage.setLanguageId(7);
        Assertions.assertEquals("Punjabi", testLanguage.getName(), "Could not retrieve the language");
    }
    @Test
    void testSetLanguageName(){
        Language testLanguage = new Language();
        testLanguage.setName("Punjabi");
        testLanguage.setLanguageId(7);
        Assertions.assertEquals("Punjabi", testLanguage.getName(), "Failed to set the language");
    }
    @Test
    void testGetLanguageId(){
        Language testLanguage = new Language("Punjabi");
        testLanguage.setLanguageId(7);
        Assertions.assertEquals(7, testLanguage.getLanguageId(), "Could not retrieve language ID");
    }
    @Test
    void testSetLanguageId(){
        Language testLanguage = new Language("Punjabi");
        testLanguage.setLanguageId(1);
        Assertions.assertEquals(1, testLanguage.getLanguageId(), "Language ID was not set correctly");
    }


}