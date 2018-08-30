package com.huhan.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author huhan
 * @data 2018/8/20
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 配置一个切面
     * @author huhan
     * @data 2018/8/20
     */
    @Pointcut("execution(* com.huhan.blog.web.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint point) {
        // 获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取请求的url, ip, classMethod, args
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        Object[] args = point.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);

        logger.info("***************请求记录**************");
        logger.info("请求记录信息: {}", requestLog);
    }

    @After("log()")
    public void doAfter() {
//        logger.info("----------doAfter------------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("***************响应结果***************");
        logger.info("Result: {}", result);
    }

    /**
     * 请求记录的内部类
     * @author huhan
     * @data 2018/8/20
     */
    private class RequestLog {
        /**
         * 请求url
         **/
        private String url;
        /**
         * 请求者的ip
         **/
        private String ip;
        /**
         * 请求方法名
         **/
        private String classMethod;
        /**
         * 请求的参数列表
         **/
        private Object[] args;

        public RequestLog() {
        }

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "请求地址='" + url + '\'' +
                    ", 请求的ip='" + ip + '\'' +
                    ", 请求类中的方法='" + classMethod + '\'' +
                    ", 请求参数=" + Arrays.toString(args) +
                    '}';
        }
    }
}
