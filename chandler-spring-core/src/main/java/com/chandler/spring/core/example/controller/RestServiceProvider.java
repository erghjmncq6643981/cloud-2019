package com.chandler.spring.core.example.controller;

import com.chandler.spring.core.example.entity.CarSpringBean;
import com.chandler.spring.core.example.entity.Person;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CarSpringBean car;

    @Autowired
    private Person person;

    /**
     * @param name
     * @return Person
     * @Description: post接口
     * @create date 2018年5月19日上午9:44:08
     */
    @ApiOperation(value = "post请求测试")
    @RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public String postPerson(@ApiParam(value = "姓名", required = true, defaultValue = "chandler") @RequestParam("name") String name,
                             @ApiParam(value = "年龄", required = true, defaultValue = "18", example="18") @RequestParam("age") Integer age) {
        return car.aspect(name,age);
    }

    /**
     * @param personRes
     * @return Person
     * @Description: post接口
     * @create date 2018年6月27日下午5:50:56
     */
    @RequestMapping(value = "/body/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestBody Person personRes) {
        person.setName(personRes.getName());
        person.setAge(personRes.getAge());
        person.setSex(personRes.getSex());
        return person;
    }

}
