package io.adik5050.library.app;

import java.io.IOException;
import java.util.Scanner;
import io.adik5050.library.input.user.ChoiceInputFromUser;
import io.adik5050.library.operations.user.InteractWithShelf;
import io.adik5050.library.operations.user.EditBookShelf;
import io.adik5050.library.operations.user.UserLogin;
import io.adik5050.library.util.UserNotFoundException;

public class Application {

    Scanner sc;
    UserLogin userLoginObj;
    EditBookShelf editBookShelfObj;
    InteractWithShelf interactWithShelfObj;
    ChoiceInputFromUser choiceInputFromUserObj;


    public Application(Scanner sc) throws IOException {
        this.sc = sc;
        this.userLoginObj = new UserLogin(this.sc);
        this.choiceInputFromUserObj = new ChoiceInputFromUser(this.sc);
        this.editBookShelfObj = new EditBookShelf(this.sc);
        this.interactWithShelfObj = new InteractWithShelf(this.sc);
    }

    public void loginApp() {
        try {
            int ch = Integer.parseInt(choiceInputFromUserObj.inputLoginChoice());
            switch (ch) {

                case 1:
                    interactWithShelfObj.interacting();
                    break;

                case 2:
                    editBookShelfObj.editingShelf();
                    break;

                case 3:
                    System.out.println(userLoginObj.generateUserID());
                    break;

                case 0:
                    System.out.println("Visit Our Library Again!");
                    return;

                default:
                    System.out.println("Invalid Input!");
            }
        }catch (UserNotFoundException e) {
            System.out.println(e);
            int temp = sc.nextInt();
            if(temp == 1) {
                try {
                    System.out.println(userLoginObj.generateUserID());
                }catch (Exception e1) {
                    throw new RuntimeException();
                }
            }

        }catch (Exception e2) {
            throw new RuntimeException();
        }

    }
}
