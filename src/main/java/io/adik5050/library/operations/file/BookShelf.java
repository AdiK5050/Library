package io.adik5050.library.operations.file;

import io.adik5050.library.input.file.BookInputFromFiles;


import java.util.ArrayList;
import java.util.List;

public class BookShelf {

    private static final BookInputFromFiles bookInputFromFiles = new BookInputFromFiles();
    private List<String> books = new ArrayList<>(bookInputFromFiles.getAllBooks());

    public void addBook(String book) {
        books.add(book);
    }
    public void remove(String book) {
        books.remove(book);
    }
    public boolean contains(String book) {
        return books.contains(book);
    }
    public List<String> getBooks() {
        return books;
    }
}
