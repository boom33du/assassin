package com.boom.assassin.exceptions;

/**
 * 注册用户时的异常封装类
 *
 * @author Zhang Qitao
 * @create 2020-03-14 17:17
 */
public class UserInfoOperationException extends RuntimeException {

    public UserInfoOperationException(String msg) {
        super(msg);
    }
}
