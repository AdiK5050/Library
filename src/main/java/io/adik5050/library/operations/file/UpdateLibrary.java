package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class UpdateLibrary {

    static Path bookFilePath = Path.of("src\\main\\resources\\ProjectFiles\\Books.txt");

    public static String updatingLibrary() throws IOException {
        if(!Files.exists(bookFilePath)) Files.createFile(bookFilePath);
        Files.write(bookFilePath, BookShelf.books);
        return "Changes Saved!";
    }
}
