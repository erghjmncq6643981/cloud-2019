/*
 * SingerServiceImplTest.java
 * 2019年7月22日 上午11:52:58
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.ingeration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.chandler.spring.test.annotation.DataSets;
import com.chandler.spring.test.config.DataConfig;
import com.chandler.spring.test.config.ServiceConfig;
import com.chandler.spring.test.entities.Singer;
import com.chandler.spring.test.ingeration.config.ServiceTestConfig;
import com.chandler.spring.test.services.SingerService;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月22日上午11:52:58
 * @since 1.8
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class, ServiceConfig.class, DataConfig.class })
@TestExecutionListeners({ ServiceTestExecutionListener.class })
@ActiveProfiles("test")
public class SingerServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	SingerService singerService;

	@PersistenceContext
	private EntityManager em;

	@DataSets(setUpDataSet = "/integration/SingerServiceImplTest.xls")
	@Test
	public void testFindAll() throws Exception {
		List<Singer> result = singerService.findAll();

		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@DataSets(setUpDataSet = "/integration/SingerServiceImplTest.xls")
	@Test
	@Ignore
	public void testFindByFirstNameAndLastNameOne() throws Exception {
		Singer result = singerService.findByFirstNameAndLastName("John", "Mayer");
		assertNotNull(result);
	}

	@DataSets(setUpDataSet = "/integration/SingerServiceImplTest.xls")
	@Test
	@Ignore
	public void testFindByFirstNameAndLastNameTwo() throws Exception {
		Singer result = singerService.findByFirstNameAndLastName("BB", "King");
		assertNull(result);
	}

	@Test
	@Ignore
	public void testAddSinger() throws Exception {
		deleteFromTables("SINGER");

		Singer singer = new Singer();
		singer.setFirstName("Stevie");
		singer.setLastName("Vaughan ");

		singerService.save(singer);
		em.flush();

		List<Singer> singers = singerService.findAll();
		assertEquals(1, singers.size());
	}

	@Test(expected = AssertionError.class)
	public void testAddSingerWithJSR349Error() throws Exception {
		deleteFromTables("SINGER");

		Singer singer = new Singer();

		singerService.save(singer);
		em.flush();

		List<Singer> singers = singerService.findAll();
		assertEquals(0, singers.size());
	}
}
