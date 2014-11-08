public class arrayGap{
	public static void main(String[] args){
		int[] a = {1,2,3,5,6,7,8,9};
		System.out.println(findGap(a, 0, a.length-1));
	}
	public static int findGap(int[] a, int start, int end){
		if(a[end]-a[start] == 1 && (a[start] != start + 1)){
			return a[start] - 1;
		//}else if(end - start != a[end] - a[start]){
		}else{
			if(end - start == 1){
				return a[start] + 1;
			}
			int mid = (start + end)/2;
			if(mid - start != a[mid] - a[start]){
				return findGap(a, start, mid);
			}else{
				return findGap(a, mid, end);
			}
		}
	}
	public static int findGap1(int[] a, int start, int end){
		if(end - start == a[end] - a[start]){
			return -1;
		}
		if(start+1 == end){
			return a[start] + 1;
		}
		int mid = (start+end)/2;
		if(mid-start < a[mid] - a[start]){
			return findGap1(a, start, mid);
		}else{
			return findGap1(a, mid, end);
		}
	}
}
