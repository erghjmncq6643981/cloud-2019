/*
 * SingerServiceImpl.java
 * 2019年7月18日 下午5:00:51
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chandler.spring.test.entities.Singer;
import com.chandler.spring.test.repos.SingerRepository;
import com.chandler.spring.test.services.SingerService;
import com.google.common.collect.Lists;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月18日下午5:00:51
 * @since 1.8
 */
@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {
	@Autowired
	private SingerRepository singerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return Lists.newArrayList(singerRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findByFirstName(String firstName) {
		return singerRepository.findByFirstName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public Singer findById(Long id) {
		return singerRepository.findById(id).get();
	}

	@Override
	public Singer save(Singer singer) {
		return singerRepository.save(singer);
	}

	@Override
	public void delete(Singer singer) {
		singerRepository.delete(singer);
	}

	@Override
	public Singer findByFirstNameAndLastName(String firstName, String lastName) {
		return singerRepository.findByFirstNameAndLastName(firstName, lastName);
	}
}
