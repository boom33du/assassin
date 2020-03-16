package com.boom.assassin.dao;

import com.boom.assassin.entity.UserInfo;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 17:45
 */
public interface UserInfoDao {
    //新增用户
    int insertUserInfo(UserInfo userInfo);

    //更新用户
    int updateUserInfo(UserInfo userInfo);

    //通过userId查询用户信息
    UserInfo queryByUserId(Long userId);
}
