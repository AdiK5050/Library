package io.adik5050.library.input.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class BookInputFromFiles {

    private static List<String> allBookNames;

    public BookInputFromFiles() {
        try {
            Path bookFilePath = Path.of(System.getProperty("user.home"), ".myLibrary", "books.txt");
            if(!Files.exists(bookFilePath.getParent())) Files.createDirectories(bookFilePath.getParent());
            if(!Files.exists(bookFilePath)) Files.createFile(bookFilePath);

            allBookNames = Files.readAllLines(bookFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllBooks() {
        return allBookNames;
    }
}
