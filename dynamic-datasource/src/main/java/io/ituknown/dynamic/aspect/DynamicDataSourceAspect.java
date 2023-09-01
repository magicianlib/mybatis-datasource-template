package io.ituknown.dynamic.aspect;

import io.ituknown.dynamic.config.DataSource;
import io.ituknown.dynamic.config.DataSourceContextHolder;
import io.ituknown.dynamic.config.DataSourceType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 动态数据源 AOP
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @date 2022/06/16 15:25
 */
@Aspect
@Component
public class DynamicDataSourceAspect implements Ordered {

    @Around("execution(* io.ituknown.dynamic.service.*Service.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {

            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

            Method method = methodSignature.getMethod();

            DataSource dataSource = AnnotationUtils.getAnnotation(method, DataSource.class);

            // default use master databases
            if (dataSource == null || DataSourceType.MASTER == dataSource.type()) {
                DataSourceContextHolder.useMaster();
            } else {
                DataSourceContextHolder.useSlave();
            }

            return joinPoint.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}
