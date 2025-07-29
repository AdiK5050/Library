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
            Path bookFolderPath = Path.of(System.getProperty("user.home"), ".myLibrary");
            if(!Files.exists(bookFilePath)) Files.createDirectories(bookFolderPath);
            if(!Files.exists(bookFilePath)){
                Files.createFile(bookFilePath);
                throw new FileNotFoundException("Empty Library! First insert some books.");
            }
            allBookNames = Files.readAllLines(bookFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllBooks() {
        return allBookNames;
    }
}
