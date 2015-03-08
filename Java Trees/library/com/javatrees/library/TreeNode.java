/**
 * 
 */
package com.javatrees.library;


/**
 * @author Viresh
 *
 */
public class TreeNode {

	public int data;
	public TreeNode leftNode;
	public TreeNode rightNode;
	public TreeNode parentNode;
	private int size = 0;
	
	public TreeNode(int data){
		this.data = data;
		size = 1;
	}
	
	public void setLeftNode(TreeNode myNode){
		this.leftNode = myNode;
		if(myNode != null){
			myNode.parentNode = this;
		}
	}
	
	public void setRightNode(TreeNode myNode){
		this.rightNode = myNode;
		if(myNode != null){
			myNode.parentNode = this;
		}
	}
	
	public void insertInorder(int d){
		
		if(d > data){
			if(this.rightNode == null)
				setRightNode(new TreeNode(d));
			else
				rightNode.insertInorder(d);
		}else if(d <= data){
			if(this.leftNode == null)
				setLeftNode(new TreeNode(d));
			else
				leftNode.insertInorder(d);
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public int height(){
		int leftHeight = leftNode != null ? leftNode.height() : 0;
		int rightHeight = rightNode != null ? rightNode.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d){
		if(data == d)
			return this;
		
		if(d <= data)
			return leftNode != null ? leftNode.find(d) : null;
		if(d > data)
			return rightNode != null ? rightNode.find(d) : null;
			
		return null;	
	}
	
	public void print(){
		if(this != null){			
			if(leftNode != null)
				leftNode.print();
			
			System.out.println(" -> " + data);
			
			if(rightNode != null)
				rightNode.print();
		}		
	}
	
	public boolean isBST(){
		if(leftNode != null){
			if(leftNode.data > data || !leftNode.isBST())
				return false;
		}
		
		if(rightNode != null){
			if(rightNode.data <= data || !rightNode.isBST())
				return false;
		}
		
		return true;
	}
	
	public static TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftNode(createMinimalBST(arr, start, mid - 1));
		n.setRightNode(createMinimalBST(arr, mid + 1, end));
		return n;
	
	}
	
	public static TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
}
