/*
** https://oj.leetcode.com/problems/zigzag-conversion/
*/

import java.lang.StringBuilder;
import java.util.HashMap;
public class ZigZag{
	public static void main(String[] args){
		String s = "AB";
		System.out.println(convert(s,3));
	}
	public static String convert(String s, int n){
		int i = 0;
		int len = s.length();
		if(len == 0 || len < n){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();
		while(i < len){
			int j = 0;
			for(j=0; j < n; j++){
				if(i >= len){
					break;
				}
				if(map.containsKey(j)){
					StringBuilder temp = map.get(j);
					temp.append(s.charAt(i));
					map.put(j, temp);
					System.out.println(j + "-->" + s.charAt(i));
				}else{
					StringBuilder temp = new StringBuilder();
					temp.append(s.charAt(i));
					map.put(j, temp);
					System.out.println(j + "-->" + s.charAt(i));
				}
				i++;
			}
			j--;
			System.out.println("J ---- > " + j);
			for(int k = j-1; k > 0; k--){
				if(i >= len){
					break;
				}
				if(map.containsKey(k)){
					StringBuilder temp = map.get(k);
					temp.append(s.charAt(i));
					map.put(k, temp);
					System.out.println(k + "-->" + s.charAt(i));
				}else{
					StringBuilder temp = new StringBuilder();
					temp.append(s.charAt(i));
					map.put(k, temp);
					System.out.println(k + "-->" + s.charAt(i));
				}
				i++;
			}
		}
		for(int j = 0; j < n; j++){
			System.out.println(map.get(j).toString());
			sb.append(map.get(j).toString());
		}
		return sb.toString();
	}
}
