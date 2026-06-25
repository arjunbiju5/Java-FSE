package com.junit;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<String> users = new ArrayList<>();

    public void addUser(String name)      { users.add(name); }
    public boolean hasUser(String name)   { return users.contains(name); }
    public int getUserCount()             { return users.size(); }
    public void removeUser(String name)   { users.remove(name); }
}