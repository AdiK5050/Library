package io.adik5050.library.app;

import java.io.IOException;
import java.util.Scanner;
import io.adik5050.library.input.user.ChoiceInputFromUser;
import io.adik5050.library.operations.user.InteractWithShelf;
import io.adik5050.library.operations.user.EditBookShelf;

public class Application {

    Scanner sc;
    EditBookShelf editBookShelfObj;
    InteractWithShelf interactWithShelfObj;
    ChoiceInputFromUser choiceInputFromUserObj;


    public Application(Scanner sc) throws IOException {
        this.sc = sc;
        this.choiceInputFromUserObj = new ChoiceInputFromUser(this.sc);
        this.editBookShelfObj = new EditBookShelf(this.sc);
        this.interactWithShelfObj = new InteractWithShelf(this.sc);
    }

    public void loginApp() throws IOException{
        int ch = Integer.parseInt(choiceInputFromUserObj.inputLoginChoice());

        switch (ch) {

            case 1:
                interactWithShelfObj.interacting();
                break;

            case 2:
                editBookShelfObj.editingShelf();
                break;

            case 0:
                System.out.println("Visit Our Library Again!");
                return;

            default:
                System.out.println("Invalid Input!");
        }
    }
}
