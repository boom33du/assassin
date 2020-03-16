package com.boom.assassin.util;

/**
 * 资源路径工具类
 *
 * @author Zhang Qitao
 * @create 2020-03-14 18:17
 */
public class PathUtil {

    //separator 用来存放系统文件路径分隔符
    private static String separator = System.getProperty("file.separator");

    //获取图片存放根目录
    public static String getImgBasePath(){
        //获取系统 win还是linux/mac
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/assassin/image/";
        } else {
            basePath = "/home/boom/assassin/image/";
        }
        basePath = basePath.replace("/",separator);
        return basePath;
    }

    //用户头像路径
    public static String getUserImagePath(long userId) {
        String imagePath = "/upload/item/user/" + userId + "/";
        return imagePath.replace("/",separator);
    }
    //团队标志路径
    public static String getTeamImagePath(long teamId) {
        String imagePath = "/upload/item/team/" + teamId + "/";
        return imagePath.replace("/",separator);
    }
}
