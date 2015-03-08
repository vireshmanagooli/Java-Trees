/**
 * 
 */
package com.javatrees.example.eight;

import com.javatrees.library.TreeNode;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum to a given value. The path does not need to start
 * or end at the root or a leaf.
 * @author Viresh
 *
 */
public class Example {

	public static void findSum(TreeNode node, int sum, int[] path, int level){
		if(node == null)
			return;
		
		path[level] = node.data;
		
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if(sum == t){
				print(path, i, level);
			}
		}
		
		findSum(node.leftNode, sum, path, level+1);
		findSum(node.rightNode, sum, path, level+1);
	}
	
	public static int depth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(node.leftNode), depth(node.rightNode));
		}
	}
	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}

	private static void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static void main(String [] args){
		TreeNode root = new TreeNode(5);
		root.leftNode = new TreeNode(3);
		root.rightNode = new TreeNode(1);
		root.leftNode.leftNode = new TreeNode(4);
		root.leftNode.rightNode = new TreeNode(8);
		root.rightNode.leftNode = new TreeNode(2);
		root.rightNode.rightNode = new TreeNode(6);
		findSum(root, 8);
	}

}
