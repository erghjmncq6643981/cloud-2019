/*
 * chandler-spring-core
 * 2019/10/22 6:02 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.core.example.autoconfigure;

import com.chandler.spring.core.example.annotation.AspectTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopProxyUtils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * BeanPostProcessor扩展，代理工具应用
 *
 * @author 钱丁君-chandler 2019/10/226:02 PM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("postProcessBeforeInitialization..."+beanName+"..."+bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> target = AopProxyUtils.ultimateTargetClass(bean);
        Class<?> targetClass = (Proxy.isProxyClass(target) || ClassUtils.isCglibProxyClass(target)) ? (Class<?>) target.getGenericSuperclass() : target;
        ReflectionUtils.doWithMethods(targetClass, (m) -> {
            AspectTest aspect = m.getAnnotation(AspectTest.class);
            System.out.println("AspectTest的value值为：" + aspect.value());
            log.info("AspectTest的value值为：[{}] ; params: [{}]", aspect.value(), m.getParameters().toString());
        }, (m) -> m.isAnnotationPresent(AspectTest.class));
        return bean;
    }
}
