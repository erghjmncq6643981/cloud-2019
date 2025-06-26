/*
 * chandler-spring-test
 * 2024/9/25 15:47
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.mapstruct;

import com.chandler.spring.test.mapstruct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2024/9/25 15:47
 * @version 1.0.0
 * @since 1.8
 */

@Mapper(componentModel = "spring")
public interface CovertUtil {
    CovertUtil INSTANCE =Mappers.getMapper(CovertUtil.class);

    @Mapping(source = "id",target = "java(Integer.valueOf(source.get('id')))")
    User getUser(Map<String,Object> data);
}
