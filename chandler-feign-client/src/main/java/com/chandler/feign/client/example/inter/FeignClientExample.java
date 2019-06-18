/*
 * chandler-feign-client
 * 2019/5/17 下午4:28
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.feign.client.example.inter;

import com.chandler.feign.client.example.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/5/17下午4:28
 * @since 1.8
 */
//@FeignClient(value = "service-instance-peer")
@FeignClient(name="${feign.server.name}")
public interface FeignClientExample {
    @RequestMapping(value = "/frist/demo/getHost", method = RequestMethod.GET, produces = "application/json")
    public String getHost(@RequestParam("name") String name);

    @RequestMapping(value = "/frist/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestParam("name") String name);

    @RequestMapping(value = "/frist/body/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Person postPerson(@RequestBody Person person);

    @RequestMapping(value = "/frist/head/getHost", method = RequestMethod.GET, produces = "application/json")
    public String getHost(@RequestParam("name") String name, @RequestHeader("age") int age);
}
