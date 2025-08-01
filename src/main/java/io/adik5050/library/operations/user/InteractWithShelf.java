package io.adik5050.library.operations.user;


import java.io.IOException;
import java.util.Scanner;

import io.adik5050.library.input.user.BookNameInputFromUser;
import io.adik5050.library.input.user.UserIdInputFromUser;
import io.adik5050.library.operations.file.History;
import io.adik5050.library.operations.file.IssueBook;
import io.adik5050.library.operations.file.ReturnBook;
import io.adik5050.library.operations.file.BookShelf;
import io.adik5050.library.operations.file.UpdateLibrary;
import io.adik5050.library.operations.file.SearchBook;

public class InteractWithShelf {

    Scanner sc;
    History historyObj;
    IssueBook issueBookObj;
    BookShelf bookShelfObj;
    UserChoice userChoiceObj;
    ReturnBook returnBookObj;
    SearchBook searchBookObj;
    UpdateLibrary updateLibraryObj;
    UserVerification userVerificationObj;
    UserIdInputFromUser userIdInputFromUserObj;
    BookNameInputFromUser bookNameInputFromUserObj;

    public InteractWithShelf(Scanner sc) throws IOException {
        this.sc = sc;
        this.historyObj = new History();
        this.issueBookObj = new IssueBook();
        this.bookShelfObj = new BookShelf();
        this.userChoiceObj = new UserChoice(this.sc);
        this.returnBookObj = new ReturnBook();
        this.searchBookObj = new SearchBook();
        this.updateLibraryObj = new UpdateLibrary();
        this.userVerificationObj = new UserVerification(this.sc);
        this.userIdInputFromUserObj = new UserIdInputFromUser(this.sc);
        this.bookNameInputFromUserObj = new BookNameInputFromUser(this.sc);
    }

    public void interacting() throws IOException{
        if(!userVerificationObj.verifyID(userVerificationObj.getUserID())) {
            System.out.println(userVerificationObj.getUserName());
            return;
        };
        System.out.println(userVerificationObj.getUserName());
        int ch = userChoiceObj.getUserChoice();

        switch (ch) {
            case 1:
                System.out.println(searchBookObj.searchingBook(bookNameInputFromUserObj.input()));
                break;

            case 2:
                System.out.println(issueBookObj.issuingBook(bookNameInputFromUserObj.input(), userVerificationObj.getUserName()));
                break;

            case 3:
                System.out.println(returnBookObj.returningBook(bookNameInputFromUserObj.input(), userVerificationObj.getUserName()));
                break;

            case 4:
                historyObj.getHistory();
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid Choice");
        }
    }
}
