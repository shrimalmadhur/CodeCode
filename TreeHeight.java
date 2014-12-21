/*
** https://oj.leetcode.com/problems/balanced-binary-tree/
** Also finding height of the tree
** Use BST and BSTNode class
*/

public class TreeHeight{
	public static void main(String[] args){
		BST tree = new BST(1);
		BSTNode root = tree.getRoot();
		root.setLeftNode(new BSTNode(12));
		root.setRightNode(new BSTNode(13));
		root.getRightNode().setLeftNode(new BSTNode(11));
		//root.getRightNode().getLeftNode().setRightNode(new BSTNode(1122));
		int height = getHeight(root);
		System.out.println(height);
		System.out.println(isBalanced(root));
	}

	/*
	** To find the height of a tree
	*/
	public static int getHeight(BSTNode node){
		if(node.getLeftNode() == null && node.getRightNode() == null){
			return 0;
		}else if(node.getLeftNode() == null){
			return 1 + getHeight(node.getRightNode());
		}else if(node.getRightNode() == null){
			return 1 + getHeight(node.getLeftNode());
		}else{
			return 1 + getMax(getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
		}
	}

	/*
	** Return max of two numbers
	*/
	public static int getMax(int a, int b){
		return a > b ? a : b;
	}

	/*
	** https://oj.leetcode.com/problems/balanced-binary-tree/
	*/
	public static boolean isBalanced(BSTNode node){
		if(node.getLeftNode() != null && node.getRightNode() != null){
			int l = getHeight(node.getLeftNode());
			int r = getHeight(node.getRightNode());
			if(l - r > 1 || l - r <-1){
				return false;
			}else{
				return isBalanced(node.getLeftNode()) && isBalanced(node.getRightNode());
			}
		}else if(node.getLeftNode() == null && node.getRightNode() == null){
			return true;
		}else if(node.getLeftNode() == null){
			if(getHeight(node.getRightNode()) > 0){
				return false;
			}
			return true;
		}else if(node.getRightNode() == null){
			if(getHeight(node.getLeftNode()) > 0){
				return false;
			}
			return true;
		}else{
			return true;
		}
	}
}
