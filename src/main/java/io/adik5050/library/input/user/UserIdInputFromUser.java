package io.adik5050.library.input.user;

import java.util.Scanner;

public class UserIdInputFromUser implements Input {
    public String userId;
    Scanner sc;
    public UserIdInputFromUser(Scanner sc) {this.sc = sc;}

    @Override
    public String input() {
        System.out.println("Enter your User ID for verification:- ");
        userId = sc.nextLine();
        return userId;
    }
}
