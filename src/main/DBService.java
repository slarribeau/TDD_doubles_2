package main;

import java.util.HashMap;
import org.joda.time.DateTime;


public class DBService {
    private class User {
        String address;
        DateTime dateCreated;
    }
    private HashMap<String,User> userMap;
    TimeSource d;

    public DBService(TimeSource d) {
        userMap = new HashMap<String,User>();
        this.d = d;
    }

    public void store(String name, String address) {
        User u = new User();
        u.address = address;
        u.dateCreated = d.currentTime();
        System.out.println(u.dateCreated);
        userMap.put(name, u);
        System.out.println(userMap);
    }

    public String getAddress(String name) {
        return userMap.get(name).address;
    }

    public DateTime getCreationDate(String name) {
        return userMap.get(name).dateCreated;
    }
}