/*
 * SimpleTestConfig.java
 * 2019年7月23日 上午10:08:15
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.junit5.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.chandler.spring.test.init.DBInitializer;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月23日上午10:08:15
 * @since 1.8
 */
@Configuration
@ComponentScan(basePackages = { "com.chandler.spring.test" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DBInitializer.class) })
@Profile("test")
public class SimpleTestConfig {
	private static Logger logger = LoggerFactory.getLogger(SimpleTestConfig.class);

	@Bean
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
			return dbBuilder.setType(EmbeddedDatabaseType.H2).build();
		} catch (Exception e) {
			logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
		}
	}
}
