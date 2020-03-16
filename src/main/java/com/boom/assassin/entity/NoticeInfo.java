package com.boom.assassin.entity;

import javax.xml.crypto.Data;

/**
 * 实体类
 * 公告表
 *
 * @author Zhang Qitao
 * @create 2020-03-14 16:34
 */
public class NoticeInfo {
    private Long noticeId;
    private String noticeTitle;
    private String noticeText;
    //获取创建人
    private UserInfo userInfo;
    private Data noticeCreateTime;
    private Data noticeUpdateTime;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Data getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(Data noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public Data getNoticeUpdateTime() {
        return noticeUpdateTime;
    }

    public void setNoticeUpdateTime(Data noticeUpdateTime) {
        this.noticeUpdateTime = noticeUpdateTime;
    }
}
