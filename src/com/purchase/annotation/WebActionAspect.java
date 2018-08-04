package com.purchase.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 *实现Web层的日志切面
 */
@Aspect
@Order(10)
@Component
public class WebActionAspect {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long>startTime =new ThreadLocal<Long>();

    /**
     *定义一个切入点.
     * 匹配任意数量的参数.
     */
    @Pointcut("execution(public * com.purchase.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){

        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        try {
            HttpServletRequest request = attributes.getRequest();

            // 接收到请求，记录请求内容
            logger.info("------------------------------请求开始");

            // 记录下请求内容
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());
            logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
//            logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
            //获取所有参数：
            Enumeration<String> enu=request.getParameterNames();
            Map<String,Object> pars = new HashMap<>();
            while(enu.hasMoreElements()){
                String paraName=(String)enu.nextElement();
                pars.put(paraName,request.getParameter(paraName));
            }
            logger.info("PARS : " + pars.toString());
        }catch (Exception e){
        }
    }

    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint){
        // 处理完请求，返回内容
        logger.info("------------------------------请求结束，共计耗时（毫秒） : " + (System.currentTimeMillis()-startTime.get()));

    }

}
