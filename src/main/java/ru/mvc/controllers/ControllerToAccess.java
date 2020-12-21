package ru.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mvc.forms.UserForm;
import ru.mvc.models.User;
import ru.mvc.repositories.ProductsRepository;
import ru.mvc.repositories.UsersRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 20.12.2020
 * ControllerToAccess
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Controller
public class ControllerToAccess {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String addUser(UserForm userForm) {
        if(!usersRepository.findAllByLogin(userForm.getLogin()).isEmpty()){
            httpSession.setAttribute("error","Login already exist");
            return "redirect:/error";
        }
        User newUser = User.from(userForm);
        usersRepository.save(newUser);
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(UserForm userForm) {
        List<User>result=usersRepository.findAllByLoginAndPassword(userForm.getLogin(),userForm.getPassword());
        if (!result.isEmpty()) {
            httpSession.setAttribute("person", result.get(0).getLogin());
        }
        else {
            httpSession.setAttribute("error","There is no such user in the system or the password is not correct");
            return "redirect:/error";
        }
        return "redirect:/";
    }
    @RequestMapping(path = "/exit", method = RequestMethod.GET)
    public String exit() {
        httpSession.removeAttribute("person");
        return "redirect:/";
    }
}
