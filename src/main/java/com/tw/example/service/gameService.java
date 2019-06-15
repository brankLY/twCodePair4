package com.tw.example.service;

public interface gameService {

    boolean[][] init(int row, int col);

    boolean[][] instantiate(int initNums[][]);

    boolean[][] instantiateByRandom(int random);

    boolean[][] instantiateByChoose(int chooseNumer);

    boolean[][] next();
}