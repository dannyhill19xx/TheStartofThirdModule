package com.kata.thestartofthirdmodule.dao;

import com.kata.thestartofthirdmodule.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User showUser(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}

