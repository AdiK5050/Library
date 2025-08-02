package io.adik5050.library.util;

public class UserNotFoundException extends Exception{
    @Override
    public String toString() {
        return "New User? \nPress 1 to Sign In \nPress 0 to exit";
    }
}
