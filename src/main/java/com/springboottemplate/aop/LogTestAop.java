package com.springboottemplate.aop;

import com.springboottemplate.annontation.LogTestAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @description:
 * @author: ttao
 * @create: 2020-12-22 23:05
 **/
@Aspect
@Component
public class LogTestAop {


    private Logger logger = LoggerFactory.getLogger(LogTestAop.class);

    //切入点
    @Pointcut("execution(* com.springboottemplate.controller..*.*(..))")
    private void poincut() {

    }

    /**
     * Signature getSignature();	获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
     * Object[] getArgs();	获取传入目标方法的参数对象
     * Object getTarget();	获取被代理的对象
     * Object getThis();	获取代理对象
     * @param joinPoint
     */
    //配置切面
    @Before("poincut()")
    public void  advice(JoinPoint joinPoint){
        logger.info(joinPoint.toString());
        Class<?> aClass = joinPoint.getTarget().getClass();
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogTestAnno.class)){
                LogTestAnno annotation = method.getAnnotation(LogTestAnno.class);
                logger.info("注解LogTestAnno生效了，生效类名："+aClass .getSimpleName()+"  方法名："+method.getName()+"  注解得值:"+annotation.name());
            }

        }

    }

}
