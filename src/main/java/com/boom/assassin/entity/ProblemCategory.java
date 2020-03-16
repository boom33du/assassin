package com.boom.assassin.entity;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * 实体类
 * 题目类别表
 *
 * @author Zhang Qitao
 * @create 2020-03-14 16:34
 */
public class ProblemCategory {

    private Long problemCategoryId;
    private String problemCategoryName;
    private UserInfo userInfo;
    private Data problemCategoryCreateTime;
    private Data problemCategoryUpdateTime;
    //一个类别下有多个题目
    private List<ProblemInfo> problemInfoList;

    public Long getProblemCategoryId() {
        return problemCategoryId;
    }

    public void setProblemCategoryId(Long problemCategoryId) {
        this.problemCategoryId = problemCategoryId;
    }

    public String getProblemCategoryName() {
        return problemCategoryName;
    }

    public void setProblemCategoryName(String problemCategoryName) {
        this.problemCategoryName = problemCategoryName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Data getProblemCategoryCreateTime() {
        return problemCategoryCreateTime;
    }

    public void setProblemCategoryCreateTime(Data problemCategoryCreateTime) {
        this.problemCategoryCreateTime = problemCategoryCreateTime;
    }

    public Data getProblemCategoryUpdateTime() {
        return problemCategoryUpdateTime;
    }

    public void setProblemCategoryUpdateTime(Data problemCategoryUpdateTime) {
        this.problemCategoryUpdateTime = problemCategoryUpdateTime;
    }
}
