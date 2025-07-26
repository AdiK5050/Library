package io.adik5050.library.input.file;

import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class BookInputFromFiles {

    private Path bookFilePath = Path.of("src\\main\\resources\\ProjectFiles\\Books.txt");
    private static List<String> allBookNames;

    public BookInputFromFiles() {
        try {
            this.allBookNames = Files.readAllLines(bookFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllBooks() {
        return allBookNames;
    }
}
