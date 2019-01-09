package com.xwtech.bit.api.aop;

import com.xwtech.pojo.Log;
import com.xwtech.service.LogService;
import groovy.util.logging.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspect {

        @Autowired
        private LogService logService;

        @Pointcut("execution(public * com.xwtech..*.*(..))")
        public void webLog(){}

        @Before("webLog()")
        public void doBefore(JoinPoint joinPoint) throws  Throwable{
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Log log = new Log();
            String uri = request.getRequestURI();
            String method = request.getMethod();
            String remoteAddr = request.getRemoteAddr();
            String typeName = joinPoint.getSignature().getDeclaringTypeName();
            long timeMillis = System.currentTimeMillis();
            log.setUri(uri);
            log.setMethod(method);
            log.setRemoteAddr(remoteAddr);
            log.setTypeName(typeName);
            log.setTimeMillis(timeMillis);
            logService.saveLog(log);
        }

        @AfterReturning(returning = "ret",pointcut = "webLog()")
        public void doAftering(Object ret) throws Throwable{

        }
}
