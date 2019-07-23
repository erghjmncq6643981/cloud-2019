/*
 * chandler-spring-test
 * 2019/7/23 下午2:21
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
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/7/23下午2:21
 * @since 1.8
 */
public class ValueSourcesExampleTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void testNumberShouldBeEven(int num) {
        assertEquals(0, num % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Radar", "Rotor", "Tenet", "Madam", "Racecar"})
    void testStringShouldBePalindrome(String word) {
        assertEquals(isPalindrome(word), true);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.D, 4.D, 8.D})
    void testDoubleNumberBeEven(double num) {
        assertEquals(0, num % 2);
    }

    boolean isPalindrome(String word) {
        return word.toLowerCase().equals(new StringBuffer(word.toLowerCase()).reverse().toString());
    }
}
