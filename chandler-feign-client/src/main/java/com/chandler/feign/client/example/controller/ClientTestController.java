/*
 * chandler-feign-client
 * 2019/5/17 下午4:33
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.feign.client.example.controller;

import com.chandler.feign.client.example.entity.Person;
import com.chandler.feign.client.example.inter.FeignClientExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/5/17下午4:33
 * @since 1.8
 */
@RestController
public class ClientTestController implements FeignClientExample {

    @Autowired
    private FeignClientExample client;

    @Override
    public String getHost(String name) {
        return client.getHost(name);
    }

    @Override
    public Person postPerson(String name) {
        return client.postPerson(name);
    }

    @Override
    public Person postPerson(Person person) {
        return client.postPerson(person);
    }

    @Override
    public String getHost(String name, int age) {
        return client.getHost(name,age);
    }
}
