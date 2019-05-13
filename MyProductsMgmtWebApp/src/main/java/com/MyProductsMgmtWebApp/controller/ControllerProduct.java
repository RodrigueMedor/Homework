package com.MyProductsMgmtWebApp.controller;

import javax.validation.Valid;

import com.MyProductsMgmtWebApp.ServicesProduct.ProductServices;
import com.MyProductsMgmtWebApp.model.Product;
import com.MyProductsMgmtWebApp.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerProduct {

    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/magazine/product/list")
    public ModelAndView listtProduct() {
        ModelAndView view = new ModelAndView();
        view.addObject("products", productServices.getAllProduct());

        view.setViewName("product/list");

        return view;
    }
    @GetMapping(value = "/magazine/product/list/addProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/addProduct";
    }
    @RequestMapping(value = "/magazine/product/list/addProduct",method = RequestMethod.POST)
    public String saveProduct(@Valid Product  product, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            System.out.println("has errors");
            return "product/addProduct";
        }
        productServices.addProduct(product);

        return "redirect:/magazine/product/list";
    }
    @GetMapping(value = "/magazine/product/edit/{id}")
    public String modifyProduct(@PathVariable("id")Integer id, Model model){
        model.addAttribute("product", productRepository.findById(id));
        return "product/addProduct";
    }
    @PostMapping(value = "/magazine/product/delete/{prodID}")
    public String deleteProduct(@PathVariable("prodID")Integer id){
        productRepository.deleteById(id);
        productServices.deleteProduct(id);
        return "redirect:/magazine/product/list";
    }

}