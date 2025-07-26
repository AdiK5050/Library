package io.adik5050.library.operations.file;

import io.adik5050.library.input.file.BookInputFromFiles;
import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private static final BookInputFromFiles bookInputFromFiles = new BookInputFromFiles();
    public static List<String> books = new ArrayList<>(bookInputFromFiles.getAllBooks());
}
