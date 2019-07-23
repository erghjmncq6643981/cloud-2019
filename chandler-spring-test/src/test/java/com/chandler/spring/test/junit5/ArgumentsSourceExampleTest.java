/*
 * chandler-spring-test
 * 2019/7/23 下午3:51
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

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/7/23下午3:51
 * @since 1.8
 */
public class ArgumentsSourceExampleTest {
    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsGenerator.class)
    void testGeneratedArguments(double number) throws Exception {
        assertFalse(number == 0.D);
        assertTrue(number > 0);
        assertTrue(number < 1);
    }

    static class CustomArgumentsGenerator implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
                    .map(Arguments::of);
        }
    }
}
