package com.tsi.balwant.rai.program;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LanguageTest {
    private int Expected;
    private int Actual;

    private String ExpectedS;
    private String ActualS;

    private Language testLanguage = new Language(10, "English");

    @Test
    public void testGetLanguage_id(){
        Expected = 10;
        Actual = testLanguage.getLanguage_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Language ID");
    }

    @Test
    public void testSetLanguage_id(){
        Expected = 5;
        testLanguage.setLanguage_id(Expected);
        Actual = testLanguage.getLanguage_id();
        Assertions.assertEquals(Expected, Actual , "Language ID set incorrectly");
    }

    @Test
    public void testGetName(){
        ExpectedS = "English";
        ActualS = testLanguage.getName();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Name");
    }

    @Test
    public void testSetName(){
        ExpectedS = "French";
        testLanguage.setName(ExpectedS);
        ActualS = testLanguage.getName();
        Assertions.assertEquals(ExpectedS, ActualS , "Name set incorrectly");
    }
}
