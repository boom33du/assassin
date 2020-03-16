package com.boom.assassin.dto;

import com.boom.assassin.entity.UserInfo;
import com.boom.assassin.enums.UserInfoStateEnum;

import java.util.List;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 17:21
 */
public class UserInfoExecution {
    //结果状态
    private int state;

    //状态标识
    private  String stateInfo;

    //注册数量
    private int count;

    //操作的账户 增删改的时候用
    private UserInfo userInfo;

    //账户列表
    private List<UserInfo> userInfoList;

    //构造函数
    public UserInfoExecution(){

    }

    //个人信息修改处理失败时的构造器
    public UserInfoExecution(UserInfoStateEnum userInfoStateEnum){
        this.state = userInfoStateEnum.getState();
        this.stateInfo = userInfoStateEnum.getStateInfo();
    }


    //成功的构造器
    public UserInfoExecution(UserInfoStateEnum userInfoStateEnum,UserInfo userInfo){
        this.state = userInfoStateEnum.getState();
        this.stateInfo = userInfoStateEnum.getStateInfo();
        this.userInfo = userInfo;
    }

    public UserInfoExecution(UserInfoStateEnum userInfoStateEnum, List<UserInfo> userInfoList){
        this.state = userInfoStateEnum.getState();
        this.stateInfo = userInfoStateEnum.getStateInfo();
        this.userInfoList = userInfoList;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
