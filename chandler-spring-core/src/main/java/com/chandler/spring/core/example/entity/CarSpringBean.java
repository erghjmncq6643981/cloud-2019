/*
 * chandler-spring-core
 * 2019/10/22 5:55 PM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.core.example.entity;

import com.chandler.spring.core.example.annotation.AspectTest;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring生命周期测试-实例对象
 *
 * @author 钱丁君-chandler 2019/10/225:55 PM
 * @version 1.0.0
 * @since 1.8
 */
public class CarSpringBean implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,
        InitializingBean,DisposableBean {
    //Seat是一个简单的bean对象
    private Seat seat;

    public CarSpringBean(){
        System.out.println("car instance...");
    }

    public Seat getSeat() {
        return seat;
    }

    @Autowired
    public void setSeat(Seat seat) {
        System.out.println("填充属性");
        this.seat = seat;
    }

    /**
     * 自定义的初始化方法
     */
    public void init(){
        System.out.println("car ... init...");
    }

    /**
     * 自定义的销毁方法
     */
    public void detory(){
        System.out.println("car ... detory...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("bean的名称："+s);
        System.out.println("BeanNameAware...setBeanName()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("DisposableBean...setBeanFactory()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware...setApplicationContext()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean...afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitializingBean...destroy()");
    }

    @AspectTest("aspect")
    public String aspect(String name, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age+"");
        person.setSex("man");
        return person.toString();
    }
}
