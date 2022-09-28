package com.Jaqune.Service.Impl;

import com.Jaqune.Dao.imp.Regist01;
import com.Jaqune.Dao.userRegist;
import com.Jaqune.Service.UserService;
import com.Jaqune.bean.User;
import com.Jaqune.utils.MD5Util;

public class UserServiceImpl implements UserService {
    private userRegist userRegist = new Regist01();

    public void checkRegist(User user) throws Exception {

        User select = userRegist.select(user.getUserName());

        if (select != null) {
            throw new RuntimeException("用户名已存在");

        }

        user.setUserPassword(MD5Util.encode(user.getUserPassword()));

        userRegist.adduser(user);

    }

    @Override
    public User checkLogin(User user) throws Exception {

        User loginUser = userRegist.select(user.getUserName());

        if (loginUser != null) {

            if (MD5Util.encode(user.getUserPassword()).equals(loginUser.getUserPassword())) {
                return loginUser;

            } else {
                throw new RuntimeException("密码错误");
            }
        }
        throw new RuntimeException("用户名错误");
    }
}


