public class BST{
	private BSTNode root;
	public BST(){
		root = new BSTNode(0);
	}
	public BST(int data){
		root = new BSTNode(data);
	}
	public BSTNode getRoot(){
		return this.root;
	}
	public void setRoot(BSTNode root){
		this.root = root;
	}
	public static void insert(BSTNode b, int data){
		//System.out.println(b);
		BSTNode newNode = new BSTNode(data);
		if(b.getLeftNode() == null && b.getRightNode() == null){
			if(data < b.getData()){
				b.setLeftNode(newNode);
			}else{
				b.setRightNode(newNode);
			}
		}else{
			if(data < b.getData()){
				if(b.getLeftNode() == null)
					b.setLeftNode(newNode);
				else
					insert(b.getLeftNode(), data);
			}else{
				if(b.getRightNode() == null){
					b.setRightNode(newNode);
				}else{
					insert(b.getRightNode(), data);
				}
			}
		}
	}
	public void printTree(){
	
	}
	public static void inorder(BSTNode node){
		if(node != null){
			inorder(node.getLeftNode());
			System.out.print(node.getData() + " --> ");
			inorder(node.getRightNode());
		}
	}
	
	public static int getMinDistance(BSTNode node){
		int currNodeData = node.getData();
		
		//Right Sub - Minimum
		int rightTreeMin = -1;
		int leftTreeMin = -1;		
		if(node.getRightNode() != null){
			BSTNode rightNode = node.getRightNode();
			int rightNodeData = rightNode.getData();
			int minRightNode = getMinAtNode(rightNode);
			int one = rightNodeData - currNodeData;
			int two = minRightNode - currNodeData;
			int minOne = getMin(one, two);
			int minRightNodeTraversal = getMinDistance(rightNode);
			if(minRightNodeTraversal == -1){
				rightTreeMin = minOne;
			}else{
				rightTreeMin = getMin(minOne, minRightNodeTraversal); 
			}
		}
		
		//Left Sub - Maximum
		if(node.getLeftNode() != null){
			BSTNode leftNode = node.getLeftNode();
			int leftNodeData = leftNode.getData();
			int maxLeftNode = getMaxAtNode(leftNode);
			int one = currNodeData - leftNodeData;
			int two = currNodeData - maxLeftNode;
			int minOne = getMin(one, two);
			int minLeftNodeTraversal = getMinDistance(leftNode);
			if(minLeftNodeTraversal == -1){
				leftTreeMin = minOne;
			}else{
				leftTreeMin = getMin(minOne, minLeftNodeTraversal);
			}
		}
		if(leftTreeMin == -1 && rightTreeMin == -1){
			return -1;
		}else if(leftTreeMin == -1){
			return rightTreeMin;
		}else if(rightTreeMin == -1){
			return leftTreeMin;
		}else{
			return getMin(leftTreeMin, rightTreeMin);
		}
	}
	
	public static int getMaxAtNode(BSTNode node){
		while(node.getRightNode() != null){
			//System.out.println(node.getData());
			node = node.getRightNode();
		}
		return node.getData();
	}
	
	public static int getMinAtNode(BSTNode node){
		while(node.getLeftNode() != null){
			node = node.getLeftNode();
		}
		return node.getData();
	}
	
	public static int getMin(int a, int b){
		return a > b ? b : a;
	}
	
	public static void main(String args[]){
		BST b = new BST(224444);
		BSTNode root = b.getRoot();
		insert(root, 2222);
		insert(root, 3456);
		insert(root, 4456);
		insert(root, 44444);
		insert(root, 5667);
		insert(root, 12334);
		insert(root, 454566);
		insert(root, 123354);
		System.out.println("Inorder Traversal");
		inorder(b.root);
		System.out.println();
		System.out.println(getMinDistance(root));
		//System.out.println(getMaxAtNode(root.getLeftNode()));
		//System.out.println(getMinAtNode(root.getRightNode()));
	}
} 
