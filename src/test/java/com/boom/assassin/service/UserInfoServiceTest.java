package com.boom.assassin.service;

import com.boom.assassin.BaseTest;
import com.boom.assassin.dto.UserInfoExecution;
import com.boom.assassin.entity.UserInfo;
import com.boom.assassin.exceptions.UserInfoOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Zhang Qitao
 * @create 2020-03-16 10:38
 */
public class UserInfoServiceTest extends BaseTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void TestModifyUser() throws FileNotFoundException, UserInfoOperationException{
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1161L);
        userInfo.setUserName("修改后的用户名称");
        File userImg = new File("D:/images/coffee.jpg");
        InputStream inputStream = new FileInputStream(userImg);
        UserInfoExecution userInfoExecution = userInfoService.modifyUser(userInfo,inputStream,"coffee.jpg");
        System.out.println("新的图片地址为:" + userInfoExecution.getUserInfo().getUserImg());
    }


}
