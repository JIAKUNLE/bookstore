package com.Jaqune.Service;

import com.Jaqune.bean.User;

public interface UserService {
    public void checkRegist(User user) throws Exception;

    public User  checkLogin(User user) throws  Exception;
}
