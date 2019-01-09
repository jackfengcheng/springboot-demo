package com.xwtech.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException1 {
	/**
	 * * java.lang.ArithmeticException * 该方法需要返回一个
	 * ModelAndView：目的是可以让我们封装异常信息以及视 图的指定 参数 Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value = { java.lang.ArithmeticException.class })
	public ModelAndView arithmeticExceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("arithmeticException");
		return mv;
	}

	/**
	 * * java.lang.NullPointerException * 该方法需要返回一个
	 * ModelAndView：目的是可以让我们封装异常信息以及视 图的指定 参数 Exception e:会将产生异常对象注入到方法中
	 */
	@ExceptionHandler(value = { java.lang.NullPointerException.class })
	public ModelAndView nullPointerExceptionHandler(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("nullPointerException");
		return mv;
	}

}
