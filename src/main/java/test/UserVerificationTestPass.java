package test;

import io.adik5050.library.operations.user.UserVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;


public class UserVerificationTestPass {


    @Test
    public void verificationTestPass() throws IOException {
        Scanner sc = new Scanner("USER1KJHGFDS9876");
        UserVerification testObject = new UserVerification(sc);
        try {
            Assertions.assertEquals("Welcome!", testObject.giveAccessIfVerified());
            System.out.println(testObject.giveAccessIfVerified());
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

class UserVerificationTestFail {


    @Test
    public void verificationTestFail() throws IOException {
        Scanner sc = new Scanner("failCondition");
        UserVerification testObject = new UserVerification(sc);

        try {
            Assertions.assertEquals("User Not Found!", testObject.giveAccessIfVerified());
            System.out.println(testObject.giveAccessIfVerified());
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

