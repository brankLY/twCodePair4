package main;

public class gameServiceImplement implements gameService{
    private boolean[][] matrix;

    public boolean[][] init(int row, int col){
      this.matrix = new boolean[row][col];
    }

    boolean[][] instantiate(int initNums[][]);

    boolean[][] instantiateByRandom(int random);

    boolean[][] instantiateByChoose(int chooseNumer);

    boolean[][] next();
}
