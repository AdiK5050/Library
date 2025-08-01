package test;

import io.adik5050.library.operations.user.UserVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

class UserVerificationTestFail {


    @Test
    public void verificationTestFail() throws IOException {
        Scanner sc = new Scanner("failCondition");
        UserVerification testObject = new UserVerification(sc);

        try {
            Assertions.assertEquals("User Not Found!", testObject.getUserName());
            System.out.println(testObject.getUserName());
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
