package ru.mvc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 20.12.2020
 * AuthorizationAlready
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Component
public class AuthorizationAlready implements HandlerInterceptor {

    @Autowired
    HttpSession httpSession;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        if(httpServletRequest.getParameter("login").isEmpty()||httpServletRequest.getParameter("password").isEmpty()){
            httpSession.setAttribute("error","Login/password entry error! Try again");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/error");
            return  false;
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