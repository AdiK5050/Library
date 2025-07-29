package io.adik5050.library.operations.user;


import java.io.IOException;
import java.util.Scanner;

public class InteractWithBooks {

    Scanner sc;
    UserChoice userChoice;
    UserVerification userVerification;


    public InteractWithBooks(Scanner sc) throws IOException {
        this.sc = sc;
        this.userChoice = new UserChoice(sc);
        this.userVerification = new UserVerification(sc);
    }

}
