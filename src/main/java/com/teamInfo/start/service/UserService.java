package com.teamInfo.start.service;


import com.teamInfo.start.pojo.User;

public interface UserService {
    User selectUserByPhone(String phone);
    User selectUserByPhoneAndPsw(String phone,String psw);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(String phone);
    int selectByPhoneAndPsw(String phone,String psw);

}
