public class Node{
	public int data;
	public Node next;

	public Node(int data){
		this.next = null;
		this.data = data;
	}
	public Node(Node next, int data){
		this.next = next;
		this.data = data;
	}
}
