package ru.mvc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.mvc.repositories.ProductsRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 20.12.2020
 * FindProduct
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Component
public class FindProduct implements HandlerInterceptor {
    @Autowired
    HttpSession httpSession;
    @Autowired
    ProductsRepository productsRepository;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String product=httpServletRequest.getParameter("product");
        if (product == null |productsRepository.findAllByProduct(product).isEmpty()){
            httpSession.setAttribute("error","There is no such product in the database or you have not entered anything");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/error");
            return false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}