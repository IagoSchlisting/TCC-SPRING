package com.castel.service.impl;
import com.castel.dao.UserDao;
import com.castel.service.UserService;
import com.castel.models.User;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public User getUserByName(String name){ return this.userDao.getUserByName(name);}

    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    public List<User> listUsers(int user_id) {
        return this.userDao.listUsers(user_id);
    }

    @Override
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

}
