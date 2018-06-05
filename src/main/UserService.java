package main;

import java.util.HashMap;
import org.joda.time.DateTime;


public class UserService {
    private class User {
        String address;
        DateTime dateCreated;
    }

    private HashMap<String,User> userMap;
    private TimeService timeService;
    private LogService logService;

    public UserService(TimeService timeService, LogService logService) {
        userMap = new HashMap<String,User>();
        this.timeService = timeService;
        this.logService = logService;
    }

    public void store(String name, String address) {
        User u = new User();
        u.address = address;
        u.dateCreated = timeService.currentTime();
        userMap.put(name, u);
        logService.log("user", "PUT", name);
        //System.out.println(userMap);
    }

    public String getAddress(String name) {
        return userMap.get(name).address;
    }

    public DateTime getCreationDate(String name) {
        return userMap.get(name).dateCreated;
    }
}