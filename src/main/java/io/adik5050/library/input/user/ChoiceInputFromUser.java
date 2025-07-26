package io.adik5050.library.input.user;

import java.util.Scanner;

public class ChoiceInputFromUser implements Input {
    private String choice;
    Scanner sc;
    private final String PROMPT_TO_USER = "Press 1 to Show Available Books" +
            "\nPress 2 to Issue a Book" +
            "\nPress 3 to Return a Book" +
            "\nPress 4 to see your History" +
            "\nPress 0 to Exit";

    public ChoiceInputFromUser(Scanner sc) {this.sc = sc;}

    public String input() {
        System.out.println(PROMPT_TO_USER);
        choice = sc.next();
        return choice;
    }
}
