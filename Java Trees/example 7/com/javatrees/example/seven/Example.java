/**
 * 
 */
package com.javatrees.example.seven;

import com.javatrees.library.TreeNode;

/**
 * You have two very large binary trees: T1 with millions of nodes, and T2 with
 * hundreds of nodes. Create an algorithm to decide if T2 is subtree of T1
 * 
 * A tree T2 is a subtree of T1 if these exists a node n in T1 such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 * @author Viresh
 *
 */
public class Example {

	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true; // The empty tree is a subtree of every tree.
		else
			return subTree(t1, t2);
	}
	
	/* Checks if the binary tree rooted at r1 contains the binary tree 
	 * rooted at r2 as a subtree somewhere within it.
	 */
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null)
			return false; // big tree empty & subtree still not found.
		if (r1.data == r2.data) {
			if (matchTree(r1,r2)) return true;
		}
		return (subTree(r1.leftNode, r2) || subTree(r1.rightNode, r2)); 
	}

	/* Checks if the binary tree rooted at r1 contains the 
	 * binary tree rooted at r2 as a subtree starting at r1.
	 */
	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r2 == null && r1 == null) 
			return true; // nothing left in the subtree
		if (r1 == null || r2 == null) 
			return false; //  big tree empty & subtree still not found
		if (r1.data != r2.data) 
			return false;  // data doesn’t match
		return (matchTree(r1.leftNode, r2.leftNode) && 
				matchTree(r1.rightNode, r2.rightNode));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		
		TreeNode t1 = TreeNode.createMinimalBST(array1);
		TreeNode t2 = TreeNode.createMinimalBST(array2);

		if (containsTree(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = TreeNode.createMinimalBST(array1);
		TreeNode t4 = TreeNode.createMinimalBST(array3);

		if (containsTree(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");
	}

}
