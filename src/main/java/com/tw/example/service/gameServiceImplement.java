package com.tw.example.service;

public class gameServiceImplement implements gameService{
    public gameServiceImplement(boolean[][] matrix) {
        this.matrix = matrix;
    }

    private boolean[][] matrix;

    public boolean[][] init(int row, int col){
      this.matrix = new boolean[row][col];
      return matrix;
    }

    // 根据初始二维矩阵实例化
    // 初始矩阵 eg（3*3）：
    // 1 0 1
    // 0 1 1
    // 1 0 0
    // 矩阵值为1，实例化matrix值为true
    // 矩阵值为其他，实例化matrix值为false
    public boolean[][] instantiate(int initNums[][]){
        if(initNums == null || initNums[0] == null){
            return null;
        }
        for(int i=0;i<initNums.length;i++){
            for (int j=0;j<initNums[0].length;j++){
                if(initNums[i][j] == 1){
                    matrix[i][j] = true;
                }else {
                    matrix[i][j] = false;
                }

            }
        }
        return matrix;
    }

    public boolean[][] instantiateByRandom(int random){
        if(random<0 || random>=100){

        }
        return matrix;
    }

    public boolean[][] instantiateByChoose(int chooseNumer){
        return matrix;
    }

    public boolean[][] next(){
        return matrix;
    }
}
