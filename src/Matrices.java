
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
	
	public static int [][] transp(int[][] matrix){
		int newMatrix[][] = new int[matrix[0].length][matrix.length];
		for(int i = 0; i<newMatrix.length; i++) {
			for(int n = 0; n<newMatrix[i].length; n++) {
				newMatrix[i][n] = matrix[n][i];
			}
		}
		return newMatrix;
	}
}