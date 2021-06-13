package com.nayara.os;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OsApplicationTests {

	@Test
	void contextLoads() {
		String test = "teste ok";
		
		Assertions.assertEquals(test, "teste ok");
	}

}
