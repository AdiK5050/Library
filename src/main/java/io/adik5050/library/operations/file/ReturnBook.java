package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import io.adik5050.library.util.TimeFormats;

public class ReturnBook extends BookShelf{

    BookShelf bookShelfObj;
    UpdateLibrary updateLibraryObj;
    TimeFormats timeFormats;
    Path returnedBooksFile;
    Path issuedBooksFile;
    Path historyFile;

    public ReturnBook() throws IOException{
        this.bookShelfObj = new BookShelf();
        this.updateLibraryObj = new UpdateLibrary();
        this.timeFormats = new TimeFormats();
        this.returnedBooksFile = Path.of(System.getProperty("user.home"), ".myLibrary", "returnedBooks.txt");
        this.issuedBooksFile = Path.of(System.getProperty("user.home"), ".myLibrary", "issuedBooks.txt");
        this.historyFile = Path.of(System.getProperty("user.home"), ".myLibrary", "history.txt");
        if(!Files.exists(returnedBooksFile.getParent())) Files.createDirectories(returnedBooksFile.getParent());
        if(!Files.exists(returnedBooksFile)) Files.createFile(returnedBooksFile);
    }


    public String returningBook(String book, String userName) throws IOException{

        if(!Files.exists(issuedBooksFile)) return "Issued Book history not found!";
        if(Files.readAllLines(issuedBooksFile).toString().contains(book) && !bookShelfObj.contains(book)) {
            if(!Files.readAllLines(returnedBooksFile).toString().contains(timeFormats.getDate()))
                Files.writeString(returnedBooksFile, timeFormats.getDate() + "\n", StandardOpenOption.APPEND);

            Files.writeString(returnedBooksFile, book + "\t",StandardOpenOption.APPEND);
            Files.writeString(returnedBooksFile, timeFormats.getTime() + "\n",StandardOpenOption.APPEND);
            Files.writeString(historyFile, "\n" + userName + " issued " + book + " " + timeFormats.getTime() + " " + timeFormats.getDate() , StandardOpenOption.APPEND);
            bookShelfObj.addBook(book);
            System.out.println(updateLibraryObj.updatingLibrary(bookShelfObj.getBooks()));

            return "Returned Book:- " + book;
        }
        return "Book Doesn't belong to The Library! Error Returning";
    }
}
