package io.adik5050.library.input.user;

import java.util.Scanner;

public class BookNameInputFromUser implements Input{
    private String bookName;
    Scanner sc;

    public BookNameInputFromUser(Scanner sc) {this.sc = sc;}

    @Override
    public String input() {
        System.out.println("Enter name of the Book:- ");
        bookName = sc.nextLine();
        return bookName;
    }
}
