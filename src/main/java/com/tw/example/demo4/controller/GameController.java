/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019. All rights reserved.
 */

package com.tw.example.demo4.controller;


import com.tw.example.demo4.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import result.Result;
import io.swagger.annotations.ApiParam;

/**
 * @author x00504227
 * @version NCE Analyzer R19C00
 * @since 2019-05-28
 */
@EnableAutoConfiguration
@RequestMapping("/game")
@RestController
@Validated
@Api(value = "GAME", description = "game相关接口")
public class GameController {
	@Autowired
    private GameService gameService;
	public boolean[][] matrix = {};

	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public ResponseEntity<?> next() {
		boolean[][] result = gameService.next();
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Result.fail("wrong somewhere"), HttpStatus.NOT_FOUND);
		}
	}



	@RequestMapping(value = "/init", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Result> init(@ApiParam("初始化矩阵行数")@RequestParam("initListRow")int row,  @ApiParam("初始化矩阵列数")@RequestParam("initListCol")int col) {
		System.out.println(row+"ddddd"+col);
		matrix = gameService.init(row,col);
		if (matrix == null){
			return new ResponseEntity<>(Result.fail("初始化失败"), HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(Result.success("初始化成功"), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/instantiate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> instantiate(@ApiParam("实例化矩阵")@RequestParam("instantiateList")int initNums[]) {
		System.out.println("tttttt"+matrix[0][0]);
		int requstInitNums[][] = new int[matrix.length][matrix[0].length];
		int index = 0;
		for(int i=1;i<matrix.length-1;i++){
			for(int j=1;j<matrix[0].length-1;j++){
				System.out.println("index++++++++++++");
				System.out.println("index: "+index+" i:"+i+" j:"+j);
				requstInitNums[i][j] = initNums[index];
				index++;
			}
		}
		matrix = gameService.instantiate(requstInitNums);

		if (initNums != null) {
			return new ResponseEntity<>(Result.success("实例化成功"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Result.fail("实例化失败"), HttpStatus.CREATED);
		}
	}

    
	
}
