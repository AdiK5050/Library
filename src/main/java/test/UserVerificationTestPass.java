package test;

import io.adik5050.library.operations.user.UserVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;


public class UserVerificationTestPass {


    @Test
    public void verificationTestPass() {

        try {
            Scanner sc = new Scanner("USER1KJHGFDS9876");
            UserVerification testObject = new UserVerification(sc);
            Assertions.assertEquals("Welcome! user_1" , testObject.getUserName().trim());
            System.out.println(testObject.getUserName());
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}



