public class MyLinkedList{
	
	private Node head;
	private static int SIZE;
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
		Node initialNode = head;
		Node midNode = head;
		int num = 0;
		if(SIZE%2 == 0){
			num = SIZE/2;
		}else{
			num = SIZE/2 + 1;
		}	
		while(num > 0){
			midNode = midNode.next;
			num--;
		}
		while(midNode != null){
			if(midNode.data != initialNode.data){
				return false;
			}
			midNode = midNode.next;
			initialNode = initialNode.next;
		}
		return true;
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
		if(a.next == NULL){
			return list;
		}
		while(a != NULL && a.next !=NULL){
			
		} 
	}

	public static void main(String[] args){
		MyLinkedList a = new MyLinkedList();
		a.add(21);
		a.add(22);
		//System.out.println(a.getSize());
		a.add(22);
		a.add(21);
		//System.out.println(a.getSize());
		//a.printList();
		//a.delete(21);
		//a.printList();
		//a.delete(34);
		//System.out.println(a.getSize());
		//a.printList();
		//a.insertAtIndex(4,22222);
		//a.printList();
		//a.reverse();
		a.printList();
		System.out.println(a.isPalindrome());
	}
}
