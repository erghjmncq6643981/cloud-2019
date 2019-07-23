/*
 * DBInitializer.java
 * 2019年7月18日 下午4:58:44
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.init;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandler.spring.test.entities.Singer;
import com.chandler.spring.test.repos.SingerRepository;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月18日下午4:58:44
 * @since 1.8
 */
@Service
public class DBInitializer {
	private Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	@Autowired
	SingerRepository singerRepository;

	@PostConstruct
	public void initDB() {
		logger.info("Starting database initialization...");
		Singer singer = new Singer();
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singer.setBirthDate(new Date((new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
		singerRepository.save(singer);

		singer = new Singer();
		singer.setFirstName("Eric");
		singer.setLastName("Clapton");
		singer.setBirthDate(new Date((new GregorianCalendar(1945, 2, 30)).getTime().getTime()));
		singerRepository.save(singer);

		singer = new Singer();
		singer.setFirstName("John");
		singer.setLastName("Butler");
		singer.setBirthDate(new Date((new GregorianCalendar(1975, 3, 1)).getTime().getTime()));

		singerRepository.save(singer);
		logger.info("Database initialization finished.");
	}
}
