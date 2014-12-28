import java.util.Stack;
public class MyLinkedList{
	
	private Node head;
	private int SIZE;
	public MyLinkedList(){
		head = null;
		SIZE = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int getSize(){
		return SIZE;
	}
	
	public void add(int data){
		Node newNode = new Node(data);
		if(SIZE == 0){
			head = newNode;
			SIZE++;
		}else{
			Node currNode = head;
			while(currNode.next != null){
				currNode = currNode.next;
			}
			currNode.next = newNode;
			SIZE++;
		}
	}
	
	public void delete(int data){
		if(this.isEmpty()){
			System.out.println("Linked List empty");
		}else{
			Node currNode = head;
			Node prevNode = null;
			boolean found = false;
			while(currNode != null){
				if(currNode.data == data){
					found = true;
					SIZE--;
					if(currNode == head){
						head = head.next;
					}else{
						prevNode.next = currNode.next;
					}
				}
				prevNode = currNode;
				currNode = currNode.next;
			}
			if(!found){
				System.out.println("Data not found");
			}
		}
	}
	public void insertAtIndex(int index, int data){
		Node newNode = new Node(data);
		if(this.isEmpty() && index > 0){
			System.out.println("Cannot insert at index " + index);
		}else{
			Node currNode = head;
			Node prevNode = null;
			if(index == 0){
				head = newNode;
				newNode.next = currNode;
			}else{
				while(currNode != null && index > 0){
					prevNode = currNode;
					currNode = currNode.next;
					index--;
				}
				if(currNode == null){
					System.out.println("Index out of range");
				}else{
					newNode.next = prevNode.next;
					prevNode.next = newNode;
				}
			}
		}
	}
	
	public void reverse(){
		Node currNode = head;
		Node prevNode = null;
		Node next;
		while(currNode != null){
			next = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = next;
		}
	}
	
	public boolean isPalindrome(){
		Node curr = head;
		int num = 0;
		Stack<Integer> pal = new Stack<Integer>();
		if(SIZE%2 == 0){
			num = SIZE/2;
			for(int i=0; i<num; i++){
				pal.push(curr.data);
				curr = curr.next;
			}
			//curr = curr.next;
			for(int i=0;i<num;i++){
				if(curr.data != pal.pop()){
					return false;
				}
				curr = curr.next;
			}
			return true;
		}else{
			num = SIZE/2 + 1;
			for(int i=0; i<num-1;i++){
				pal.push(curr.data);
				curr = curr.next;
			}
			curr = curr.next;
			for(int i=0; i<num-1;i++){
				if(curr.data != pal.pop()){
					return false;
				}
				curr = curr.next;
			}
			return true;
		}
			
	}

	public void printList(){
		Node currNode = head;
		while(currNode.next != null){
			System.out.print(currNode.data + "-->");
			currNode = currNode.next;
		}
		System.out.println(currNode.data);
	}

	public MyLinkedList mergeSortLinked(){
		Node a = head;
		Node b = head;
		if(a.next == null){
			return this;
		}
		return this;
		//while(a != NULL && a.next !=NULL){
		//	
		//} 
	}
	/*
	** Write code to partition a linked list around a value x, such that all nodes less than x come before alt nodes 
	** greater than or equal to x.
	*/	
	public void partitionList(int val){
		Node curr = head;
		Node lim = head;
		while(curr != null){
			if(curr.data < val){
				int temp = curr.data;
				curr.data = lim.data;
				lim.data = temp;
				lim = lim.next;
			}
			curr = curr.next;
		}
	}

	/*
	** You have two numbers represented by a linked list, where each node contains a single digit. Thedigits are 
	** stored in reverse order, such that the 1'sdigit isat the head of the list. 
	** Write a function that adds the two numbers and returns the sum as a linked list.
	*/
	public MyLinkedList add1(MyLinkedList l2){
		Node curr1 = this.head;
		Node curr2 = l2.head;
		MyLinkedList result = new MyLinkedList();
		int carry = 0;
		while(curr1 != null && curr2 != null){
			int temp = curr1.data + curr2.data + carry;
			if(temp > 9){
				carry = 1;
				temp = temp%10;
			}else{
				carry = 0;
			}
			result.add(temp);
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		while(curr1 != null){
			int temp = curr1.data + carry;
			if(temp > 9){
				carry = 1;
				temp = temp%10;
			}else{
				carry = 0;
			}
			result.add(temp);
			curr1 = curr1.next;
		}
		while(curr2 != null){
			int temp = curr2.data + carry;
			if(temp > 9){
				carry = 1;
				temp = temp%10;
			}else{
				carry = 0;
			}
			result.add(temp);
			curr2 = curr2.next;
		}
		if(carry == 1){
			result.add(1);
		}
		return result;
	}
	public static void main(String[] args){
		MyLinkedList a = new MyLinkedList();
		a.add(1);
		a.add(3);
		a.add(6);
		a.add(3);
		a.add(1);
		MyLinkedList b = new MyLinkedList();
		b.add(9);
		b.add(3);
		b.add(3);
		b.add(9);
		MyLinkedList result = a.add1(b);
		a.printList();
		b.printList();
		result.printList();
		System.out.println(a.isPalindrome());
		System.out.println(b.isPalindrome());
	}
}
