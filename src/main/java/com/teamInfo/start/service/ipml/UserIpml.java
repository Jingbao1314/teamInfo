package com.teamInfo.start.service.ipml;

import com.teamInfo.start.dao.UserDao;
import com.teamInfo.start.pojo.User;
import com.teamInfo.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jijngbao
 * @date 19-4-6
 */
@Service
public class UserIpml implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public User selectUserByPhone(String phone) {
        return userDao.selectUserByPhone(phone);
    }

    @Override
    public User selectUserByPhoneAndPsw(String phone, String psw) {
        return userDao.selectUserByPhoneAndPsw(phone,psw);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(String phone) {
        return userDao.deleteUser(phone);
    }

    @Override
    public int selectByPhoneAndPsw(String phone, String psw) {
        return userDao.selectByPhoneAndPsw(phone,psw);
    }
}
