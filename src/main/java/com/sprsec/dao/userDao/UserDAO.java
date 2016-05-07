package com.sprsec.dao.userDao;

import com.sprsec.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> listOfUsers();
    public User getUser(Integer id);
    public User getUser(String userName);
    public void createUser(User user);
    public void updateUser(User user);
    public void removeUser(Integer id);

}
