package com.boom.assassin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zhang Qitao
 * @create 2020-03-14 20:24
 */
@Controller
@RequestMapping(value = "user")
public class UserForwardController {
    @RequestMapping(value = "/useroperate")
    public String userOperation(){
        return "/RegisterUser";
    }

}
