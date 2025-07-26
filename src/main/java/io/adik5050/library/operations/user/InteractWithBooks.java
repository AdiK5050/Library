package io.adik5050.library.operations.user;

import io.adik5050.library.operations.user.UserVerification;
import io.adik5050.library.operations.user.UserChoice;
import java.util.Scanner;

public class InteractWithBooks {

    Scanner sc;
    UserChoice userChoice;
    UserVerification userVerification;


    public InteractWithBooks(Scanner sc) {
        this.sc = sc;
        this.userChoice = new UserChoice(sc);
        this.userVerification = new UserVerification(sc);
    }


}
