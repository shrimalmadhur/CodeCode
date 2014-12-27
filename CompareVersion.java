/*
** https://oj.leetcode.com/problems/compare-version-numbers/
*/

public class CompareVersion{
	public static void main(String[] args){
		System.out.println(compareVersion("1.1","1.01.0"));	
	}
	public static int compareVersion(String version1, String version2){
		if(version1.indexOf(".") == -1){
			version1 = version1 + ".0";
		}
		if(version2.indexOf(".") == -1){
			version2 = version2 + ".0";
		}
		String[] v1 = version1.split("\\.");
        	String[] v2 = version2.split("\\.");
		int num = 0;
		boolean flag = false;
		if(v1.length > v2.length){
			num = v2.length;
			flag = true;
		}else{
			num = v1.length;
		}
		for(int i = 0; i < num; i++){
			int num1 = Integer.parseInt(v1[i]);
			int num2 = Integer.parseInt(v2[i]);
			if(num1 == num2){
				continue;
			}else{
				if(num1 > num2){
					return 1;
				}else{
					return -1;
				}
			}
		}
		if(v1.length == v2.length){
			return 0;
		}else{
			int l1 = v1.length;
			int l2 = v2.length;
			if(flag){
				for(int i=l2; i < l1; i++){
					if(Integer.parseInt(v1[i]) != 0){
						return 1;
					}
				}
				return 0;
			}else{
				for(int i=l1; i<l2; i++){
					if(Integer.parseInt(v2[i]) != 0){
						return -1;
					}
				}
				return 0;
			}
		}
	}
}

