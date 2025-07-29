package test;

import io.adik5050.library.operations.file.BookShelf;
import io.adik5050.library.operations.file.ReturnBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BookReturnTest {

    @Test
    public void if_BookReturned_Then_TestPass() throws Exception{
        ReturnBook returnTestObject = new ReturnBook();

            Assertions.assertEquals("Returned Book:- The Da Vinci Code by Dan Brown", returnTestObject.returningBook("The Da Vinci Code by Dan Brown"));

        Assertions.assertTrue(BookShelf.books.contains("The Da Vinci Code by Dan Brown"));
    }
}
