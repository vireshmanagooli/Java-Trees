/**
 * 
 */
package com.javatrees.example.three;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.javatrees.library.TreeNode;

/**
 * Given a binary tree design an algorithm which creates a linked list of all the nodes at
 * each depth. (e.g. if you have a tree with depth D, you'll have D linked lists.
 * 
 * Approach is to use Depth first search
 * @author Viresh
 *
 */
public class Example {
	
	/**
	 * 1. if the level is visiting at first time, then insert the list to lists.
	 * 2. if the size is not equals to level, then get the curresponding list.
	 * 3. add the node to the list.
	 * @param root
	 * @param lists
	 * @param level
	 */
	public static void createLevelLinkedList(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level){
		if(node == null)
			return;
		LinkedList<TreeNode> list = null;
		if(level == lists.size()){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		
		list.add(node);
		createLevelLinkedList(node.leftNode, lists,level+1);
		createLevelLinkedList(node.rightNode,lists,level+1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode node){
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(node, list, 0);
		return list;		
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	
	public static void main(String[] args){
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = TreeNode.createMinimalBST(array);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
		
	}
}
