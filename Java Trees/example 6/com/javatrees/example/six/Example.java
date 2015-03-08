/**
 * 
 */
package com.javatrees.example.six;

import com.javatrees.library.TreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 * @author Viresh
 *
 */
public class Example {
	
	/**
	 * Method to check whether given node is present in the tree or not.
	 * @param root
	 * @param p
	 * @return
	 */
	public static boolean covers(TreeNode root, TreeNode node){
		if(root == null)
			return false;
		
		if(root == node)
			return true;
		
		return covers(root.leftNode,node) || covers(root.rightNode,node); 
	}

	/**
	 * Method to find out common ancestor.
	 * 1. (base case) If the root node is null, then return null.
	 * 2. (Case: Nodes are of different side of root node.) In this case, Check node p & q are on
	 * same side. If No, then return the root node as common ancestor.
	 * 3. (Case: Nodes are on same side of root node.) In this case, check nodes are present left or right?
	 * based on the direction, send either root.left or root.right recursively.  
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		
		boolean is_p_at_left = covers(root.leftNode, p);
		boolean is_q_at_left = covers(root.leftNode, q);
		
		if(is_p_at_left != is_q_at_left)
			return root;
		else{
			TreeNode childeNode = is_p_at_left? root.leftNode : root.rightNode;
			return commonAncestorHelper(childeNode, p, q);
		}
			
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}

}
