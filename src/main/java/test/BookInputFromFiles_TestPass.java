package test;

import io.adik5050.library.input.file.BookInputFromFiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookInputFromFiles_TestPass {

    @Test
    public void inputBookTestPass() {
        BookInputFromFiles testObject = new BookInputFromFiles();
        for(int i = 0; i < 1; i++) {
            System.out.println(testObject.getAllBooks().get(13));
            Assertions.assertTrue(testObject.getAllBooks().contains("\"Angels and Demons\" by Dan Brown"));
        }
    }
}

