package test;


import io.adik5050.library.operations.file.ReturnBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BookReturnTest {

    @Test
    public void if_BookReturned_Then_TestPass() throws Exception{
        ReturnBook returnTestObject = new ReturnBook();

            Assertions.assertEquals("Returned Book:- The Da Vinci Code by Dan Brown", returnTestObject.returningBook("The Da Vinci Code by Dan Brown" , "A user"));

    }
}
