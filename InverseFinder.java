public class InverseFinder{
	public static void main(String[] args){
		int a[] = {8,4,2,9,6,3,4,5,6,1};
		int n = a.length;
		int temp = 0;
		int res[] = mergeSort(a,0,n-1,temp);
		printArr(res);
		System.out.println(temp);
	}
	public static int[] mergeSort(int[] a, int start, int end, int n){
		if(start == end){
			int[] arr = new int[1];
			arr[0] = a[start]; 
			return arr;
		}else{
			int mid  = (start + end)/2;
			int[] u =  mergeSort(a, start, mid, n);
			int[] v =  mergeSort(a, mid + 1, end, n);
			return merge(u, v, n);
		}
	}
	public static void printArr(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "-->");
		}	
		System.out.println();
	}
	public static int[] merge(int[] u, int[] v, int n){
		//printArr(u);
		//printArr(v);
		int j = u.length;
		int k = v.length;
		int len = j + k;
		int a[] = new int[len];
		int m = 0;
		int l = 0;
		int i = 0;
			while(m < j && l < k){
				if(u[m] < v[l]){
					a[i] = u[m];
					m++;
				}else{
					a[i] = v[l];
					l++;
					n = n + u.length - m;
				}
				i++;
			}
			if(m == j){
				while(l<k){
					a[i] = v[l];
					l++;
					i++;
				}
			}else{
				while(m < j){
					a[i] = u[m];
					m++;
					i++;
				}
			}
	
		return a;
	}
}
