package ru.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mvc.models.Product;
import ru.mvc.repositories.ProductsRepository;
import ru.mvc.repositories.UsersRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 20.12.2020
 * ControllerForProductList
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Controller
public class ControllerForProductList {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        List<Product> products = null;
        products = productsRepository.findAllByOrderByPriceDesc();
        if(products.size()!=0& products.size()<10){
           products = products.subList(0, products.size());
        }
        else if (products.size()>=10) {
            products = products.subList(0,10);
        }
        ModelAndView modelAndView = new ModelAndView();

        if (httpSession.getAttribute("person")==null||httpSession.getAttribute("person").equals("NUll")){
            httpSession.setAttribute("person", "NUll" );
            modelAndView.setViewName("index");
        }
        else{
            modelAndView.setViewName("users");
            modelAndView.addObject("user",httpSession.getAttribute("person"));
        }
        modelAndView.addObject("products", products);

        return modelAndView;
    }
    @RequestMapping(path = "/allProducts", method = RequestMethod.GET)
    public ModelAndView allProducts() {
        List<Product> products = null;
        products = productsRepository.findAllByOrderByPriceDesc();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allProducts");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @RequestMapping(path = "/myProducts", method = RequestMethod.GET)
    public ModelAndView myProducts() {
        List<Product> products = null;
        products = productsRepository.findAllBySeller_LoginOrderByPriceDesc((String) httpSession.getAttribute("person"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myProducts");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @RequestMapping(path = "/findProduct", method = RequestMethod.POST)
    public ModelAndView findProduct(String product) {
        List<Product> allProduct = productsRepository.findAllByProductOrderByPrice(product);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("allProducts");
        modelAndView.addObject("products",allProduct);
        return modelAndView;
    }
}
