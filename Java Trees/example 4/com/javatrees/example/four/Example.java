/**
 * 
 */
package com.javatrees.example.four;

import com.javatrees.library.TreeNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 * Please refere the boolean CtCILibrary.TreeNode.isBST()
 * @author Viresh
 *
 */
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Is the node BST? : " + root.isBST());

	}

}
