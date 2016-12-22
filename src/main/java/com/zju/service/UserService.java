package com.zju.service;

import com.zju.dao.UserDao;
import com.zju.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/22.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public int addUser(User user){
        return userDao.addUser(user);
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }
}
