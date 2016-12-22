package com.zju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 测试三个：
 * 1、@PathVariable,@RequestParam,
 * 2、HttpServletRequest,HttpServletResponse,Cookie,HttpSession;等
 * 3、Model
 */
@Controller
public class ControllerTest {

    //第0条测试：controller
    @RequestMapping(value = {"/test"},method = RequestMethod.GET)
    @ResponseBody
    public String test(HttpSession session){

        return "hello " +session.getId();
    }


    @RequestMapping(value = {"/profile/{profileId}/{userId}"},method = RequestMethod.GET)
    @ResponseBody
    public String test(@PathVariable(value = "profileId") String profileId,
                       @PathVariable(value = "userId") String userId,
                       @RequestParam(value = "name",defaultValue = "wubo",required = false) String name,
                       @RequestParam(value = "password",defaultValue = "123",required = false) String password
                       ){

        String str = String.format("你当前的个人主页Id是 %s ,%s,你的姓名密码是 %s,%s",profileId,userId,name,password);
        return str;
    }


    @RequestMapping(value = {"/profile"})
    @ResponseBody
    public String test(HttpServletRequest request,
                       HttpServletResponse response){
        StringBuffer sb=new StringBuffer();



        sb.append(request.getRequestURL());
        sb.append(request.getCookies());
        sb.append(request.getQueryString());
        sb.append(request.getSession());
//        sb.append(String.valueOf(cookie.getMaxAge()));

        response.setHeader("头文件","zheshasda");
        response.addCookie(new Cookie("cokkkkkkk","This is a cookie"));


        System.out.println(sb.toString().toCharArray());

        return sb.toString();


    }

    @RequestMapping(value = {"/model"})
    public String test(Model model) {
        ArrayList<String> list =new ArrayList<>();
        list.add("黄色");
        list.add("蓝色");
        list.add("绿色");

        HashMap<String,String> map = new HashMap<>();
        map.put("color","blue");
        map.put("size","big");


        model.addAttribute("color","while");
        model.addAttribute("map",map);
        model.addAttribute("list",list);
        return "testModel";

    }

}
