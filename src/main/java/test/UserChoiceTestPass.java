package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import io.adik5050.library.operations.user.UserChoice;

import java.util.Scanner;

public class UserChoiceTestPass {

    UserChoice testObject = new UserChoice(new Scanner("2"));

    @Test
    public void verifyChoiceTestPass() {
        try {
            Assertions.assertEquals(2, testObject.getUserChoice());
        }
        catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

}

