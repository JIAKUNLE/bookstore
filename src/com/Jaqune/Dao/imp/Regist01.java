package com.Jaqune.Dao.imp;

import com.Jaqune.Dao.BaseDao;
import com.Jaqune.Dao.userRegist;
import com.Jaqune.bean.User;

import java.sql.SQLException;

public class Regist01 extends BaseDao<User> implements userRegist {


    @Override
    public User select(String username) throws SQLException {

        String sql = "select user_id id,user_name userName,user_pwd userPassword,email userEmail from t_user where user_name = ?";
        return getBean(sql,User.class,username);


    }

    public void adduser(User user) throws SQLException{

        String sql = "insert into t_user (user_name,user_pwd,email) values (?,?,?)";

        update(sql,user.getUserName(),user.getUserPassword(),user.getUserEmail());

    }
}
