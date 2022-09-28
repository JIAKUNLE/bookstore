package com.Jaqune.Dao;

import com.Jaqune.bean.User;

import java.sql.SQLException;

public interface userRegist {

    User select (String username) throws SQLException;
    void adduser(User user) throws SQLException;
}
