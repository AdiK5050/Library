package test;

import io.adik5050.library.input.file.BookInputFromFiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookInputFromFiles_TestFail {

    @Test
    public void inputBookTestPass() {
        BookInputFromFiles testObject = new BookInputFromFiles();
        for (int i = 0; i < 1; i++) {
            System.out.println(testObject.getAllBooks().getFirst());
            Assertions.assertEquals("No such Book", testObject.getAllBooks().getFirst());
        }
    }
}
