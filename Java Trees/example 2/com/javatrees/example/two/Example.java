/**
 * 
 */
package com.javatrees.example.two;

import com.javatrees.library.TreeNode;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that the heights of the two 
 * subtrees of any node never differ by more than one.
 * @author Viresh
 *
 */
public class Example {
	
	/**
	 * 1. Recursive function to find out the height of the node.
	 * 2. Recursively pass the right and left nodes till we find the null.
	 * 3. At any given level, add +1, to indicate we have to account the current node also.
	 * @param root
	 * @return
	 */
	private int getHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		
		return Math.max(getHeight(node.leftNode), getHeight(node.rightNode)) + 1;
	}
	
	/**
	 * 1. For every node, find out the height. if the size is greater than 1, then it is not balanced tree.
	 * 2. Keep doing the same thing for left and right nodes untill we encounter null.
	 * @param root
	 * @return
	 */
	private boolean isBalenced(TreeNode node){
		if(node == null)
			return true;
		
		int leftHeight = getHeight(node.leftNode);
		int rightHeight = getHeight(node.rightNode);
		if(Math.abs(leftHeight - rightHeight) > 1)
			return false;
		else
			return isBalenced(node.leftNode) && isBalenced(node.rightNode);
		
	}

	public static void main(String[] args){
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = TreeNode.createMinimalBST(array);
		Example ex = new Example();
		System.out.println("Is tree balenced? : " + ex.isBalenced(root));
		
	}
}
