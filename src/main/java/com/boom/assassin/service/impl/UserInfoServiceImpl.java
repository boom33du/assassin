package com.boom.assassin.service.impl;

import com.boom.assassin.dao.UserInfoDao;
import com.boom.assassin.dto.UserInfoExecution;
import com.boom.assassin.entity.UserInfo;
import com.boom.assassin.enums.UserInfoStateEnum;
import com.boom.assassin.exceptions.UserInfoOperationException;
import com.boom.assassin.service.UserInfoService;
import com.boom.assassin.util.ImageUtil;
import com.boom.assassin.util.PathUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 17:44
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao userInfoDao;

    public UserInfoServiceImpl(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }


    @Override
    @Transactional
    public UserInfoExecution addUser(UserInfo userInfo, InputStream userImgInputStream, String fileName){
        //空值判断
        if(userInfo == null){
            return new UserInfoExecution(UserInfoStateEnum.NULL_USER_INFO);
        }
        try{
            //给用户信息赋值
            userInfo.setUserStatus(1);
            userInfo.setUserScore(0);
            userInfo.setUserState(1);
            userInfo.setUserCreateTime(new Date());
            //添加用户信息
            int effectedNum = userInfoDao.insertUserInfo(userInfo);
            if(effectedNum <= 0){
                throw new UserInfoOperationException("注册用户失败");
            } else {
                if(userImgInputStream != null){
                    //存储图片
                    try{
                        addUserImg(userInfo, userImgInputStream,fileName);
                    } catch (Exception e){
                        throw new UserInfoOperationException("addUserImg error" + e.getMessage());
                    }
                    //更新店铺图片地址
                    effectedNum = userInfoDao.updateUserInfo(userInfo);
                    if (effectedNum <= 0){
                        throw new UserInfoOperationException("更新图片地址失败");
                    }
                }
            }
        }catch (Exception e){
            throw new UserInfoOperationException("addUserInfo error" + e.getMessage());
        }
        return new UserInfoExecution(UserInfoStateEnum.SUCCESS, userInfo);
    }

    private void addUserImg(UserInfo userInfo, InputStream userImgInputStream,String fileName){
        //获取用户头像图片目录的相对值路径
        String dest = PathUtil.getUserImagePath(userInfo.getUserId());
        String userImgAddr = ImageUtil.generateThumbnail(userImgInputStream,fileName,dest);
        userInfo.setUserImg(userImgAddr);

    }



    @Override
    public UserInfo getByUserId(Long userId) {
        return userInfoDao.queryByUserId(userId);
    }

    @Override
    public UserInfoExecution modifyUser(UserInfo userInfo, InputStream userImgInputStream, String fileName) throws UserInfoOperationException {
       if (userInfo == null || userInfo.getUserId() == null) {
           return new UserInfoExecution(UserInfoStateEnum.NULL_USER_INFO);
       } else {
           try{
               //1.判断是否需要处理图片
               if (userImgInputStream != null && fileName != null && "".equals(fileName)) {
                   UserInfo tempUserInfo = userInfoDao.queryByUserId(userInfo.getUserId());
                   if (tempUserInfo.getUserImg() != null) {
                       ImageUtil.deleteFileOrPath(tempUserInfo.getUserImg());
                   }
                   addUserImg(userInfo,userImgInputStream,fileName);
               }
               //2.修改店铺信息
               userInfo.setUserUpdateTime(new Date());
               int effectedNum = userInfoDao.updateUserInfo(userInfo);
               if (effectedNum <= 0) {
                   return new UserInfoExecution(UserInfoStateEnum.INNER_ERROR);
               } else {
                   userInfo = userInfoDao.queryByUserId(userInfo.getUserId());
                   return new UserInfoExecution(UserInfoStateEnum.SUCCESS,userInfo);
               }
           } catch (Exception e) {
               throw new UserInfoOperationException("modifyUser error" + e.getMessage());
           }


       }


    }

}
