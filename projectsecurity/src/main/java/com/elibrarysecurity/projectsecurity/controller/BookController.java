package com.elibrarysecurity.projectsecurity.controller;



import com.elibrarysecurity.projectsecurity.model.Book;
import com.elibrarysecurity.projectsecurity.model.BookCopy;
import com.elibrarysecurity.projectsecurity.model.Category;
import com.elibrarysecurity.projectsecurity.model.Position;
import com.elibrarysecurity.projectsecurity.service.IBookCopyService;
import com.elibrarysecurity.projectsecurity.service.IBookService;
import com.elibrarysecurity.projectsecurity.service.ICategoryService;
import com.elibrarysecurity.projectsecurity.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/eLibraryFinal/secure/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IBookCopyService bookCopyService;


    @GetMapping(value = "/eLibraryFinal/secure/book/browse")
    public ModelAndView displayListOfBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getListOfBook();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("secure/book/browse");
        return modelAndView;
    }

    @GetMapping(value = "/eLibraryFinal/secure/book/new")
    public String newBookForm(Model model) {

        List<Category> categories = categoryService.getAllCategories();

        List<Position> positions = positionService.getAllPositions();

        model.addAttribute("book", new Book());

        model.addAttribute("categories", categories);

        model.addAttribute("positions", positions);

        return "secure/book/new";
    }

    @PostMapping(value = "eLibraryFinal/secure/book/new")
    public String addNewBook(@Valid @ModelAttribute("book") Book book,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Category> categories = categoryService.getAllCategories();

            List<Position> positions = positionService.getAllPositions();
            model.addAttribute("categories", categories);

            model.addAttribute("positions", positions);
            return "secure/book/new";
        }
        book = bookService.addBook(book);
        for(long i = 1; i<= book.getNumOfCopies(); i++){
            Long bookCopyNumber =  (book.getBookNumber() * 10) + i;
            BookCopy bookCopy = new BookCopy(bookCopyNumber, book);
            bookCopyService.add(bookCopy);
        }
        return "redirect:/eLibraryFinal/secure/book/browse";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("edit") Book book,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "secure/book/edit";
        }

        book = bookService.addBook(book);
        return "redirect:/eLibraryFinal/secure/book/browse";

    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findOneBook(id));
        return "secure/book/edit";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        bookService.removeBook(id);
        return "redirect:/eLibraryFinal/secure/book/browse";
    }
//    @GetMapping(value = "/browseoverdue")
//    public ModelAndView displayListOOverduefBooks() {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Book> books = bookService.getListOfBook();
//
//        modelAndView.addObject("books", books);
//        modelAndView.setViewName("secured/book/browseoverdue");
//        return modelAndView;
//    }



    @GetMapping(value = "/search")
    public ModelAndView displayListSearchedBooks(@RequestParam(value = "search", required = false) String q, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getListOfBook().stream()
                .filter(x -> x.getTitle().equals(q))
                .collect(Collectors.toList());
        modelAndView.addObject("books", books);
        modelAndView.setViewName("secure/book/browse");
        return modelAndView;
    }




}
