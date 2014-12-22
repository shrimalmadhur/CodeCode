/*
** A Basic implementation of StringBuffer (append and toString method only)
*/

public class MyStringBuffer{
	private int CURR_SIZE = 0;
	private int SIZE = 10;
	private double THRESHOLD = 0.75;
	private char[] bufArray;
	public MyStringBuffer(){
		bufArray = new char[SIZE];
	}
	public void append(String s){
		char[] cur = s.toCharArray();
		int sizeCurArray = cur.length;
		if(sizeCurArray + CURR_SIZE > THRESHOLD*SIZE){
			// Make new array and copy everything
			SIZE = getMax(2*(sizeCurArray + CURR_SIZE), 2*SIZE);
			char[] newBufArray = new char[SIZE];
			System.arraycopy(bufArray, 0, newBufArray, 0, CURR_SIZE);
			System.arraycopy(cur, 0, newBufArray, CURR_SIZE, sizeCurArray);
			bufArray = newBufArray;
			CURR_SIZE = CURR_SIZE + sizeCurArray;
		}else{
			//System.out.println(CURR_SIZE);
			System.arraycopy(cur, 0, bufArray, CURR_SIZE, sizeCurArray);
			CURR_SIZE = CURR_SIZE + sizeCurArray;
		}
	}
	public String toString(){
		return new String(bufArray);
	}
	public static int getMax(int a, int b){
		return a > b ? a : b;
	}
	public static void main(String[] args){
		MyStringBuffer sb = new MyStringBuffer();
		String[] test = {"aiaaaa","baaaaaaaaaaaaaaaaaaaaaaaaafffffffffffffffffffffffffff","c","d","e","f","g","h","i"};
		for(int i=0; i<test.length; i++){
			sb.append(test[i]);
		}
		System.out.println(sb.toString());
	}
}
