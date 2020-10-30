package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {
	static User user = null;
	
	@BeforeAll
	static void preprocess() {
	    user = new User(null);
	}
	
	@Test
	void 正常系_ユーザー管理コード登録参照(){
		String code = "89006";
		user.setCode(code);
		assertThat(user.getCode()).isEqualTo(code);
	}
	
	@Test
	void 正常系_名前登録参照() {
		String name = "高津カリノ";
		user.setName(name);
		assertThat(user.getName()).isEqualTo(name);
	}
	
	@Test
	void 正常系_年齢登録参照() {
		int age = 52;
		user.setAge(age);
		assertThat(user.getAge()).isEqualTo(age);
	}
	
	@Test
	void 異常系_範囲外年齢登録() {
		int outOfRangeAge = 0;
		user.setAge(outOfRangeAge);
		assertThat(user.getAge()).isEqualTo(-1);
	}
	
	@Test
	void 異常系_未登録年齢参照(){
		//範囲外年齢登録の-1と意味合いが違うので明示したほうがよさそう
		assertThat(user.getAge()).isEqualTo(-1);
	}
}
