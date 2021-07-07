/*
 * chandler-feign-client
 * 6/26/21 10:21 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.feign.client.example.groovy;

import java.util.List;

/**
 * 接口功能描述
 *
 * @author 钱丁君-chandler 6/26/21 10:21 AM
 * @version 1.0
 * @since 1.8
 */
public interface IRoute {
    /**
     * 路由测试
     * @param serviceId
     * @return
     */
    String route(String serviceId);

    String routeList(String serviceId, List<String> nodes);
}
