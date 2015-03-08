/**
 * 
 */
package com.javatrees.example.five;

import com.javatrees.library.TreeNode;

/**
 * Write an algorithm to find the 'next' node (i.e. in-order successor) of a
 * given node in a binary search tree. You may assume that each node has a link
 * to its parent.
 * 
 * @author Viresh
 * 
 */
public class Example {
	
	/**
	 * In order traversal. LeftNode -> ParentNode -> RightNode.
	 * 1. (Case: last node, extreme right) If the processing node is the right most node, then return NULL.
	 * 2. (Case: head node, Parent == null) In this case, next node would be left most node of right node.
	 * 3. (Case: middle node, right!=null) In this case. next node would be left most node of the right node.
	 * 4. (Case: left node, want to get the middle node ) In this case, take the reference to parent, check if the parent's
	 * left child was current node. then return the parent. 
	 * @param n
	 * @return
	 */
	public static TreeNode inorderSucc(TreeNode n) { 
		if (n == null) return null;
		
		// Found right children -> return left most node of right subtree
		if (n.parentNode == null || n.rightNode != null) { 
			return leftMostChild(n.rightNode); 
		} else { 
			TreeNode q = n;
			TreeNode x = q.parentNode;
			// Go up until we’re on left instead of right
			while (x != null && x.leftNode != q) {
				q = x;
				x = x.parentNode;
			}
			return x;
		}  
	}
	
	/**
	 * Method to find out left most node.
	 * 1. Check if the current node is NULL, if yes, return NULL.
	 * 2. Loop through left node, till left node becomes NULL.
	 * 3. return the node.	
	 * @param n
	 * @return
	 */
	public static TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.leftNode != null) {
			n = n.leftNode; 
		}
		return n; 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
