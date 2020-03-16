package com.boom.assassin.enums;

/**
 * 判断当前账号状态
 *
 * @author Zhang Qitao
 * @create 2020-03-14 17:13
 */
public enum UserInfoStateEnum {
    SUCCESS(1,"启用"),OFFLINE(0,"禁用"),
    INNER_ERROR(-1001,"内部系统错误"),
    NULL_USER_INFO_ID(-1002,"用户ID为空"),
    NULL_USER_INFO(-1003,"用户信息为空");
    private int state;
    private String stateInfo;

    UserInfoStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    //依据传入的state值返回相应的enum值
    public static UserInfoStateEnum stateOf(int state){
        for(UserInfoStateEnum stateEnum:values()){
            if(stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
