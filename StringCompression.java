/*
** aaabbbccc --> a3b3c3
*/
import java.lang.StringBuilder;
public class StringCompression{
	public static void main(String[] args){
		String s = "aaabbbcccasasdrrfassssffrtgfeaasa";
		StringBuilder sb = new StringBuilder();
		char prev = '\0';
		int count = 0;
		for(int i=0; i<s.length(); i++){
			if(prev == '\0'){
				prev = s.charAt(i);
				count = 0;
			}
			char currChar = s.charAt(i);
			if(prev == currChar){
				count++;
			}else{
				sb.append(prev).append(String.valueOf(count));
				prev = currChar;
				count = 1;
			}
		}
		sb.append(prev).append(String.valueOf(count));
		System.out.println(sb.toString());
	}
}
