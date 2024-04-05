package com.yefeng.utils;

/**
 * @author 叶枫
 * @version 1.0.0
 * @create 2023/10/25 15:23
 */


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用aop进行token校验
 * @author yefeng
 */
@Aspect
@Component
@Slf4j
public class TokenVerificationAop {
    /**
     * 登录路径 ->放行
     */
    private static final String LOGIN = "login";

    /**
     * @Pointcut 声明切入点表达式。
     * 注意此处扫描的是你的Controller层接口位置
     */
    @Pointcut("execution(public * com.yefeng.controller..*..*(..))")
    public void pointcut() {
    }

    /**
     * @Around 环绕通知
     * @Around("pointcut()") 可以理解为对这个方法进行环绕通知
     * ProceedingJoinPoint 参数 用于环绕通知，
     * 使用proceed()方法来执行目标方法，可以理解为 前置通知结束 开始执行使用该注解的方法。
     */
    @Around("pointcut()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // assert 是判断然后报异常的, 符合条件继续往下进行
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("Authorization");
        if (request.getRequestURI().contains(LOGIN)) {
            //执行业务逻辑，放行
            return joinPoint.proceed();
        }
        if (StringUtils.isNotBlank(token)) {
            try {
                String key = "yefeng";
                JWT jwt = JWTUtil.parseToken(token);
                boolean verify = jwt.setKey(key.getBytes()).verify();
                System.out.println(verify);
                boolean verifyTime = jwt.validate(0);
                System.out.println(verifyTime);
                if (!verify) {
                    return "token 有误";
                }
            } catch (Exception e) {
                // 解析jwt令牌出错, 说明令牌过期或者伪造等不合法情况出现 401
                log.info("AuthorizeFilter  解析jwt令牌出错", e);
                //此处可以返回自定义 Result结果对象 转成Json格式
                throw new Exception("解析jwt令牌出错");
            }
        } else {
            log.info("AuthorizeFilter  登录令牌不存在");
            throw new Exception("登录令牌不存在");
        }
        //执行业务逻辑，放行
        return joinPoint.proceed();
    }
}
