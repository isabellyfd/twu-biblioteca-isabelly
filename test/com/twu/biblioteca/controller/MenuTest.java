package com.twu.biblioteca.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.menu.QuitOption;
import com.twu.biblioteca.menu.ListOption;
import com.twu.biblioteca.menu.Menu;

public class MenuTest {

    private Menu menu;

    @Before
    public void setup() {
        menu = new Menu(new ListOption(), new QuitOption());
    }

    @Test
    public void testCreationOfMenu() {
        Assert.assertEquals(2, menu.getOptions().length);
        Assert.assertTrue(menu.getOptions()[0] instanceof ListOption);
        Assert.assertTrue(menu.getOptions()[1] instanceof QuitOption);
    }

    @Test
    public void testIfCommandIsAvailableInMenu() {
        String command = "quit";
        Assert.assertTrue(menu.isCommandAvailable(command));

        command = "list";
        Assert.assertTrue(menu.isCommandAvailable(command));
    }
}
