package main;

import java.util.HashMap;

public class DBService {
    private HashMap<Long,String> userMap;
    private IdGenerator idGen;

    public DBService(IdGenerator idGen) {
        userMap = new HashMap<Long,String>();
        this.idGen = idGen;
    }

    public long store(String name) {
        long id = idGen.get();
        userMap.put(id, name);
        System.out.println(userMap);
        return id;
    }

    public String find(long id) {
        return userMap.get(id);
    }
}