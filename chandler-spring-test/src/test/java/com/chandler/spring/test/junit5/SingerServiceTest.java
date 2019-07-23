/*
 * SingerServiceTest.java
 * 2019年7月23日 上午10:07:38
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.chandler.spring.test.config.DataConfig;
import com.chandler.spring.test.config.ServiceConfig;
import com.chandler.spring.test.entities.Singer;
import com.chandler.spring.test.junit5.config.SimpleTestConfig;
import com.chandler.spring.test.services.SingerService;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月23日上午10:07:38
 * @since 1.8
 */
@SpringJUnitConfig(classes = { SimpleTestConfig.class, ServiceConfig.class, DataConfig.class })
@DisplayName("Integration SingerService Test")
@ActiveProfiles("test")
public class SingerServiceTest {
	private static Logger logger = LoggerFactory.getLogger(SingerServiceTest.class);
	@Autowired
	SingerService singerService;

	@BeforeAll
	static void setUp() {
		logger.info("--> @BeforeAll - executes before executing all test methods in this class");
	}

	@AfterAll
	static void tearDown() {
		logger.info("--> @AfterAll - executes before executing all test methods in this class");
	}

	@BeforeEach
	void init() {
		logger.info("--> @BeforeEach - executes before each test method in this class");
	}

	@AfterEach
	void dispose() {
		logger.info("--> @AfterEach - executes after each test method in this class");
	}

	@Test
	@DisplayName("should return all singers")
	@SqlGroup({
			@Sql(value = "classpath:db/test-data.sql", config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
			@Sql(value = "classpath:db/clean-up.sql", config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD), })
	public void findAll() {
		List<Singer> result = singerService.findAll();
		logger.info("List<Singer>:[{}]", result.toString());
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	@DisplayName("should return singer 'John Mayer'")
	@SqlGroup({
			@Sql(value = "classpath:db/test-data.sql", config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
			@Sql(value = "classpath:db/clean-up.sql", config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD), })
	public void testFindByFirstNameAndLastNameOne() throws Exception {
		Singer result = singerService.findByFirstNameAndLastName("John", "Mayer");
		logger.info("List<Singer>:[{}]", result.toString());
		assertNotNull(result);
	}
}
