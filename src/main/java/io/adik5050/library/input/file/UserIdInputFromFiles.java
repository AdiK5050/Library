package io.adik5050.library.input.file;

import io.adik5050.library.input.user.UserIdInputFromUser;
import io.adik5050.library.operations.user.UserVerification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class UserIdInputFromFiles {

    private final Path userInfoFile = Path.of(System.getProperty("user.home"),".myLibrary", "userInfo.txt");
    private final Path adminInfoFile = Path.of(System.getProperty("user.home"), ".myLibrary", "adminInfo.txt");

    public UserIdInputFromFiles() throws IOException{
        if(!Files.exists(userInfoFile)) {
            Path userInfoFolder = Path.of(System.getProperty("user.home"), ".myLibrary");
            if(!Files.exists(userInfoFolder)) Files.createDirectories(userInfoFolder);
            Files.createFile(userInfoFile);
            throw new FileNotFoundException("No User Data Available!");
        }
        else if(!Files.exists(adminInfoFile)) {
            Path adminInfoFolder = Path.of(System.getProperty("user.home"), ".myLibrary");
            if(!Files.exists(adminInfoFolder)) Files.createDirectories(adminInfoFolder);
            Files.createFile(adminInfoFile);
            throw new FileNotFoundException("No Admin Data Avaliable!");
        }
    }
    public HashMap<String , String> getUserIDs() throws IOException {

        HashMap<String, String> userIDs = new HashMap<>();
        ArrayList<String> beforeSeparated = new ArrayList<>(Files.readAllLines(userInfoFile));

         for(String keyValueSeparation : beforeSeparated) {
             if(keyValueSeparation.isEmpty()) continue;
             String[] splitted = keyValueSeparation.split(":-");
             if(splitted.length > 2) continue;
             userIDs.put(splitted[0], splitted[1]);
         }
        return userIDs;
    }

    public HashMap<String, String> getAdminIDs() throws IOException {
        HashMap<String, String> adminIDs = new HashMap<>();
        ArrayList<String> beforeSeparated = new ArrayList<>(Files.readAllLines(adminInfoFile));

        for(String keyValueSeparation : beforeSeparated) {
            if (keyValueSeparation.isEmpty()) continue;
            String[] splitted = keyValueSeparation.split(":-");
            if (splitted.length > 2) continue;
            adminIDs.put(splitted[0], splitted[1]);
        }
        return adminIDs;
    }
}


