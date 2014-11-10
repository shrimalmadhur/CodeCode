/*
* Find number is shifted sorted array.
* TO-DO: handle case when number is not there: giving stack overflow- infinite loop
*/

public class BinSearchShifted{
	public static void main(String[] args){
		int[] a = {19, 21, 23, 98, 1, 4, 5, 7,13, 14, 15};
		System.out.println(positionFinder(a, 2, 0, a.length-1));
	}
	public static int positionFinder(int[] a, int val, int start, int end){
		if(a[start] == val){
			return start;
		}
		if(a[end] == val){
			return end;
		}
		if(start == end){
			return -1;
		}
		int mid = (start+end)/2;
		if(a[mid] < a[start]){
			if(val > a[start] || val < a[mid]){
				return positionFinder(a, val, start, mid);
			}else{
				return positionFinder(a, val, mid, end);
			}
		}else{
			if(val < a[end] || val > a[mid]){
				return positionFinder(a, val, mid, end);
			}else{
				return positionFinder(a, val, start, mid);
			}
		}
	}
}
