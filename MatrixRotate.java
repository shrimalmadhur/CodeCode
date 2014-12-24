/*
** Rotate Matrix by 90 degree
*/
public class MatrixRotate{
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int[][] mat = {{1}};
		printMatrix(matrix);
		System.out.println("Rotated Matrix");
		printMatrix(rotateMatrix(matrix));
	}
	public static void printMatrix(int[][] m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length;j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] rotateMatrix(int[][] m){
		int n = m.length;
		for(int layer = 0; layer < n/2; layer++){
			System.out.println("Rotating layer : " + layer);
			int[] temp = new int[n - 2*layer];
			int j = 0;
			for(int i = layer; i < n - layer; i++){
				temp[j] = m[layer][i];
				j++;
			}
			// left to top
			for(int i = layer; i < n - layer; i++){
				m[layer][n - i - 1] = m[i][layer];
			}

			// bottom to left
			for(int i = layer; i < n - layer; i++){
				m[i][layer] = m[n - layer - 1][i];
			}
	
			// right to bottom
			for(int i = layer; i < n - layer; i++){
				m[n - layer - 1][i] = m[n - i - 1][n - layer - 1];
			}

			//temp to right
			int k = temp.length - 1;
			for(int i = layer; i < n - layer; i++){
				m[n - i - 1][n - layer - 1] = temp[k];
				k--;
			}
		}
		return m;
	}
}
