/*
**
** 1) Level order traversal of a tree
** 2) https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
** It uses BST and BSTNode class.
**
*/

import java.util.Queue;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class LevelOrderBottom{
	public static void main(String[] args){
		BST b = new BST(20);
		BSTNode root = b.getRoot();
		root.setLeftNode(new BSTNode(10));
		root.setRightNode(new BSTNode(22));
		root.getLeftNode().setLeftNode(new BSTNode(12));
		root.getRightNode().setLeftNode(new BSTNode(35));
		root.getRightNode().setRightNode(new BSTNode(111));
		levelOrderTraversal(root);
		List<List<Integer>> result = levelOrderList(root);
		//List<ArrayList<Integer>> reverse = Lists.reverse(result);
		Collections.reverse(result);
		Iterator<List<Integer>> listIterator = result.iterator();
		while(listIterator.hasNext()){
			List<Integer> currList = listIterator.next();
			Iterator<Integer> currIter = currList.iterator();
			while(currIter.hasNext()){
				System.out.print(currIter.next() + " - ");
			}
			System.out.println();
		}
	}

	/*
	** Level Order Traversal of a tree
	*/
	public static void levelOrderTraversal(BSTNode root){
		Queue<BSTNode> nodeQueue = new LinkedList<BSTNode>();
		nodeQueue.add(root);
		List<Integer> dataList = new ArrayList<Integer>();
		//System.out.println(nodeQueue.peek());
		while(nodeQueue.peek() != null){
			BSTNode currNode  = nodeQueue.remove();
			dataList.add(currNode.getData());
			if(currNode.getLeftNode() != null){
				nodeQueue.add(currNode.getLeftNode());
			}
			if(currNode.getRightNode() != null){
				nodeQueue.add(currNode.getRightNode());
			}
		}
		Iterator<Integer> listIterator = dataList.iterator();
		while(listIterator.hasNext()){
			System.out.print(listIterator.next() + "-->");
		}
		System.out.println();
	}

	/*
	** https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
	*/
	public static List<List<Integer>> levelOrderList(BSTNode root){
		Queue<BSTNode> currQueue = new LinkedList<BSTNode>();
		Queue<BSTNode> newQueue = new LinkedList<BSTNode>();
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		List<Integer> currList = new ArrayList<Integer>();
		currQueue.add(root);
		while(!currQueue.isEmpty()){
			BSTNode currNode = currQueue.poll();
			currList.add(currNode.getData());
			if(currNode.getLeftNode() != null){
				newQueue.add(currNode.getLeftNode());
			}
			if(currNode.getRightNode() != null){
				newQueue.add(currNode.getRightNode());
			}
			if(currQueue.isEmpty()){
				finalList.add(new ArrayList<Integer>(currList));
				currQueue = newQueue;
				newQueue = new LinkedList<BSTNode>();
				currList.clear();
			}
		}
		return finalList;
	}
}
