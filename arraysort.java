/* http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/ */

import java.util.Arrays;

public class arraysort{

	public static void main(String[] args){
		int a[] = {2,1,2,5,7,1,9,3,6,8,8};
		int b[] = {2,1,8,3};
		int len = a.length;
		boolean visited[] = new boolean[len];
		for(int i=0;i<len;i++){
			visited[i] = false;
		}
		int count = 0;
		int newArray[] = new int[len];
		Arrays.sort(a);
		//System.out.println(a.length);
	
		//System.out.println(binSearch(a,0,len,1));
		for(int i=0;i<b.length;i++){
			int pos = binSearch(a,0,len,b[i]);
			if(pos > -1){
				for(int j=pos;j<len && a[j]==b[i];j++){
					newArray[count++] = a[j];
					visited[j] = true;
				}
			}
		}
		for(int i=0;i<len;i++){
			if(!visited[i]){
				newArray[count++] = a[i];
			}
		}
		printArr(newArray);
	}
	private static int binSearch(int[] a,int startIndex, int endIndex ,int num){
		//System.out.println(startIndex + " to " + endIndex);
		if(startIndex <= endIndex){
		//printArr(a);	
		int midTerm = (startIndex + endIndex)/2;
		//System.out.println("midTerm -> " + midTerm);
		if(num == a[midTerm] && (midTerm == 0 || num > a[midTerm-1])){
			return midTerm;
		}else if(num >  a[midTerm]){
			return binSearch(a, midTerm+1, endIndex, num);	
		}else{
			return binSearch(a, startIndex, midTerm-1, num);
		}
		}
		return -1;
	}
	private static void printArr(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+ "-->");
		}
		System.out.println();
	}

}

