/*
 * SingerController.java
 * 2019年7月19日 下午3:17:36
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chandler.spring.test.entities.Singer;
import com.chandler.spring.test.entities.Singers;
import com.chandler.spring.test.services.SingerService;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月19日下午3:17:36
 * @since 1.8
 */
@Controller
@RequestMapping(value = "/singer")
public class SingerController {
	final Logger logger = LoggerFactory.getLogger(SingerController.class);

	@Autowired
	private SingerService singerService;

	@RequestMapping(value = "/listdata", method = RequestMethod.GET)
	@ResponseBody
	public Singers listData() {
		Singers singers = new Singers(singerService.findAll());
		logger.info("singers:[{}]", singers.toString());
		return singers;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Singer findSingerById(@PathVariable Long id) {
		return singerService.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Singer create(@RequestBody Singer singer) {
		logger.info("Creating singer: " + singer);
		singerService.save(singer);
		logger.info("Singer created successfully with info: " + singer);
		return singer;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody Singer singer, @PathVariable Long id) {
		logger.info("Updating singer: " + singer);
		singerService.save(singer);
		logger.info("Singer updated successfully with info: " + singer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		logger.info("Deleting singer with id: " + id);
		Singer singer = singerService.findById(id);
		singerService.delete(singer);
		logger.info("Singer deleted successfully");
	}
}
