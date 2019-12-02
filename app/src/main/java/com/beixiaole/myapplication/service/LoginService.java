package com.beixiaole.myapplication.service;

import com.beixiaole.myapplication.data.model.LoggedInUser;

public class LoginService {
    public boolean loginConfirm(LoggedInUser user){
        boolean flag = false;

        if(user.getUserName().equals("123")&&user.getPassword().equals("qwe"))
            flag=true;

        return flag;
    }
}
