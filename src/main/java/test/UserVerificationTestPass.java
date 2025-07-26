package test;

import io.adik5050.library.operations.user.UserVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;


public class UserVerificationTestPass {

    Scanner sc = new Scanner("USER1ALSDKFJEO3432");
    UserVerification testObject = new UserVerification(sc);
    @Test
    public void verificationTestPass() {

        try {
            Assertions.assertEquals("Welcome!", testObject.giveAccessIfVerified());
            System.out.println(testObject.giveAccessIfVerified());
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

class UserVerificationTestFail {

    Scanner sc = new Scanner("failCondition");
    UserVerification testObject = new UserVerification(sc);
    @Test
    public void verificationTestFail() {

        try {
            Assertions.assertEquals("User Not Found!", testObject.giveAccessIfVerified());
            System.out.println(testObject.giveAccessIfVerified());
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

