package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.util.ConsoleHelper;
import com.twu.biblioteca.menu.ListOption;
import com.twu.biblioteca.menu.QuitOption;

import java.util.ArrayList;

public class BibliotecaApp {

    private LibraryController controller;
    private ListOption listOption;
    private QuitOption quitOption;

    protected BibliotecaApp(ArrayList<Book> books){
        this.controller = new LibraryController(books);
        this.listOption = new ListOption();
        this.quitOption = new QuitOption();
    }

    public static BibliotecaApp getInstance() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Goodnight Moon", "Margaret Wise Brown, Clement Hurd", 2007));
        books.add(new Book("Press Here", "Herve Tullet", 2011));
        return new BibliotecaApp(books);
    }

    public static void main(String[] args) {
        runLibrary();
    }

    private static void runLibrary() {
        BibliotecaApp app = BibliotecaApp.getInstance();

        app.printWelcomeMessage();
        app.printMenu();

        String option = ConsoleHelper.getUserInput();

        while (!app.isQuitCommand(option)){
            if (app.isListCommand(option)) {
                ConsoleHelper.printList(app.getBooksInLibrary());
            }else {
                ConsoleHelper.printMessage("This option is not available! (try to fix the spelling)");
            }
            app.printMenu();
            option = ConsoleHelper.getUserInput();
        }
    }

    public void printWelcomeMessage(){
        ConsoleHelper.printMessage(ConsoleHelper.welcomeMessage());
    }

    protected ArrayList<Book> getBooksInLibrary() {
        return this.controller.listAllAvailableBooks();
    }

    public void printAllBooksAvailable() {
        ConsoleHelper.printList(getBooksInLibrary());
    }

    public void printMenu() {
        ConsoleHelper.printMessage(this.listOption.getMessage());
        ConsoleHelper.printMessage(this.quitOption.getMessage());
    }

    public boolean isQuitCommand(String command) {
        return this.quitOption.check(command);
    }

    public boolean isListCommand(String command){
        return this.listOption.check(command);
    }
}
