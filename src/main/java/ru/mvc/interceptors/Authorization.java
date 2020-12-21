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
 * Authorization
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Component
public class Authorization  implements HandlerInterceptor {

    @Autowired
    HttpSession httpSession;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        if (httpSession.getAttribute("person")==null||httpSession.getAttribute("person").equals("NUll")){
            httpSession.setAttribute("error","You are not authorized to do this");
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