public class RevString{
	public static void main(String[] args){
		String s = "abcde";
		s.charAt(2) = 'r';
		char temp;
		for(int i = 0; i < s.length(); i++){
			temp = s.charAt(i);
			s.charAt(i) = s.charAt(s.length()-i-1);
			s.charAt(s.length()-i-1) = temp;
		}
		System.out.print(s);
	}
}
