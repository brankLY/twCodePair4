package com.tw.example.demo4.service;

public interface GameService {

    boolean[][] init(int row, int col);

    boolean[][] instantiate(int initNums[][]);

    boolean[][] instantiateByRandom(int random);

    boolean[][] instantiateByChoose(int chooseNumer);

    boolean[][] next();

    boolean change(int x, int y) throws Exception;
}