package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ThinkersApplication.class)
@WebAppConfiguration
public class ThinkersApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		System.out.println("helloworld");
		SpringApplication.run(ThinkersApplication.class, args);
	}

}
