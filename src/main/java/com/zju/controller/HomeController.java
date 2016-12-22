package com.zju.controller;

import com.zju.model.Question;
import com.zju.model.User;
import com.zju.model.ViewObject;
import com.zju.service.QuestionService;
import com.zju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

    //返回的是即将要渲染的对象
    public List<ViewObject> getQuestions(int userId, int offset, int limit){
        List<Question >  qlist = questionService.getLatestQuestions(userId, offset, limit);
        List<ViewObject> vos =new ArrayList<>();

        for (Question question : qlist){
            ViewObject vo =new ViewObject();
            vo.put("question" ,question);
            User user = userService.getUserById(question.getUserId());
            vo.put("user",user);

            vos.add(vo);
        }

        return vos;

    }

    @RequestMapping(value = "/")
    public String homeQuestion(Model model){
        List<ViewObject> vos =  getQuestions(0,1,5);
        model.addAttribute("vos",vos);
        return "home";

    }


}
