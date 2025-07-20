package io.adik5050.library;

import io.adik5050.library.operations.user.UserVerification;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            UserVerification testObject = new UserVerification(sc);
            testObject.giveAccessIfVerified();

        }
    }
}
