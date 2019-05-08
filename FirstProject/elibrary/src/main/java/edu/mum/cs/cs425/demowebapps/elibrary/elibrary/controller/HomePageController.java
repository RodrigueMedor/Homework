package edu.mum.cs.cs425.demowebapps.elibrary.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController{
    @GetMapping(value = {"/", "/elibrary", "/elibrary/home"})
    public String displayHommePage(){
        return "home/index";
    }
}