package com.tw.example.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


public class gameServiceImplementTest {
	gameServiceImplement service = new gameServiceImplement();
	@Before
	public void should_init_matrix() throws Exception {
		assertThat(service.init(3,3)).isNotEmpty();
	}
	@Test
	public void should_instantiate_matrix() throws Exception {
		int initNums[][] = {{1,2,3},{
			0,1,1},{
			1,0,1}};
		assertThat(service.instantiate(initNums)).isNotEmpty();
	}
}
