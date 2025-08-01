package io.adik5050.library.operations.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;

public class History {

    Path historyFile;
    List<String> history = new ArrayList<>();

    public History() {
        this.historyFile = Path.of(System.getProperty("user.home"), ".myLibrary", "history.txt");
    }

        public void getHistory() throws IOException {
            history.addAll(Files.readAllLines(historyFile));
            System.out.println(history);
    }
}
