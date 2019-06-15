package com.tw.example.service;

public class gameServiceImplement implements gameService{
    private boolean[][] matrix = {};

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
                    this.matrix[i][j] = true;
                }
            }
        }
        return this.matrix;
    }

    public boolean[][] getMatrix() {
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

    public boolean change(int x, int y) throws Exception{
        if(x<0 || x>this.matrix.length || y<0 || y>this.matrix[0].length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        boolean nextState = false;
        int count = 0;
        for (int i=x-1; i<=x+1; i++){
            for (int j=y-1; j<=y+1; j++){
                if(this.matrix[i][j]){
                    count++;
                }
            }
        }
        if(this.matrix[x][y]){
            count -= 1;
        }
        if (count == 3){
            nextState = true;
        }
        else if(count == 2){
            nextState = this.matrix[x][y];
        }

        return nextState;
    }
}
