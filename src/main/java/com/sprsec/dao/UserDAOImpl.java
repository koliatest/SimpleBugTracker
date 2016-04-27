package com.sprsec.dao;

import com.sprsec.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<User> listOfUsers() {
        return (List)openSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public User getUser(Integer id) {
        return (User) openSession().get(User.class, id);
    }

    @Override
    @Transactional
    public User getUser(String userName) {
        Query query = openSession().createQuery("select u from User u where u.login = :login");
        query.setString("login", userName);
        return (User)query.list().get(0);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        openSession().save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        openSession().update(user);
    }

    @Override
    @Transactional
    public void removeUser(Integer id) {
        openSession().delete(getUser(id));
    }
}
