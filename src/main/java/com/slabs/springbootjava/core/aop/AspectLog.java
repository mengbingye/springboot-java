package com.slabs.springbootjava.core.aop;

import com.slabs.springbootjava.model.SystemLog;
import com.slabs.springbootjava.service.SystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @create: 2019/03/19 15:52
 */
@Aspect
@Component
public class AspectLog {

    private static final Logger logger = LoggerFactory.getLogger(AspectLog.class);

    @Resource
    private SystemLogService systemLogService;


    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.slabs.springbootjava.core.aop.Annotationlog)")
    public void methodCachePointcut() {

    }


    @Before("methodCachePointcut()")
    public void deBefore(JoinPoint point) {
//        SystemLog systemLog =
    }

}
