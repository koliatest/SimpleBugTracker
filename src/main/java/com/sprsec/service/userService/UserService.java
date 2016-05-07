package com.sprsec.service.userService;

import com.sprsec.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> listOfUsers();
    public User getUser(Integer id);
    public User getUser(String userName);
    public void createUser(User user);
    public void updateUser(User user);
    public void removeUser(Integer id);
}
