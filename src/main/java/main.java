import com.tw.example.service.gameServiceImplement;

public class main {
	public static void main(String[] args) {
		gameServiceImplement service = new gameServiceImplement();
		service.init(3,3);
		int initNums[][] = {{1,2,3},{
			0,1,1},{
			1,0,1}};
		service.instantiate(initNums);
//		boolean [][]test = service.getMatrix();
		for(int i=0;i<initNums.length;i++){
			for (int j=0;j<initNums[0].length;j++){
				System.out.println(initNums[i][j]);
			}
		}
	}
}
