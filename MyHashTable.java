/*
* HashTable implemented using a LinkedList
* Author: Madhur Shrimal
*/

import java.util.LinkedList;
import java.util.ListIterator;
public class MyHashTable{
	private int SIZE = 20;
	Object[] table;
	int nElements;
	public MyHashTable(){
		table = new Object[SIZE];
		nElements = 0;
	}
	public int hash(Object key){
		if(key instanceof Integer){
			return (2*(Integer)key + 1)%SIZE;
		}
		return 0;
	}
	public void add(Object key, Object val){
		if(this.contains(key)){
			System.out.println("Key Already Present");
		}else{
			int hash = this.hash(key);
			if(this.table[hash] == null){
				this.table[hash] = new LinkedList();
			}
			((LinkedList)this.table[hash]).add(new HashTableNode(key, val));
			nElements++;
		}
	}
	public void remove(Object key){
		if(this.contains(key)){
			int hash = this.hash(key);
			LinkedList l = (LinkedList)this.table[hash];
			HashTableNode n = new HashTableNode();
			n.setKey(key);
			if(l.indexOf(n) > -1){
				l.remove(l.indexOf(n));
				nElements--;
			}else{
				System.out.println("Key not found");
			}
		}else{
			System.out.println("Key not found");
		}
	}
	public boolean contains(Object key){
		int hash = this.hash(key);
		if((LinkedList)this.table[hash] == null){
			return false;
		}else{
			LinkedList l = (LinkedList)this.table[hash];
			HashTableNode n = new HashTableNode();
			n.setKey(key);
			if(l.indexOf(n) > -1){
				return true;
			}
			return false;
		}
	}
	public void printHashTable(){
		Object[] a = this.table;
		for(int i = 0; i < a.length; i++){
			System.out.print(i + "-->");
			LinkedList l = (LinkedList)this.table[i];
			if(l == null){
				System.out.println();
			}else{
				ListIterator<HashTableNode> itr = l.listIterator();
				while(itr.hasNext()){
					itr.next().printNode();
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args){
		MyHashTable tab = new MyHashTable();
		tab.add(1,3);
		tab.add(22,34);
		tab.add(23,2);
		tab.add(32,33);
		tab.remove(24);
		tab.add(223,23);
		tab.add(1212,2);
		tab.add(12119,45);
		tab.printHashTable();
	}
}
