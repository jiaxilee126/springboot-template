package com.lee.study.springboot.controller;

import com.lee.study.springboot.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/25 15:10
 */
@Controller
public class UserController {

    @RequestMapping(value = {"/login","/"})
    public String home(User user) {

        return "login";
    }

    @RequestMapping("/index")
    @PreAuthorize("hasAuthority('admin')")
    public String index(){
        return "index";
    }

    @RequestMapping("/main")
    @PreAuthorize("hasAuthority('admin')")
    public String main() {
        return "main";
    }

    @Secured(value = "test")
    @PreAuthorize("hasAuthority('test')")
    public String test() {
        return  "test";
    }
}
