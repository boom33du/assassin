package com.boom.assassin.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.omg.CORBA.BAD_CONTEXT;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图片处理工具类
 *
 * @author Zhang Qitao
 * @create 2020-03-14 18:21
 */
public class ImageUtil {
    //获取水印路径
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();


    //处理缩略图
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

        //创建缩略图
        try{
            //解决获取到的路径编码问题 防止出错
            basePath= URLDecoder.decode(basePath,"utf-8");
            Thumbnails.of(thumbnailInputStream).size(200,200).
                    watermark(Positions.BOTTOM_LEFT, ImageIO.read(
                            new File(basePath + "watermark.jpg")),0.15f).
                    outputQuality(0.8f).toFile(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr){
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    //生成随机数文件名,当前年月日小时分钟秒钟+五位随机数
    public static String getRandomFileName() {
        //获取随机数
        int ranNum = r.nextInt(89999) + 10000;
        String nowTimerStr = sDateFormat.format(new Date());
        return nowTimerStr + ranNum;
    }

    /**
     * 删除文件或目录
     * 如果是文件就删除
     * 如果是目录就递归删除目录下所有文件,然后删除目录
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){

        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

    /**
     * 获取输入文件扩展名
     * @param
     * @return
     */
    private static String getFileExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void main(String[] args) throws IOException {
        //解决获取到的路径编码问题 防止出错
        basePath= URLDecoder.decode(basePath,"utf-8");
        Thumbnails.of(new File("C:\\Users\\boom\\Desktop\\test.png")).size(200, 200)
            .watermark(
                Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.15f)
            .outputQuality(0.1f).toFile("C:\\Users\\boom\\Desktop\\newTest.png");
    }




}
