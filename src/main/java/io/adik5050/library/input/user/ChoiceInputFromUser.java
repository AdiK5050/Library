package io.adik5050.library.input.user;

import java.util.Scanner;

public class ChoiceInputFromUser implements Input {
    private String choice;
    Scanner sc;
    private final String USER_ACCESS = "Press 1 to Search for a Book" +
            "\nPress 2 to Issue a Book" +
            "\nPress 3 to Return a Book" +
            "\nPress 4 to see your History" +
            "\nPress 0 to Exit";

    private final String ADMIN_ACCESS = "Press 1 to Display All Books" +
            "\nPress 2 to Add a Book" +
            "\nPress 3 to remove a Book" +
            "\nPress 4 to refresh the Library" +
            "\nPress 0 to Exit";

    private final String ACCESS_CHOICE = "Press 1 to Login as a User" +
            "\nPress 2 to Login as an Admin" +
            "\nPress 0 to Exit";

    public ChoiceInputFromUser(Scanner sc) {this.sc = sc;}

    public String input() {
        System.out.println(USER_ACCESS);
        choice = sc.next();
        return choice;
    }
    public String inputAdminChoice() {
        System.out.println(ADMIN_ACCESS);
        choice = sc.next();
        return choice;
    }

    public String inputLoginChoice() {
        System.out.println(ACCESS_CHOICE);
        choice = sc.next();
        return choice;
    }
}
