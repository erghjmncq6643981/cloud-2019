/*
 * chandler-spring-webflux
 * 2020/1/19 11:40 AM
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.webflux.example.generator;

import com.chandler.spring.webflux.example.entity.Good;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2020/1/19 11:40 AM
 * @version 1.0.0
 * @since 1.8
 */
@Configuration
public class GoodGenerator {

    public Flux<Good> findGoods() {
        List<Good> goods = new ArrayList<>();
        goods.add(new Good(1, "小米", "2000"));
        goods.add(new Good(2, "华为", "4000"));
        goods.add(new Good(3, "苹果", "8000"));
        return Flux.fromIterable(goods);
    }
}
