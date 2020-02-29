package com.chandler.instance.client.example.controller;

import com.chandler.instance.client.example.aspect.*;
import com.chandler.instance.client.example.entity.Person;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * restful风格的接口
 *
 * @author 钱丁君-chandler 2019/5/17下午2:00
 * @since 1.8
 */
@Api( tags = "服务调用者Demo接口")
@RestController
public class RestServiceProvider {

    @Value("${server.port}")
    private String port;

    /**
     * @param name
     * @return Person
     * @Description: post接口
     * @create date 2018年5月19日上午9:44:08
     */
    @ApiOperation(value = "post请求测试")
    @PrometheusAsepect(value = "", mertics = {
            @Metric(value = "httpin_req_total", type = MetricType.counter, labels = {
                    @Label(name = "listCount", value = "listCount")
            }),
            @Metric(value = "httpin_duration_tinme", type = MetricType.timer, labels = {
                    @Label(name = "env", value = "test")
            })
    })
    @RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@ApiParam(value = "姓名", required = true, defaultValue = "chandler") @RequestParam("name") @MetricSuffix String name) {
        Person person = new Person();
        person.setName(name);
        person.setAge("10");
        person.setSex("man");
        return person;
    }

    /**
     * @param person
     * @return Person
     * @Description: post接口
     * @create date 2018年6月27日下午5:50:56
     */
    @RequestMapping(value = "/body/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestBody Person person) {
        person.setName("kyle");
        person.setAge("10");
        person.setSex("man");
        return person;
    }

}
