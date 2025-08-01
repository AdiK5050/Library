package io.adik5050.library.operations.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import io.adik5050.library.util.TimeFormats;

public class IssueBook {

    BookShelf bookShelfObj;
    TimeFormats timeFormats;
    UpdateLibrary updateLibraryObj;
    Path issuedBooksFile;
    Path historyFile;

    public IssueBook() throws IOException{
        this.bookShelfObj = new BookShelf();
        this.timeFormats  = new TimeFormats();
        this.updateLibraryObj = new UpdateLibrary();
        this.issuedBooksFile = Path.of(System.getProperty("user.home"), ".myLibrary", "issuedBooks.txt");
        this.historyFile = Path.of(System.getProperty("user.home"), ".myLibrary", "history.txt");
        if(!Files.exists(issuedBooksFile.getParent())) Files.createDirectories(issuedBooksFile.getParent());
        if(!Files.exists(issuedBooksFile)) Files.createFile(issuedBooksFile);
        if(!Files.exists(historyFile.getParent())) Files.createDirectories(historyFile.getParent());
        if(!Files.exists(historyFile)) Files.createFile(historyFile);
    }

    public String issuingBook (String book, String userName) throws IOException {

        if(bookShelfObj.contains(book)) {
            if(!Files.readAllLines(issuedBooksFile).toString().contains(timeFormats.getDate()))
                    Files.writeString(issuedBooksFile, timeFormats.getDate() + "\n", StandardOpenOption.APPEND);

            StringBuilder issueInfo = new StringBuilder(book + "\t" + timeFormats.getTime());
            Files.writeString(issuedBooksFile, issueInfo.append("\n"),StandardOpenOption.APPEND);
            Files.writeString(historyFile, userName + " issued " + book + " " + timeFormats.getTime() + " " + timeFormats.getDate());
            bookShelfObj.remove(book);
            System.out.println(updateLibraryObj.updatingLibrary(bookShelfObj.getBooks()));

            return "Issued Book:- " + book;
        }
        return "Book Not Found! Error Issuing";
    }
}
