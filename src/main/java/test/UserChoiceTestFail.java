package test;

import io.adik5050.library.operations.user.UserChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class UserChoiceTestFail {

    UserChoice testObject = new UserChoice(new Scanner("-1"));

    @Test
    public void verifyChoiceTestPass() {
        try {
            Assertions.assertEquals(-1, testObject.getUserChoice());
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

}
