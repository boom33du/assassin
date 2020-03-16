package com.boom.assassin.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码工具类 校验用户输入的验证码是否正确
 *
 * @author Zhang Qitao
 * @create 2020-03-13 11:42
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        //实际的验证码
        String verifyCodeExpected = (String)request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);

        //用户输入的验证码
        String verifyCodeActual = HttpServletRequestUtil
                .getString(request,"verifyCodeActual");

        //比较
        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)){
            return false;
        }
        return true;


    }
}
