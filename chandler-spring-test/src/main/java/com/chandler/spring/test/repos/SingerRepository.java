/*
 * SingerRepository.java
 * 2019年7月18日 下午4:40:28
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.repos;

import java.util.List;

import com.chandler.spring.test.entities.Singer;
import org.springframework.data.repository.CrudRepository;

/**
 * 类功能描述
 * @version   
 * @author 钱丁君-chandler 2019年7月18日下午4:40:28
 * @since 1.8
 */
public interface SingerRepository extends CrudRepository<Singer, Long>{

	List<Singer> findByFirstName(String firstName);

	Singer findByFirstNameAndLastName(String firstName, String lastName);
}

