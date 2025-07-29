package io.adik5050.library.input.file;

import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class UserIdInputFromFiles {

    Path userInfoFile = Path.of(System.getProperty("user.home"),".myLibrary", "userInfo.txt");

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
}


