package com.elibrarysecurity.projectsecurity.controller;


import com.elibrarysecurity.projectsecurity.model.BookCopy;
import com.elibrarysecurity.projectsecurity.model.CheckOutRecord;
import com.elibrarysecurity.projectsecurity.model.CheckinRecord;
import com.elibrarysecurity.projectsecurity.model.User;
import com.elibrarysecurity.projectsecurity.repository.UserRepository;
import com.elibrarysecurity.projectsecurity.service.impl.BookCopyService;
import com.elibrarysecurity.projectsecurity.service.impl.CheckOutRecordService;
import com.elibrarysecurity.projectsecurity.service.impl.CheckinRecordService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/eLibraryFinal/secure/bookcopy")
public class BookCopyController {

    @Autowired
    private BookCopyService bookCopyService;

    @Autowired
    private CheckOutRecordService checkOutRecordService;

    @Autowired
    private CheckinRecordService checkinRecordService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/eLibraryFinal/secure/bookcopy/browseoverdue")
    public ModelAndView displayListOfOverdueBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> overdues = bookCopyService.getOverdueCopies();
        modelAndView.addObject("bookCopies", overdues);
        modelAndView.setViewName("secure/bookcopy/browseoverdue");
        return modelAndView;
    }

    @GetMapping(value = "/eLibraryFinal/secure/bookcopy/browse")
    public ModelAndView displayListOfBookCopies() {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies();
        modelAndView.addObject("bookCopies", bookCopies);
        modelAndView.setViewName("secure/bookcopy/browse");
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView displayListSearchedBooks(@RequestParam(value = "search", required = false) String q, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies().stream()
                .filter(x -> x.getBookCopyNumber() == Long.parseLong(q))
                .collect(Collectors.toList());

            modelAndView.addObject("bookCopies", bookCopies);

        modelAndView.setViewName("secure/bookcopy/browse");
        return modelAndView;
    }

    @RequestMapping(value="/check", method= RequestMethod.POST, params="action=out")
    public String checkOut(@RequestParam(value = "usernumber", required = false) String usernumber,
                           @RequestParam(value = "bookCopyNumber", required = false)String bookCopyNumber, Model model){


        List<User> users = getUsersByUserNumber(usernumber);

        List<BookCopy> bookCopies = getBookCopiesByBookCopyNumber(bookCopyNumber);

        BookCopy bookCopy = bookCopies.get(0);
        if(!users.isEmpty()) {
            User user = users.get(0);
            CheckOutRecord checkOutRecord = new CheckOutRecord(user, bookCopy);
            checkOutRecordService.addCheckOutRecord(checkOutRecord);
        }

        return "redirect:/eLibraryFinal/secure/bookcopy/browse";
    }


    @RequestMapping(value="/check", method= RequestMethod.POST, params="action=in")
    public String checkIn(@RequestParam(value = "usernumber", required = false) String usernumber,
                           @RequestParam(value = "bookCopyNumber", required = false)String bookCopyNumber, Model model){


        List<User> users = getUsersByUserNumber(usernumber);

        List<BookCopy> bookCopies = getBookCopiesByBookCopyNumber(bookCopyNumber);

        BookCopy bookCopy = bookCopies.get(0);
        if(!users.isEmpty()) {
            User user = users.get(0);
            CheckinRecord checkinrecord = new CheckinRecord( bookCopy, user);
            checkinRecordService.addCheckinRecord(checkinrecord);
        }

        return "redirect:/eLibraryFinal/secure/bookcopy/browse";
    }

    private List<User> getUsersByUserNumber(String usernumber){
        return userRepository.findAll().stream()
                .filter(x -> x.getEmail().equals(Long.parseLong(usernumber))).collect(Collectors.toList());
    }

    private List<BookCopy> getBookCopiesByBookCopyNumber(String bookCopyNumber){
        return bookCopyService.getAllBookCopies().stream()
                .filter(x -> x.getBookCopyNumber() == Long.parseLong(bookCopyNumber)).collect(Collectors.toList());
    }



}
