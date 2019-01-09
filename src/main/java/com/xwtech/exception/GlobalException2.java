package com.xwtech.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过实现 HandlerExceptionResolver 接口做全局异常处理
 */
@Configuration
public class GlobalException2 implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {

		ModelAndView mv = new ModelAndView();
	
		if (ex instanceof NullPointerException) {
			mv.setViewName("nullPointerException");
		}
		if (ex instanceof ArithmeticException) {
			mv.setViewName("arithmeticException");
		}
		mv.addObject("error", ex.toString());
		return mv;

	}

}
