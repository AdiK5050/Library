package io.adik5050.library;

import java.util.Scanner;
import io.adik5050.library.app.Application;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Application appObj = new Application(sc);
            appObj.loginApp();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
