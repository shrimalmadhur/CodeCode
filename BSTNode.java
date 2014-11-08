public class BSTNode{
	private BSTNode left;
	private BSTNode right;
	private int data;

	public BSTNode(int data){
		this.left = null;
		this.right = null;
		this.data = data;
	}

	public BSTNode getRightNode(){
		return this.right;
	}
	public void setRightNode(BSTNode right){
		this.right = right;
	}
	
	public BSTNode getLeftNode(){
		return this.left;
	}
	public void setLeftNode(BSTNode left){
		this.left = left;
	}
	public int getData(){
		return this.data;
	}
	public void setData(int data){
		this.data = data;
	}
}
