/*
 * chandler-spring-core
 * 2019/10/23 11:54 AM
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

import com.chandler.spring.core.example.entity.CarSpringBean;
import com.chandler.spring.core.example.entity.Person;
import com.chandler.spring.core.example.entity.Seat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportBeanDefinitionRegistrar的实现-支持bean创建、动态参数注入、注入到spring容器注册列表
 *
 * @author 钱丁君-chandler 2019/10/2311:54 AM
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 构建RootBeanDefinition
        RootBeanDefinition beanDefinition = buildRootBeanDefinition(Person.class);
        // 将CarSpringBean注入到Person的参数car中
        beanDefinition.getPropertyValues().addPropertyValue("car", new RuntimeBeanReference("car"));
        // 获取beanName
        String beanName = BeanDefinitionReaderUtils.generateBeanName(beanDefinition, registry);
        log.info("class: [{}], beanName: [{}]", Person.class.toString(),beanName);
        // 将Person注册到Person
        registerComponent(registry, beanDefinition, beanName);
    }

    private RootBeanDefinition buildRootBeanDefinition(Class<?> beanType) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setRole(BeanDefinition.ROLE_APPLICATION);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanDefinition.setBeanClass(beanType);
        beanDefinition.setLazyInit(false);
        beanDefinition.setDependencyCheck(RootBeanDefinition.DEPENDENCY_CHECK_NONE);
        beanDefinition.setAutowireCandidate(true);
        beanDefinition.setAutowireMode(RootBeanDefinition.AUTOWIRE_BY_NAME);
        return beanDefinition;
    }

    private void registerComponent(BeanDefinitionRegistry registry, RootBeanDefinition beanDefinition, String beanName) {
        BeanDefinitionHolder beanholder = new BeanDefinitionHolder(beanDefinition, beanName);
        BeanDefinitionReaderUtils.registerBeanDefinition(beanholder, registry);
    }
}
