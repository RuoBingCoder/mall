package com.mall.service.impl;

import com.mall.common.ReponseResult;
import com.mall.dao.UserMapper;
import com.mall.pojo.User;
import com.mall.service.UserService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Response;

/**
 * @author : 石建雷
 * @date :2019/6/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int checkUserName(String userName) {
        return 0;
    }

    @Override
    public ReponseResult<User> login(String userName, String password) {
        int resultCount = userMapper.checkUserName(userName);
        if (resultCount == 0) {
            return ReponseResult.createByErrorMeaage("用户名不存在");

        }
//        todo Md5加密
        User user = userMapper.selectLogin(userName, password);
        if (user == null) {
            return ReponseResult.createByErrorMeaage("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ReponseResult.createBySuccess("登录成功！", user);
    }
}
