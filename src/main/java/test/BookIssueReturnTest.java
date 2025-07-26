package test;

import io.adik5050.library.operations.file.IssueBook;
import io.adik5050.library.operations.file.BookShelf;
import io.adik5050.library.operations.file.ReturnBook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;


public class BookIssueReturnTest {
    IssueBook issueTestObject = new IssueBook();
    ReturnBook returnTestObject = new ReturnBook();
    @Test
    public void if_BookIssued_Then_TestPass() {

        try{
            Assertions.assertEquals("Issued Book:- The Da Vinci Code by Dan Brown", issueTestObject.issuingBook("The Da Vinci Code by Dan Brown"));

        }catch (IOException e) {
            System.out.println(e);
        }
        Assertions.assertFalse(BookShelf.books.contains("The Da Vinci Code by Dan Brown"));

    }

    @Test
    public void if_BookReturned_Then_TestPass() {

        try {
            Assertions.assertEquals("Returned Book:- The Da Vinci Code by Dan Brown", returnTestObject.returningBook("The Da Vinci Code by Dan Brown"));
        }catch (IOException e) {
            System.out.println(e);
        }
        Assertions.assertTrue(BookShelf.books.contains("The Da Vinci Code by Dan Brown"));
    }
}
