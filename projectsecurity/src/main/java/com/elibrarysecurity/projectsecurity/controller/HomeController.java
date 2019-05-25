package com.elibrarysecurity.projectsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/elibrary"})
    public String index() {
       // return "public/home/index";
        return "secure/home/home";
    }

    @GetMapping(value = {"/elibrary/public/login"})
    public String login() {
        return "public/home/login";
    }

//    @GetMapping(value = {"/elibrary/public/about"})
//    public String about() {
//        return "public/home/about";
//    }
//
//    @GetMapping(value = {"/elibrary/public/virtualtour"})
//    public String virtualtour() {
//        return "public/home/virtualtour";
//    }

//    @GetMapping(value = {"/elibrary/secure/home"})
//    public String home() {
//        return "secure/home/home";
//    }
//
//    @GetMapping(value = {"/elibrary/secure/about"})
//    public String sec_about() {
//        return "public/secure/about";
//    }

//    @GetMapping(value = {"/elibrary/secure/virtualtour"})
////    public String sec_virtualtour() {
////        return "public/secure/virtualtour";
////    }

    @GetMapping(value = {"/eLibraryFinal/secure/book/new"})
    public String addBook() {
        return "secure/book/new";
    }

//    @GetMapping(value = {"/elibrary/secure/edit"})
//    public String editBook() {
//        return "public/secure/edit";
//    }

    @GetMapping(value = {"/eLibraryFinal/secure/book/browse"})
    public String book() {
        return "secure/book/browse";
    }

    @GetMapping(value = {"/eLibraryFinal/secure/user/browse"})
    public String user() {
        return "secure/user/browse";
    }


    @GetMapping(value = {"/eLibraryFinal/secure/user/new"})
    public String addUser() {
        return "secure/user/new";
    }



    @GetMapping(value = {"/eLibraryFinal/secure/bookcopy/browse"})
    public String copyBook() {
        return "secure/bookcopy/browse";
    }

    @GetMapping(value = {"/eLibraryFinal/secure/bookcopy/browseoverdue"})
    public String browseoverdue() {
        return "secure/bookcopy/browseoverdue";
    }

}
