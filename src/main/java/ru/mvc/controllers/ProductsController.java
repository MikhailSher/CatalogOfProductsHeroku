package ru.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mvc.models.Product;
import ru.mvc.repositories.ProductsRepository;
import ru.mvc.repositories.UsersRepository;

import javax.servlet.http.HttpSession;


/**
 * 20.12.2020
 * ProductsController
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Controller
public class ProductsController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(path = "/changePrice", method = RequestMethod.POST)
    public String changeScore(long id,String price) {
        Product product = productsRepository.findProductById(id);
        if (price.equals("+")){
            product.setPrice(product.getPrice()+1);
        }
        else{
            product.setPrice(product.getPrice()-1);
        }
        if(product.getPrice()<0){
             httpSession.setAttribute("error","You cannot make the price less than zero");
                 return "redirect:/error";
             }

        productsRepository.save(product);
        return "redirect:/myProducts";
    }
    @RequestMapping(path = "/saveProducts", method = RequestMethod.POST)
    public String saveProduct(String product,String description,HttpSession httpSession) {
        Product newProduct =new Product();
        newProduct.setPrice(0);
        newProduct.setProduct(product);
        newProduct.setDescription(description);
        newProduct.setSeller(usersRepository.findAllByLogin((String)httpSession.getAttribute("person")).get(0));
        productsRepository.save(newProduct);
        return "redirect:/myProducts";
    }
    @RequestMapping(path = "/changeDescription", method = RequestMethod.POST)
    public String changeDescription(String id,String description) {
        Product newProduct = productsRepository.findProductById(Integer.parseInt(id));
        newProduct.setDescription(description);
        productsRepository.save(newProduct);
        return "redirect:/myProducts";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id") String id) {
        productsRepository.delete((long) Integer.parseInt(id));
        return "redirect:/myProducts";
    }

}
