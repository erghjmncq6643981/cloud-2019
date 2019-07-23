/*
 * SingerControllerTest.java
 * 2019年7月19日 下午3:37:06
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.jmock;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.chandler.spring.test.controller.SingerController;
import com.chandler.spring.test.entities.Singer;
import com.chandler.spring.test.entities.Singers;
import com.chandler.spring.test.services.SingerService;

/**
 * mockito与junit配合测试controller
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月19日下午3:37:06
 * @since 1.8
 */
public class SingerControllerTest {
	private final List<Singer> singers = new ArrayList<>();

	private Mockery mockery = new Mockery();

	private SingerService mockSingerService;
	private SingerController singerController;

	@Before
	public void initSingers() {
		Singer singer = new Singer();
		singer.setId(1l);
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singers.add(singer);
		mockSingerService = mockery.mock(SingerService.class);
		singerController = new SingerController();
		ReflectionTestUtils.setField(singerController, "singerService", mockSingerService);
	}

	@Test
	public void testList() throws Exception {
		mockery.checking(new Expectations() {
			{
				oneOf(mockSingerService).findAll();
				will(returnValue(singers));
			}
		});
		ExtendedModelMap uiModel = new ExtendedModelMap();

		uiModel.addAttribute("singers", singerController.listData());
		Singers modelSingers = (Singers) uiModel.get("singers");
		assertEquals(1, modelSingers.getSingers().size());
		mockery.assertIsSatisfied();
	}

	@Test
//	@Ignore
	public void testCreate() {
		final Singer newSinger = new Singer();
		newSinger.setId(999l);
		newSinger.setFirstName("Stevie");
		newSinger.setLastName("Vaughan");

		mockery.checking(new Expectations() {
			{
				oneOf(mockSingerService).save(newSinger);
				singers.add(newSinger);
				will(returnValue(newSinger));
			}
		});

		Singer singer = singerController.create(newSinger);
		assertEquals(Long.valueOf(999l), singer.getId());
		assertEquals("Stevie", singer.getFirstName());
		assertEquals("Vaughan", singer.getLastName());

		assertEquals(2, singers.size());
		mockery.assertIsSatisfied();
	}
}
