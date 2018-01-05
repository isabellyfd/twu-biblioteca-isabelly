package com.twu.biblioteca.entity;

import com.twu.biblioteca.entity.QuitOption;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;



public class QuitOptionTest {

    private QuitOption quitOption;

    @Before
    public void setup() {
        this.quitOption = new QuitOption();
    }

    @Test
    public void testIfChosenOptionIsQuitOption() {
        String userInput = "quit";
        Assert.assertTrue(this.quitOption.check(userInput));
    }

    @Test
    public void testIfChosenOptionIsNotQuitOption(){
        String userInput = "qut";
        Assert.assertFalse(this.quitOption.check(userInput));
    }

    @Test
    public void testGettingMessageFromCommand() {
        Assert.assertEquals("[quit] quits the program", this.quitOption.getMessage());
    }
}