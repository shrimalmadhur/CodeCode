/*
** Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/
import java.util.List;
import java.util.ArrayList;
public class ZeroMatrix{
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,0,5},{6,7,8,9,10},{11,12,0,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		printMatrix(matrix);
		printMatrix(addZero(matrix));
	}
	public static void printMatrix(int[][] m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length;j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] addZero(int[][] m){
		List<Integer> rowList = new ArrayList<Integer>();
		List<Integer> colList = new ArrayList<Integer>();
		for(int i=0; i< m.length; i++){
			for(int j=0; j< m[i].length; j++){
				if(m[i][j] == 0){
					if(!rowList.contains(i)){
						rowList.add(i);
					}
					if(!colList.contains(j)){
						colList.add(j);
					}
				}
			}
		}
		for(int i : rowList){
			for(int j=0;j<m[i].length; j++){
				m[i][j] = 0;
			}
		}
		for(int i : colList){
			for(int j=0; j<m.length; j++){
				m[j][i] = 0;
			}
		}
		return m;
	}
}
