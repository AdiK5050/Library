package io.adik5050.library.input.user;

import java.util.Scanner;

public class UserIdInputFromUser implements Input {
    Scanner sc;
    public UserIdInputFromUser(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public String input() {
        System.out.println("Enter your User ID for verification:- ");
        return sc.next();
    }
}
