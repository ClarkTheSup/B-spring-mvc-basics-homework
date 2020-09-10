package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserListSingletonFactory {
    private static List<User> userList = new ArrayList<User>();
    private UserListSingletonFactory() {}

    public static List<User> getInstance() {
        return userList;
    }
}
