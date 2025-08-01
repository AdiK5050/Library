package io.adik5050.library.operations.user;

import io.adik5050.library.input.user.BookNameInputFromUser;
import io.adik5050.library.input.user.UserIdInputFromUser;
import io.adik5050.library.operations.file.BookShelf;
import io.adik5050.library.operations.file.UpdateLibrary;

import java.io.IOException;
import java.util.Scanner;

public class EditBookShelf {

    Scanner sc;
    BookShelf bookShelfObj;
    UserChoice userChoiceObj;
    UpdateLibrary updateLibraryObj;
    UserVerification userVerificationObj;
    UserIdInputFromUser userIdInputFromUserObj;
    BookNameInputFromUser bookNameInputFromUserObj;


    public EditBookShelf(Scanner sc) throws IOException {
        this.sc = sc;
        this.bookShelfObj = new BookShelf();
        this.userChoiceObj = new UserChoice(this.sc);
        this.updateLibraryObj = new UpdateLibrary();
        this.userVerificationObj = new UserVerification(this.sc);
        this.userIdInputFromUserObj = new UserIdInputFromUser(this.sc);
        this.bookNameInputFromUserObj = new BookNameInputFromUser(this.sc);
    }

    public void editingShelf() {
        userVerificationObj.setAdminID(userIdInputFromUserObj.adminIdInput());
        if (!userVerificationObj.verifyAdminId(userVerificationObj.getAdminID())) {
            System.out.println(userVerificationObj.getAdminName());
            return;
        }
        System.out.println(userVerificationObj.getAdminName());
        int ch = 0, choiceErrorCount = 0;

        do {
            try {
                ch = userChoiceObj.getAdminChoice();
                switch (ch) {
                    case 1:
                        System.out.println(bookShelfObj.getBooks());
                        break;

                    case 2:
                        bookShelfObj.addBook(bookNameInputFromUserObj.input());
                        break;

                    case 3:
                        bookShelfObj.remove(bookNameInputFromUserObj.input());
                        break;

                    case 4:
                        updateLibraryObj.updatingLibrary(bookShelfObj.getBooks());
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid choice! From 0 to 4");
                choiceErrorCount++;
                if(sc.hasNextLine()) sc.nextLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } while (ch != 0 || choiceErrorCount < 3);
    }
}
