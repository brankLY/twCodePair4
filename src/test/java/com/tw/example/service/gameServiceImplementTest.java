package com.tw.example.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.print.resources.serviceui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


public class gameServiceImplementTest {
	int x = 3;
	int y = 3;
	gameServiceImplement service = new gameServiceImplement();
	@Before
	public void should_init_matrix() throws Exception {
		assertThat(service.init(x,y)).isNotEmpty();
	}
	@Test
	public void should_instantiate_matrix() throws Exception {
		int initNums[][] = {{1,2,3},{
			0,1,1},{
			1,0,1}};
		assertThat(service.instantiate(initNums)).isNotEmpty();
	}

	public void should_return_next_state() throws Exception{
		boolean[][] current_state = service.getMatrix();
		boolean nextState = false;
		int x = 1;
		int y = 1;
		int count = 0;
		for (int i=x-1; i<=x+1; i++){
			for (int j=y-1; j<=y+1; j++){
				if(current_state[i][j] == true){
					count++;
				}
			}
		}
		if(current_state[x][y] == true){
			count -= 1;
		}
		if (count == 3){
			nextState = true;
		}
		else if(count == 2){
			nextState = current_state[x][y];
		}

		assertThat(service.change(x,y)).isEqualTo(nextState);

	}

	@Test
	public void should_return_next() throws Exception{
		assertThat(service.next()).isNotEmpty();
	}
}
