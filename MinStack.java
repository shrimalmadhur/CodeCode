/*
** https://oj.leetcode.com/problems/min-stack/
*/

import java.util.Stack;

public class MinStack{
	private Stack<Integer> stackNorm = new Stack<Integer>();
	private Stack<Integer> stackMin = new Stack<Integer>(); 
	public static void main(String[] args){
		MinStack m = new MinStack();
		m.push(512);
		m.push(-1024);
		m.push(-1024);
		m.push(512);
		//m.push(2);
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
	}
	public void push(int x){
		if(stackNorm.isEmpty()){
			stackNorm.push(x);
			stackMin.push(x);
		}else{
			stackNorm.push(x);
			if(stackMin.peek() >= x){
				stackMin.push(x);
			}
		}
	}
	public void pop(){
		if(!stackNorm.isEmpty()){
			if(stackNorm.peek().equals(stackMin.peek())){
				stackMin.pop();
			}
			stackNorm.pop();
		}
	}
	public int top(){
		return stackNorm.peek();
	}
	public int getMin(){
		return stackMin.peek();
	}
}
