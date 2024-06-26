package com.yefeng.aop;

import com.yefeng.database.DBContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: 叶枫
 * @Date: 2024/06/16/20:41
 * @Description: 切面类DataSourceAop
 */
@Aspect
@Component
@Slf4j
public class DataSourceAop {
    @Pointcut("@annotation(com.yefeng.annotation.Master) " +
            "|| execution(* com.yefeng.service..*.insert*(..)) " +
            "|| execution(* com.yefeng.service..*.create*(..)) " +
            "|| execution(* com.yefeng.service..*.save*(..)) " +
            "|| execution(* com.yefeng.service..*.add*(..)) " +
            "|| execution(* com.yefeng.service..*.update*(..)) " +
            "|| execution(* com.yefeng.service..*.edit*(..)) " +
            "|| execution(* com.yefeng.service..*.delete*(..)) " +
            "|| execution(* com.yefeng.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Pointcut("!@annotation(com.yefeng.annotation.Master) " +
            "&& (execution(* com.yefeng.service..*.select*(..)) " +
            "|| execution(* com.yefeng.service..*.get*(..)))" +
            "|| execution(* com.yefeng.service..*.query*(..)))")
    public void readPointcut() {

    }

    @Before("writePointcut()")
    public void write() {
        log.info("切换到master进行写入");
        DBContext.master();
    }

    @Before("readPointcut()")
    public void read() {
        log.info("切换到slave进行读取");
        DBContext.slave();
    }

    @After("readPointcut()")
    public Object read1(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("read1.getArgs() = {}", joinPoint.getArgs());
        Object[] args = joinPoint.getArgs();
        log.info("read1.getTarget() = {}", joinPoint.getTarget());
        log.info("read1.getArgs() = {}", joinPoint.proceed());
        if (args == null) {
            log.info("No data");
            return null;
        }
        for (Object arg : args) {
            log.info("arg = {}", arg);
        }
        return null;
    }
}
