/*
 * SingerService.java
 * 2019年7月18日 下午5:00:09
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.services;

import java.util.List;

import com.chandler.spring.test.entities.Singer;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月18日下午5:00:09
 * @since 1.8
 */
public interface SingerService {
	List<Singer> findAll();

	List<Singer> findByFirstName(String firstName);

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);

	Singer findByFirstNameAndLastName(String firstName, String lastName);
}
