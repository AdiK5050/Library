package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import io.adik5050.library.util.TimeFormats;

public class IssueBook {

    TimeFormats timeFormats = new TimeFormats();
    Path issuedBooksFile = Path.of(System.getProperty("user.home"), ".myLibrary", "issueBooks.txt");
    Path issuedBooksFolder = Path.of(System.getProperty("user.home"), ".myLibrary");

    public String issuingBook (String book) throws IOException {
        if(!Files.exists(issuedBooksFile)) Files.createDirectories(issuedBooksFolder);
        if(!Files.exists(issuedBooksFile)) Files.createFile(issuedBooksFile);

        if(BookShelf.books.toString().contains(book)) {
            if(!Files.readAllLines(issuedBooksFile).toString().contains(timeFormats.getDate()))
                    Files.writeString(issuedBooksFile, timeFormats.getDate() + "\n", StandardOpenOption.APPEND);

            StringBuilder issueInfo = new StringBuilder(book + "\t" + timeFormats.getTime());
            Files.writeString(issuedBooksFile, issueInfo + "\n",StandardOpenOption.APPEND);
            BookShelf.books.remove(book);
            System.out.println(UpdateLibrary.updatingLibrary());

            return "Issued Book:- " + book;
        }
        return "Book Not Found! Error Issuing";
    }
}
