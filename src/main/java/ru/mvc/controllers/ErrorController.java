package ru.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.mvc.repositories.ProductsRepository;
import ru.mvc.repositories.UsersRepository;

import javax.servlet.http.HttpSession;

/**
 * 20.12.2020
 * ErrorController
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Controller
public class ErrorController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public ModelAndView error() {
        httpSession.getAttribute("error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", httpSession.getAttribute("error"));
        return modelAndView;
    }
}
