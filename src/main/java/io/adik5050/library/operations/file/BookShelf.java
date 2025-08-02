package io.adik5050.library.operations.file;

import io.adik5050.library.input.file.BookInputFromFiles;


import java.util.ArrayList;
import java.util.List;

public class BookShelf {

    private static final BookInputFromFiles bookInputFromFiles = new BookInputFromFiles();
    private final List<String> books = new ArrayList<>(bookInputFromFiles.getAllBooks());

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
    public void printBooks() {
        int count = 0;
        StringBuilder bookPair = new StringBuilder();
        for(String book : books) {
            if(book.trim().isEmpty()) continue;
            else if(count == 0) {
                bookPair.append("[").append(book);
                count++;
            }
            else if(count == 1) {
                System.out.println(bookPair.append(" , ").append(book).append("]\n"));
                bookPair.delete(0, 1000);
                count--;
            }
        }
        if(count == 1) {
            System.out.println(bookPair.append( "]\n"));
            bookPair.delete(0, 1000);
        }
    }
}
