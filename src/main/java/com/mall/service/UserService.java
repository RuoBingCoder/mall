package com.mall.service;

import com.mall.common.ReponseResult;
import com.mall.pojo.User;

/**
 * @author : 石建雷
 * @date :2019/6/27
 */
public interface UserService {

    int checkUserName(String userName);

    ReponseResult<User> login(String userName, String password);
}
