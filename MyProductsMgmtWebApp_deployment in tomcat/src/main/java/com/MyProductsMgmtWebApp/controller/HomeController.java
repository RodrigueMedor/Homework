package com.MyProductsMgmtWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @GetMapping(value = {"/", "MyProductsMgmtWebApp","home"})
    public String displayHome(){
        return "home/index";
    }
    @GetMapping(value = {"about"})
    public String displayAboutPage(){
        return "home/about";
    }
}
