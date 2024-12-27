package com.kkk.aspect;

import com.kkk.annotation.GlobalInterceptor;
import com.kkk.enums.ResponseCodeEnum;
import com.kkk.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component("operationAspect")
@Aspect
public class GlobalOperationAspect {


    @Resource
    private RedisTemplate<String,String> redisTemplate;

    private static Logger logger = LoggerFactory.getLogger(GlobalOperationAspect.class);


    @Before("@annotation(com.kkk.annotation.GlobalInterceptor)")
    public void interceptorDo(JoinPoint point) {
        try {
            Method method = ((MethodSignature) point.getSignature()).getMethod();
            GlobalInterceptor interceptor = method.getAnnotation(GlobalInterceptor.class);
            if (null == interceptor) {
                return;
            }
            /**
             * 校验登录
             */
            if (interceptor.checkLogin() || interceptor.checkAdmin()) {
                checkLogin(interceptor.checkAdmin());
            }
        } catch (BusinessException e) {
            logger.error("全局拦截器异常", e);
            throw e;
        } catch (Exception e) {
            logger.error("全局拦截器异常", e);
            throw new BusinessException(ResponseCodeEnum.CODE_500);
        } catch (Throwable e) {
            logger.error("全局拦截器异常", e);
            throw new BusinessException(ResponseCodeEnum.CODE_500);
        }
    }

    //校验登录
    private void checkLogin(Boolean checkAdmin) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String value = redisTemplate.opsForValue().get("loginDemo:user:token:"+token);
        if (value == null) {
            throw new RuntimeException("登录超时");
        }
        Long userId = Long.valueOf(value);
        if (checkAdmin) {
            // 校验是否为管理员操作权限
            // 后续处理
        }
    }
}