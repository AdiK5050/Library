package io.adik5050.library.input.user;


import java.util.Scanner;

public class UserNameInputFromUser implements Input{

    Scanner sc;

    public UserNameInputFromUser(Scanner sc) {
        this.sc = sc;
    }
    @Override
    public String input() {
        StringBuilder userName = new StringBuilder();
        System.out.println("Enter your First Name:- ");
        userName.append(sc.next());
        System.out.println("Enter your Last Name:- ");
        userName.append(" ").append(sc.next());
        return userName.toString();
    }
}
