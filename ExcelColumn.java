/*
** https://oj.leetcode.com/problems/excel-sheet-column-title/
*/

import java.lang.StringBuilder;
public class ExcelColumn{
	public static void main(String[] args){
		System.out.println(convertToTitle(52));
	}
	public static String convertToTitle(int n){
		int div = n;
		int mod = 0;
		StringBuilder sb = new StringBuilder();
		boolean isMultiple = false;
		while(div > 0){
			mod = (div-1) % 26;
			//div = div / 26;
			sb.append(getCharForNumber(mod));
			div = (div - mod)/26;
		}
		sb = sb.reverse();
		return sb.toString();
	}
	public static String getCharForNumber(int i) {
    		return i > -1 && i < 26 ? String.valueOf((char)(i + 65)) : null;
	}
}
