/*
** https://oj.leetcode.com/problems/reverse-integer/
*/
public class ReverseNum{
	public static void main(String[] args){
		System.out.print(reverse(-123));
	}
    public static int reverse(int x) {
        boolean isNegative = false;
        int num = x;
        if(num < 0){
            isNegative = true;
            num = num*-1;
            x = x*-1;
        }
        long factor = 1L;
        while(num > 0){
            num = num/10;
            factor = factor*10;
        }

        factor = factor/10;
        long finalNum = 0L;
        while(factor>0){
            long mod = x%10;
            finalNum = finalNum + factor*mod;
            x = x/10;
            factor = factor/10;
        }
        if(isNegative){
            finalNum = finalNum*-1;
        }
        if(finalNum > 2147483647 || finalNum < -2147483648){
            return 0;
        }
        return (int)finalNum;    	
    }	
}
