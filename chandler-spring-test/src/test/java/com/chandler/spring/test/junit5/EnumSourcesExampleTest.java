/*
 * chandler-spring-test
 * 2019/7/23 下午3:06
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
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

/**
 * 类功能描述
 *
 * @author 钱丁君-chandler 2019/7/23下午3:06
 * @since 1.8
 */
public class EnumSourcesExampleTest {
    @ParameterizedTest(name = "[{index}] TimeUnit: {arguments}")
    @EnumSource(TimeUnit.class)
    void testTimeUnitMinimumNanos(TimeUnit unit) {
        assertTrue(unit.toMillis(2000000L) > 1);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
    void testTimeUnitJustSecondsAndMinutes(TimeUnit unit) {
        assertTrue(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
        assertFalse(EnumSet
                .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = Mode.EXCLUDE, names = {"SECONDS", "MINUTES"})
    void testTimeUnitExcludingSecondsAndMinutes(TimeUnit unit) {
        assertFalse(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
        assertTrue(EnumSet
                .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = Mode.MATCH_ALL, names = ".*SECONDS")
    void testTimeUnitIncludingAllTypesOfSecond(TimeUnit unit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES).contains(unit));
        assertTrue(EnumSet
                .of(TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }
}
