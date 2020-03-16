package com.boom.assassin.service;

import com.boom.assassin.dto.UserInfoExecution;
import com.boom.assassin.entity.UserInfo;
import com.boom.assassin.exceptions.UserInfoOperationException;

import java.io.InputStream;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 17:20
 */
public interface UserInfoService {
    //通过用户Id 获取用户信息
    UserInfo getByUserId(Long userId);

    //修改用户信息
    UserInfoExecution modifyUser(UserInfo userInfo,InputStream userImgInputStream,String fileName) throws UserInfoOperationException;

    //添加用户
    UserInfoExecution addUser(UserInfo userInfo, InputStream userImgInputStream,String fileName) throws RuntimeException;
}
