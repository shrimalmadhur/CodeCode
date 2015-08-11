public class BinarySearch{
	public static void main(String[] args){
		int[] a = {-5};
		int len = a.length;
		System.out.println(binSearch(a, Integer.parseInt(args[0]), 0, len));
	}
	public static boolean binSearch(int[] a, int element, int low, int high){
		if(low + 1 == high){
			if(a[low] == element)
				return true;
			return false;
		}else{
			int mid = (low + high)/2;
			if(a[mid] < element){
				return binSearch(a, element, mid, high);
			}else if(a[mid] > element){
				return binSearch(a, element, low, mid);
			}else{
				return true;
			}
		}	

	}
}

