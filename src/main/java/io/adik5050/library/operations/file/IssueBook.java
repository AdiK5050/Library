package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import io.adik5050.library.util.TimeFormats;

public class IssueBook {

    TimeFormats timeFormats = new TimeFormats();
    Path issuedBooksFile = Path.of("src/main/resources/ProjectFiles/Issued Books");

    public String issuingBook (String book) throws IOException {
        if(!Files.exists(issuedBooksFile)) Files.createFile(issuedBooksFile);

        if(BookShelf.books.toString().contains(book)) {
            if(!Files.readAllLines(issuedBooksFile).toString().contains(timeFormats.getDate()))
                    Files.writeString(issuedBooksFile, timeFormats.getDate() + "\n", StandardOpenOption.APPEND);

            Files.writeString(issuedBooksFile, book + "\t",StandardOpenOption.APPEND);
            Files.writeString(issuedBooksFile, timeFormats.getTime() + "\n",StandardOpenOption.APPEND);
            BookShelf.books.remove(book);
            System.out.println(UpdateLibrary.updatingLibrary());

            return "Issued Book:- " + book;
        }
        return "Book Not Found! Error Issuing";
    }
}
