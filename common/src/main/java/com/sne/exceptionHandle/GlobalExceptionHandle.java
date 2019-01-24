package com.sne.exceptionHandle;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yan liang
 * @create 2019/1/23
 * @since 1.0.0
 */
public class GlobalExceptionHandle implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//        httpServletResponse.setStatus(500);
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        try {
//            httpServletResponse.getWriter().write(e.getMessage());
//            httpServletResponse.getWriter().flush();
//        } catch (IOException e1) {
//
//        }
        return new ModelAndView("error");
    }
}