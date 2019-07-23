/*
 * DataConfig.java
 * 2019年7月18日 下午4:50:25
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * 类功能描述
 * @version   
 * @author 钱丁君-chandler 2019年7月18日下午4:50:25
 * @since 1.8
 */
@Profile("dev")
@Configuration
@ComponentScan(basePackages  = {"com.chandler.spring.test.init"} )
public class DataConfig {
	private static Logger logger = LoggerFactory.getLogger(DataConfig.class);

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

