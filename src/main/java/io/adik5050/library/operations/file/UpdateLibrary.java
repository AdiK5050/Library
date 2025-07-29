package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class UpdateLibrary {

    static final Path bookFilePath = Path.of(System.getProperty("user.home"), ".myLibrary", "books.txt");
    static final Path bookFolderPath = Path.of(System.getProperty("user.home"), ".myLibrary");

    public static String updatingLibrary() throws IOException {
        if(!Files.exists(bookFilePath)) Files.createDirectories(bookFolderPath);
        if(!Files.exists(bookFilePath)) Files.createFile(bookFilePath);
        Files.write(bookFilePath, BookShelf.books);
        return "Changes Saved!";
    }
}
