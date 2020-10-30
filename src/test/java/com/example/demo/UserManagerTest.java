package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserManagerTest{
	static UserManager userManager = null;
	static User user1 = new User("0001");
	static User user2 = new User("0002");
	static User user3 = new User("0003");
	static User user4 = new User("0004");
	
	@BeforeAll
	static void preprocess() {
		userManager = UserManager.getInstance(); 
	}
	
	@Test
	void 正常系_UserManagerインスタンス同一() {
		UserManager testUserManager = UserManager.getInstance();
		assertThat(userManager).isEqualTo(testUserManager);
	}
	
	@Test
	void 正常系_userList登録参照() {
		List<User> testUserList = new ArrayList<User>();		
		Collections.addAll(testUserList, user1, user2, user3, user4);
		
		userManager.setUserToList(user1);
		userManager.setUserToList(user2);
		userManager.setUserToList(user3);
		userManager.setUserToList(user4);
		
		assertThat(userManager.getUserList()).containsAll(testUserList);	
	}
	
	@Test
	void 正常系_userMap登録参照() {
		Map<String, User> testUserMap = new HashMap<String, User>();
		testUserMap.put("0001", user1);
		testUserMap.put("0002", user2);
		testUserMap.put("0003", user3);
		testUserMap.put("0004", user4);
		
		userManager.setUserToMap(user1);
		userManager.setUserToMap(user2);
		userManager.setUserToMap(user3);
		userManager.setUserToMap(user4);
		
		assertThat(userManager.getUserMap()).containsAllEntriesOf(testUserMap);		
	}
	
	@Test
	void 正常系_user全削除(){
		List<User> testUserList = new ArrayList<User>();
		Map<String, User> testUserMap = new HashMap<String, User>();
		userManager.deleteAllUser();
		
		assertThat(userManager.getUserList()).isEqualTo(testUserList);
		assertThat(userManager.getUserMap()).isEqualTo(testUserMap);
	}
	
	
	
	
	
	
	
}