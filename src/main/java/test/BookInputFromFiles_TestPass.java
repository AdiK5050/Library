package test;

import io.adik5050.library.input.file.BookInputFromFiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BookInputFromFiles_TestPass {

    BookInputFromFiles testObject = new BookInputFromFiles();

    @Test
    public void inputBookTestPass() {
        for(int i = 0; i < 1; i++) {
            System.out.println(testObject.getAllBooks().get(13));
            Assertions.assertTrue(testObject.getAllBooks().contains("\"Angels and Demons\" by Dan Brown"));
        }
    }
}

class BookInputFromFiles_TestFail {

    BookInputFromFiles testObject = new BookInputFromFiles();

    @Test
    public void inputBookTestPass() {
        for(int i = 0; i < 1; i++) {
            System.out.println(testObject.getAllBooks().getFirst());
            Assertions.assertEquals("No such Book",testObject.getAllBooks().getFirst());
        }
    }
}
