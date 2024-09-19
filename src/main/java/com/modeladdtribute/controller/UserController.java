package com.modeladdtribute.controller;

import com.modeladdtribute.model.Login;
import com.modeladdtribute.model.User;
import com.modeladdtribute.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping("/login")
    public ModelAndView Home() {
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user= UserDao.checkLogin(login);
        ModelAndView modelAndView;
        if (user==null){
            modelAndView= new ModelAndView("error");
        }else{
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }

}
