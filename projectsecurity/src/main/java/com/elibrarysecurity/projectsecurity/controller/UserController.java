package com.elibrarysecurity.projectsecurity.controller;




import com.elibrarysecurity.projectsecurity.mock.CreateData;
import com.elibrarysecurity.projectsecurity.model.BookCopy;
import com.elibrarysecurity.projectsecurity.model.CheckOutRecord;
import com.elibrarysecurity.projectsecurity.model.User;
import com.elibrarysecurity.projectsecurity.repository.RoleRepository;
import com.elibrarysecurity.projectsecurity.repository.UserRepository;
import com.elibrarysecurity.projectsecurity.service.ICheckOutRecordService;
import com.elibrarysecurity.projectsecurity.service.ICheckinRecordService;
import com.elibrarysecurity.projectsecurity.service.impl.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping(value = "/eLibraryFinal/secure/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ICheckinRecordService checkinRecordService;

    @Autowired
    private ICheckOutRecordService checkOutRecordService;

    @Autowired
    private BookCopyService bookCopyService;


    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "/eLibraryFinal/secure/user/browse")
    public ModelAndView displayListOfUsers() {
        ModelAndView modelAndView = new ModelAndView();

        //generateOverdueFines();
        List<User> users = userRepository.findAll();



        modelAndView.addObject("users", users);
        modelAndView.setViewName("secure/user/browse");
        return modelAndView;
    }
    // @Transactional
    @GetMapping(value = "/eLibraryFinal/secure/user/new")
    public String newUserForm(Model model) {

      //  List<UserType> userTypes = userTypeService.getAllUserTypes();

        model.addAttribute("user", new User());

        model.addAttribute("userTypes", roleRepository.findAll());

        return "secured/user/new";
    }
//    @RequestMapping(value="/eLibraryFinal/secure/user/new", method = RequestMethod.GET)
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.addObject("userTypes", roleRepository.findAll());
//        modelAndView.setViewName("new");
//        return modelAndView;
//    }

    @Autowired
    private CreateData createUser;
    @PostMapping(value = "/new")
    public String addNewUser(@Valid @ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
          //  List<UserType> userTypes = userTypeService.getAllUserTypes();
            model.addAttribute("userTypes", roleRepository.findAll());
            return "secured/user/new";
        }
//        user = userRepository.save(user);
        user = createUser.createUser(user);
        return "redirect:/eLibraryFinal/secure/user/browse";
    }



    @GetMapping(value = "/edit/{id}")
//    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editUserForm(@PathVariable Integer id, Model model){
//    public String editUserForm( Model model){

       // List<UserType> userTypes = userTypeService.getAllUserTypes();

//        model.addAttribute("user", new User());

        model.addAttribute("user", userRepository.findById(id));

        model.addAttribute("userTypes", roleRepository.findAll());

        return "secured/user/edit";
    }

    @PostMapping(value = "/edit")
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("user") User user,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
           // List<UserType> userTypes = userTypeService.getAllUserTypes();
            model.addAttribute("userTypes", roleRepository.findAll());
            model.addAttribute("errors", result.getAllErrors());
            return "secured/user/edit";
        }

        user = userRepository.save(user);
        return "redirect:/eLibraryFinal/secured/user/edit";

    }



    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model){
        userRepository.deleteById(id);
        return "redirect:/eLibraryFinal/secured/user/browse";
    }

//    @RequestMapping(value="/payoverdue/{id}", method = RequestMethod.GET)
//    public String payOverDue(@PathVariable Integer id, Model model){
//        User user = userRepository.findById(id);
//        user.setOverduefine(0.0);
//        userService.addUser(user);
//        return "redirect:/eLibraryFinal/secured/user/browse";
//    }


    public void generateOverdueFines(){


        List<BookCopy> overdues = bookCopyService.getOverdueCopies();

        for(BookCopy bookCopy : overdues){
            int size = bookCopy.getCheckOutRecords().size();
            CheckOutRecord checkOutRecord = bookCopy.getCheckOutRecords().get(size - 1);
            User user = checkOutRecord.getUser();
            LocalDate lastOverdueGenerated = user.getLastOverdueGenerated();
            double overdueFine = 0;
            if(lastOverdueGenerated == null) {
                double days = ChronoUnit.DAYS.between(checkOutRecord.getOverdueDate(), LocalDate.now());
                overdueFine = days * 2;
                lastOverdueGenerated = LocalDate.now();
                user.setLastOverdueGenerated(lastOverdueGenerated);
                user.setOverduefine(user.getOverduefine() + overdueFine);
                createUser.createUser(user);
            } else {
                double days = ChronoUnit.DAYS.between(lastOverdueGenerated, LocalDate.now());
                overdueFine = days * 2;
                user.setLastOverdueGenerated(lastOverdueGenerated);
                user.setOverduefine(user.getOverduefine() + overdueFine);
                createUser.createUser(user);
            }



        }

    }


}
