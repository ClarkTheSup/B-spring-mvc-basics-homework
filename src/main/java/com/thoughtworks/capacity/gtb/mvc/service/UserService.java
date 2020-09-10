package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.DuplicatedUsernameException;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.repository.UserListSingletonFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new DuplicatedUsernameException("用户名已存在");
        } else {
            UserListSingletonFactory.getInstance().add(user);
        }
    }
}
