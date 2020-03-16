package com.boom.assassin.entity;

import javax.xml.crypto.Data;
import java.util.List;


/**
 * 实体类
 * 团队信息表
 *
 * @author Zhang Qitao
 * @create 2020-03-14 16:34
 */
public class TeamInfo {

    private Long teamId;
    private UserInfo userInfo;
    private String teamName;
    private String teamImg;
    private Integer teamScore;
    private Integer teamState;
    private Data teamCreateTime;
    private Data teamUpdateTime;
    private List<UserInfo> userInfoList;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamImg() {
        return teamImg;
    }

    public void setTeamImg(String teamImg) {
        this.teamImg = teamImg;
    }

    public Integer getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(Integer teamScore) {
        this.teamScore = teamScore;
    }

    public Integer getTeamState() {
        return teamState;
    }

    public void setTeamState(Integer teamState) {
        this.teamState = teamState;
    }

    public Data getTeamCreateTime() {
        return teamCreateTime;
    }

    public void setTeamCreateTime(Data teamCreateTime) {
        this.teamCreateTime = teamCreateTime;
    }

    public Data getTeamUpdateTime() {
        return teamUpdateTime;
    }

    public void setTeamUpdateTime(Data teamUpdateTime) {
        this.teamUpdateTime = teamUpdateTime;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
