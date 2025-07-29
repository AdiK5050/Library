package test;


import io.adik5050.library.operations.file.IssueBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;


public class BookIssueTest {


    @Test
    public void if_BookIssued_Then_TestPass() {
        try {
        IssueBook issueTestObject = new IssueBook();

            Assertions.assertEquals("Issued Book:- The Da Vinci Code by Dan Brown", issueTestObject.issuingBook("The Da Vinci Code by Dan Brown"));
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
