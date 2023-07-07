package com.example.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller //관리자가 됨 
public class MainController {
  @GetMapping({"/", "/home", "/main"})
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.addObject("name", "임의적인값");
        modelAndView.setViewName("/WEB-INF/views/main.jsp");
        return modelAndView;
    }
}
