/*
 * Singers.java
 * 2019年7月18日 下午4:38:08
 *
 * Please contact chandler 
 * if you need additional information or have any questions.
 * @author 钱丁君-chandler
 * @version 1.0
 */

package com.chandler.spring.test.entities;

import java.io.Serializable;
import java.util.List;

/**
 * 类功能描述
 * 
 * @version
 * @author 钱丁君-chandler 2019年7月18日下午4:38:08
 * @since 1.8
 */
public class Singers implements Serializable {
	private List<Singer> singers;

	public Singers() {
	}

	public Singers(List<Singer> singers) {
		this.singers = singers;
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}

	@Override
	public String toString() {
		return "Singers [singers=" + singers + "]";
	}
}
