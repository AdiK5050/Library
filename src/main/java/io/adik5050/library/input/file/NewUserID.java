package io.adik5050.library.input.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public class NewUserID {

    private final Path adminInfoFile;
    private final Path userInfoFile;
    private static final Map<Integer,Character> alphaNumericMap = new HashMap<>();

    static {
        alphaNumericMap.put(1, 'A');
        alphaNumericMap.put(2, 'B');
        alphaNumericMap.put(3, 'C');
        alphaNumericMap.put(4, 'D');
        alphaNumericMap.put(5, 'E');
        alphaNumericMap.put(6, 'F');
        alphaNumericMap.put(7, 'G');
        alphaNumericMap.put(8, 'H');
        alphaNumericMap.put(9, 'I');
        alphaNumericMap.put(10, 'J');
        alphaNumericMap.put(11, 'K');
        alphaNumericMap.put(12, 'L');
        alphaNumericMap.put(13, 'M');
        alphaNumericMap.put(14, 'N');
        alphaNumericMap.put(15, 'O');
        alphaNumericMap.put(16, 'P');
        alphaNumericMap.put(17, 'Q');
        alphaNumericMap.put(18, 'R');
        alphaNumericMap.put(19, 'S');
        alphaNumericMap.put(20, 'T');
        alphaNumericMap.put(21, 'U');
        alphaNumericMap.put(22, 'V');
        alphaNumericMap.put(23, 'W');
        alphaNumericMap.put(24, 'X');
        alphaNumericMap.put(25, 'Y');
        alphaNumericMap.put(26, 'Z');
    }


    public NewUserID() throws IOException{
        this.adminInfoFile = Path.of(System.getProperty("user.home") ,".myLibrary", "adminInfo.txt");
        this.userInfoFile = Path.of(System.getProperty("user.home"), ".myLibrary", "userInfo.txt");
        if(!Files.exists(adminInfoFile.getParent())) Files.createDirectories(adminInfoFile.getParent());
        if(!Files.exists(adminInfoFile)) Files.createFile(adminInfoFile);
        if(!Files.exists(userInfoFile.getParent())) Files.createDirectories(userInfoFile.getParent());
        if(!Files.exists(userInfoFile)) Files.createFile(userInfoFile);
    }

    public String createUID() {
        StringBuilder newUserID = new StringBuilder("USER");
        Random generator = new Random();
        int count = 0;
        while(count <= 10) {
            int randomNumber = generator.nextInt(1, 27);
            for (Map.Entry<Integer, Character> entry : alphaNumericMap.entrySet()) {
                if (entry.getKey().equals(randomNumber))
                    newUserID.append(entry.getValue().toString());
            }
            count++;
        }
        return newUserID.toString();
    }

    public boolean checkUID(String newUserID) throws IOException {
        if(Files.readAllLines(userInfoFile).contains(newUserID)) return false;
        else return !Files.readAllLines(adminInfoFile).contains(newUserID);
    }

    public String addNewUser(String userName, String userID) throws IOException {
        Files.writeString(userInfoFile, "\n" + userName + " :- " + userID , StandardOpenOption.APPEND);
        return "Mr. " + userName + " this is your userID " + userID + "\nUse this to login from now on.";
    }
}
