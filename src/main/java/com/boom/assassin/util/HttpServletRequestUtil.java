package com.boom.assassin.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zhang Qitao
 * @create 2020-02-19 20:29
 */
public class HttpServletRequestUtil {
    /**
     * 将key转化为int型,转化失败 返回-1
     * @param request
     * @param key
     * @return
     */
    public static int getInt(HttpServletRequest request,String key){
        try{
            return Integer.decode(request.getParameter(key));
        } catch (Exception e){
            return -1;
        }
    }

    /**
     * 将key转化为long型,转化失败 返回-1
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request,String key){
        try{
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e){
            return -1;
        }
    }

    /**
     *将key转化成double型 转化失败 返回-1
     * @param request
     * @param key
     * @return
     */
    public static double getDouble(HttpServletRequest request,String key){
        try{
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e){
            return -1d;
        }
    }

    /**
     * 将key转化为boolean型 转化失败 返回false
     * @param request
     * @param key
     * @return
     */
    public static boolean getBoolean(HttpServletRequest request,String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e){
            return false;
        }
    }

    //

    public static String getString(HttpServletRequest request,String key){
        try{
            String result = request.getParameter(key);
            if(result != null){
                result = result.trim();
            }
            if("".equals(result)){
                return null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }


}
