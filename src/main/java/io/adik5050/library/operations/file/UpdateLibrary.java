package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;

public class UpdateLibrary {

    BookShelf bookShelfObj;
    private final Path bookFilePath;

    public UpdateLibrary() {
        this.bookShelfObj = new BookShelf();
        this.bookFilePath = Path.of(System.getProperty("user.home"), ".myLibrary", "books.txt");
    }

    public String updatingLibrary(List<String> updatedBooks) throws IOException {
        if(!Files.exists(bookFilePath.getParent())) Files.createDirectories(bookFilePath.getParent());
        if(!Files.exists(bookFilePath)) Files.createFile(bookFilePath);
        Files.write(bookFilePath, updatedBooks);
        return "Changes Saved!";
    }
}
