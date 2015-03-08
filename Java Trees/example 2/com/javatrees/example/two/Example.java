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
	
	private int getHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		
		return Math.max(getHeight(node.leftNode), getHeight(node.rightNode)) + 1;
	}
	
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
