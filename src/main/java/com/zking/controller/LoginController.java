package com.zking.controller;

import com.zking.model.User;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/")
    public  String goLogin(){
        return "login";
    }

    @RequiresPermissions("用户管理")
    @RequestMapping("/update")
    public  String updateUser(){
        return "update";
    }

    //哈哈哈哈


    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        String msg = "";
        int code= 1;//正常
        Map<String,Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken(
                user.getUsername(), user.getPassword()
        );
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            msg="账号不存在";
            code = -1;
        } catch(IncorrectCredentialsException e){
            msg = "密码错误";
            code = 0;
        }
        map.put("code",code);
        map.put("msg",msg);
        session.setAttribute("map",map);
        if(code<1){
            return "login";
        }else{
            //成功
            return "main";
        }

    }


}
