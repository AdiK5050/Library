package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import io.adik5050.library.util.TimeFormats;

public class ReturnBook extends BookShelf{

    TimeFormats timeFormats = new TimeFormats();
    Path returnedBooksFile = Path.of(System.getProperty("user.home"), ".myLibrary", "returnedBooks.txt");
    Path issuedBooksFile = Path.of(System.getProperty("user.home"), ".myLibrary", "issueBooks.txt");
    Path returnedBooksFolder = Path.of(System.getProperty("user.home"), ".myLibrary");

    public String returningBook(String book) throws IOException{
        if(!Files.exists(issuedBooksFile)) Files.createDirectories(returnedBooksFolder);
        if(!Files.exists(returnedBooksFile)) Files.createFile(returnedBooksFile);
        if(!Files.exists(issuedBooksFile)) return "Issued Book history not found!";

        if(Files.readAllLines(issuedBooksFile).toString().contains(book) && !BookShelf.books.toString().contains(book)) {
            if(!Files.readAllLines(returnedBooksFile).toString().contains(timeFormats.getDate()))
                Files.writeString(returnedBooksFile, timeFormats.getDate() + "\n", StandardOpenOption.APPEND);

            Files.writeString(returnedBooksFile, book + "\t",StandardOpenOption.APPEND);
            Files.writeString(returnedBooksFile, timeFormats.getTime() + "\n",StandardOpenOption.APPEND);
            BookShelf.books.add(book);
            System.out.println(UpdateLibrary.updatingLibrary());

            return "Returned Book:- " + book;
        }
        return "Book Doesn't belong to The Library! Error Returning";
    }
}
