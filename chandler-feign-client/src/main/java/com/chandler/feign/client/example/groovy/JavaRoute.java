/*
 * chandler-feign-client
 * 6/26/21 10:33 AM
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
 * 类功能描述
 *
 * @author 钱丁君-chandler 6/26/21 10:33 AM
 * @version 1.0
 * @since 1.8
 */
public class JavaRoute
        implements IRoute {
    @Override
    public String route(String serviceId) {
        return "hello:" + serviceId;
    }

    @Override
    public String routeList(String serviceId,
                            List<String> nodes) {
        int len = 0;
        for (int i = 0; i < nodes.size(); i++) {
            len += nodes.get(i).length();
        }
        return "hello:" + serviceId + len;
    }
}
