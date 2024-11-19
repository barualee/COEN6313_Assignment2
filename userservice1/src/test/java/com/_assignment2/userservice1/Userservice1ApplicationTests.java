package com._assignment2.userservice1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com._assignment2.userservice1.user.UserRepository;
import com._assignment2.userservice1.entities.User;

@SpringBootTest
class Userservice1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testGetUserById() {
		User user = userRepository.findById(12345).get();
		assertEquals(user.getUserId(),12345);
	}

}
