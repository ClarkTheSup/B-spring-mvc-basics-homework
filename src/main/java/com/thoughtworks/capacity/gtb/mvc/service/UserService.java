package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.DuplicatedUsernameException;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserListSingletonFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {

    public List<User> getUserList() {
        return UserListSingletonFactory.getInstance();
    }

    public void addUser(User user) {
        List<User> userList = this.getUserList();
        boolean isDuplicated = userList.stream()
                .anyMatch(ele -> ele.getUsername().equals(user.getUsername()));
        if (isDuplicated) {
            throw new DuplicatedUsernameException("用户名已存在", 400);
        } else {
            UserListSingletonFactory.getInstance().add(user);
        }
    }

    public User getUser(String username, String password) {
        List<User> userList = this.getUserList();
        List<User> loginUserList = userList.stream().filter(
                user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password)).collect(Collectors.toList());
        if (loginUserList.size() == 1) {
            return loginUserList.get(0);
        } else {
            throw new LoginException("用户名或密码错误", 404);
        }
    }
}
