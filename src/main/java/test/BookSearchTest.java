package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import io.adik5050.library.operations.file.SearchBook;

public class BookSearchTest {

    SearchBook testObject = new SearchBook();

    @Test
    public void searchAllBooks_bookMatchFound_TestPassed () {
        Assertions.assertEquals("Match Found:- The Hobbit by J.R.R. Tolkien", testObject.searchingBook("The Hobbit"));
    }

    @Test
    public void searchAllBooks_bookMatchNotFound_TestPassed() {
        Assertions.assertEquals("Exact Match Not Found!" , testObject.searchingBook("NOSUCHBOOK"));
    }
    @Test
    public void searchAllBooks_SimilarMatchFound_TestPassed() {
        Assertions.assertEquals("Exact Match Not Found!", testObject.searchingBook("The Hobbit Rabbit"));
    }

    @Test
    public void searchAllBooks_NullParameter_TestPassed() {
        Assertions.assertEquals("Empty Book Name!", testObject.searchingBook(" "));
    }
}
