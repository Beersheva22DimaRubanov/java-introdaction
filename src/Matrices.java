
public class Matrices {
	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue) {
		int res[][] = new int[rows][columns];
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = SportLotoApp.getRandomInt(minValue, maxValue);                          
			}
		}
		return null;
	}
	
	public static int [][] transp(int[][] matix){
		return null;
	}
	
}
