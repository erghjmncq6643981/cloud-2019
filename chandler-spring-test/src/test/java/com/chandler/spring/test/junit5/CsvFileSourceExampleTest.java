/*
 * chandler-spring-test
 * 2019/7/23 下午4:22
 *
 * Please contact chandler
 * if you need additional information or have any questions.
 * Please contact chandler Corporation or visit:
 * https://www.jianshu.com/u/117796446366
 *
 * @author 钱丁君-chandler
 * @version 1.0
 */
package com.chandler.spring.test.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/7/23下午4:22
 * @since 1.8
 */
public class CsvFileSourceExampleTest {
    Map<Long, String> idToUsername = new HashMap<>();

    {
        idToUsername.put(1L, "Selma");
        idToUsername.put(2L, "Lisa");
        idToUsername.put(3L, "Tim");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/junit5/users.csv")
    void testUsersFromCsv(long id, String name) {
        assertTrue(idToUsername.containsKey(id));
        assertTrue(idToUsername.get(id).equals(name));
    }
}
