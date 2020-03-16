package com.boom.assassin.entity;

import javax.xml.crypto.Data;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 16:35
 */
public class ProblemInfo {
    private Long problemId;
    private String problemTitle;
    private Long problemCategoryId;
    private String problemTip;
    private String problemText;
    private String  problemFile;
    private Integer problemScore;
    private Integer problemPunish;
    private Integer problemReward;
    private Integer decrementValue;
    private String problemFlag;
    private Integer problemState;
    private Long firstBloodUser;
    private Long secondBloodUser;
    private Long thirdBloodUser;
    private UserInfo userInfo;
    private Data problemCreateTime;
    private Data problemUpdateTime;

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public Long getProblemCategoryId() {
        return problemCategoryId;
    }

    public void setProblemCategoryId(Long problemCategoryId) {
        this.problemCategoryId = problemCategoryId;
    }

    public String getProblemTip() {
        return problemTip;
    }

    public void setProblemTip(String problemTip) {
        this.problemTip = problemTip;
    }

    public String getProblemText() {
        return problemText;
    }

    public void setProblemText(String problemText) {
        this.problemText = problemText;
    }

    public String getProblemFile() {
        return problemFile;
    }

    public void setProblemFile(String problemFile) {
        this.problemFile = problemFile;
    }

    public Integer getProblemScore() {
        return problemScore;
    }

    public void setProblemScore(Integer problemScore) {
        this.problemScore = problemScore;
    }

    public Integer getProblemPunish() {
        return problemPunish;
    }

    public void setProblemPunish(Integer problemPunish) {
        this.problemPunish = problemPunish;
    }

    public Integer getProblemReward() {
        return problemReward;
    }

    public void setProblemReward(Integer problemReward) {
        this.problemReward = problemReward;
    }

    public Integer getDecrementValue() {
        return decrementValue;
    }

    public void setDecrementValue(Integer decrementValue) {
        this.decrementValue = decrementValue;
    }

    public String getProblemFlag() {
        return problemFlag;
    }

    public void setProblemFlag(String problemFlag) {
        this.problemFlag = problemFlag;
    }

    public Integer getProblemState() {
        return problemState;
    }

    public void setProblemState(Integer problemState) {
        this.problemState = problemState;
    }

    public Long getFirstBloodUser() {
        return firstBloodUser;
    }

    public void setFirstBloodUser(Long firstBloodUser) {
        this.firstBloodUser = firstBloodUser;
    }

    public Long getSecondBloodUser() {
        return secondBloodUser;
    }

    public void setSecondBloodUser(Long secondBloodUser) {
        this.secondBloodUser = secondBloodUser;
    }

    public Long getThirdBloodUser() {
        return thirdBloodUser;
    }

    public void setThirdBloodUser(Long thirdBloodUser) {
        this.thirdBloodUser = thirdBloodUser;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Data getProblemCreateTime() {
        return problemCreateTime;
    }

    public void setProblemCreateTime(Data problemCreateTime) {
        this.problemCreateTime = problemCreateTime;
    }

    public Data getProblemUpdateTime() {
        return problemUpdateTime;
    }

    public void setProblemUpdateTime(Data problemUpdateTime) {
        this.problemUpdateTime = problemUpdateTime;
    }
}
