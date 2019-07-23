/*
 * chandler-spring-test
 * 2019/7/23 下午3:42
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
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/7/23下午3:42
 * @since 1.8
 */
public class MethodSourceExampleTest {
    @ParameterizedTest
    @MethodSource("stringGenerator")
    void shouldNotBeNullString(String arg){
        assertNotNull(arg);
    }

    @ParameterizedTest
    @MethodSource("intGenerator")
    void shouldBeNumberWithinRange(int arg){
        assertAll(
                () -> assertTrue(arg > 0),
                () -> assertTrue(arg <= 10)
        );
    }

    @ParameterizedTest(name = "[{index}] user with id: {0} and name: {1}")
    @MethodSource("userGenerator")
    void shouldUserWithIdAndName(long id, String name){
        assertNotNull(id);
        assertNotNull(name);
    }

    static Stream<String> stringGenerator(){
        return Stream.of("hello", "world", "let's", "test");
    }

    static IntStream intGenerator() {
        return IntStream.range(1,10);
    }

    static Stream<Arguments> userGenerator(){
        return Stream.of(Arguments.of(1L, "Sally"), Arguments.of(2L, "Terry"), Arguments.of(3L, "Fred"));
    }
}
