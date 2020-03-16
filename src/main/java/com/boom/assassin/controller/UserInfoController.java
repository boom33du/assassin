package com.boom.assassin.controller;

import com.boom.assassin.dto.UserInfoExecution;
import com.boom.assassin.entity.UserInfo;
import com.boom.assassin.enums.UserInfoStateEnum;
import com.boom.assassin.service.UserInfoService;
import com.boom.assassin.util.CodeUtil;
import com.boom.assassin.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 18:46
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @RequestMapping(value = "/getuserbyid",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getUserById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        Long userId = HttpServletRequestUtil.getLong(request,"userId");
        if (userId > -1) {
            try{
                UserInfo userInfo = userInfoService.getByUserId(userId);
                modelMap.put("userInfo",userInfo);
                modelMap.put("success",true);
            } catch (Exception e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }

        } else {
            modelMap.put("success",false);
            modelMap.put("errMsg","empty userId");
        }

        return modelMap;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerUserInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();

        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success",false);
            modelMap.put("errMsg","验证码错误");
            return modelMap;
        }

        // 1.接受并转化用户信息,包括图片
        String userStr = HttpServletRequestUtil.getString(request,"userStr");
        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = null;
        try{
            userInfo = mapper.readValue(userStr,UserInfo.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile userImg;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            userImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("userImg");

        } else {
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        // 2. 注册账号
        if (userInfo != null && userImg != null){
//            File userImageFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
//            try{
//                userImageFile.createNewFile();
//            }catch (Exception e){
//                modelMap.put("success",false);
//                modelMap.put("errMsg",e.getMessage());
//                return modelMap;
//            }
//            try {
//                inputStreamToFile(userImg.getInputStream(),userImageFile);
//            } catch (IOException e) {
//                modelMap.put("success",false);
//                modelMap.put("errMsg",e.getMessage());
//                return modelMap;
//            }
            UserInfoExecution userInfoExecution = null;
            try {
                userInfoExecution = userInfoService.addUser(userInfo,userImg.getInputStream(),userImg.getOriginalFilename());
                if (userInfoExecution.getState() == UserInfoStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                } else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",userInfoExecution.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",userInfoExecution.getStateInfo());
            }
            return modelMap;
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入个人信息");
            return modelMap;
        }

        // 3. 返回结果
    }


    //修改店铺信息
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyUserInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();

        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success",false);
            modelMap.put("errMsg","验证码错误");
            return modelMap;
        }

        // 1.接受并转化用户信息,包括图片
        String userStr = HttpServletRequestUtil.getString(request,"userStr");
        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = null;
        try{
            userInfo = mapper.readValue(userStr,UserInfo.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile userImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            userImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("userImg");

        }
        // 2. 修改账户信息
        if (userInfo != null && userInfo.getUserId() != null){

            UserInfoExecution userInfoExecution = null;
            try {
                if (userImg == null){
                    userInfoExecution = userInfoService.modifyUser(userInfo,null,null);
                } else {
                    userInfoExecution = userInfoService.modifyUser(userInfo,userImg.getInputStream(),userImg.getOriginalFilename());
                }
                if (userInfoExecution.getState() == UserInfoStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                } else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",userInfoExecution.getStateInfo());

                }
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",userInfoExecution.getStateInfo());
            }

            return modelMap;

        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入个人信息");
            return modelMap;
        }

        // 3. 返回结果
    }





    /**
     * CommonsMultipartFile 文件输入流转 File 文件
     * @param inputStream
     * @param file
     */
    private static void inputStreamToFile(InputStream inputStream, File file){
        FileOutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while((bytesRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,bytesRead);
            }
        } catch (Exception e){
            throw new RuntimeException("调用inputStreamToFile产生异常" + e.getMessage());
        }finally{
            try{
                if(outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null){
                    inputStream.close();
                }
            }catch (Exception e) {
                throw new RuntimeException("inputStreamToFile关闭io产生异常" + e.getMessage());
            }
        }
    }
}
