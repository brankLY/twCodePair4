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


    //transform true to 1，false to 0
    public int transform(boolean state){
        if (state) return 1;
        else return 0;
    }

    //get the number of living cells around cell[x][y]
    public int getLifeNum(int x, int y) throws Exception{
        int row = this.matrix.length;
        int col = this.matrix[0].length;

        if(x<0 || x>row || y<0 || y>col) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int num = 0;
        //左边
        if(y!=0){
            num+=transform(this.matrix[x][y-1]);
        }
        //左上角
        if(x!=0&&y!=0){
            num+=transform(this.matrix[x-1][y-1]);
        }
        //上边
        if(x!=0){
            num+=transform(this.matrix[x-1][y]);
        }
        //右上
        if(y!=col-1&&x!=0){
            num+=transform(this.matrix[x-1][y+1]);
        }
        //右边
        if(y!=col-1){
            num+=transform(this.matrix[x][y+1]);
        }
        //右下
        if(y!=col-1&&x!=row-1){
            num+=transform(this.matrix[x+1][y+1]);
        }
        //下边
        if(x!=row-1){
            num+=transform(this.matrix[x+1][y]);
        }
        //左下
        if(y!=0&&x!=row-1){
            num+=transform(this.matrix[x+1][y-1]);
        }
        return num;
    }

    //get the next state of cell[x][y]
    public boolean getNextState(int x,int y) {
        int num = getLifeNum(x, y);
        boolean nextState = false;
        if (num == 3) {
            nextState = true;
        } else if (num == 2) {
            nextState = this.matrix[x][y];
        }
        return nextState;
    }

    public void next() {
        int row = this.matrix.length;// 在哪设成全局变量？
        int col = this.matrix[0].length;
        boolean[][] nextMatrix = new boolean[row][col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                nextMatrix[i][j] = getNextState(i,j);
            }
        }
        this.matrix = nextMatrix;
    }
    public void start(){
        int T = 100;// the number of evolution
        for(int i=0; i<T; i++){
            next();
            //add pause
        }
    }
}
