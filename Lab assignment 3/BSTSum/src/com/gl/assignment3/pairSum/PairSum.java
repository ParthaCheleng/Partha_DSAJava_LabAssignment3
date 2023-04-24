package com.gl.assignment3.pairSum;
import java.io.*;
import java.util.*;

class Node{
	int data;
	Node left, right;
	
	Node(int value){
		data=value;
		left=right=null;
	}
}

public class PairSum {
	Node root;
	
	PairSum(){
		root=null;
	}
	
	public void insert(int key) {
		root=insert(root,key);
	}
	
	Node insert(Node root, int data) {
		if(root==null) {
			root=new Node(data);
			return root;
		}
		
		if(data<root.data)
			root.left=insert(root.left,data);
		else if(data>root.data)
			root.right=insert(root.right, data);
		return root;
	}
	
	public boolean isPairPresent(Node root, Node temp, int target) {
		if(temp==null)
			return false;
		
		return search(root, temp, target-temp.data)
				|| isPairPresent(root, temp.left,target)
				|| isPairPresent(root, temp.right, target);
	}
	
	public boolean search(Node root, Node temp, int k) {
		if(root==null)
			return false;
		
		Node r=root;
		boolean flag=false;
		while(r!=null && flag != true) {
			if(r.data==k && temp != r) {
				flag=true;
				System.out.println("Pair found: " + r.data+"+"+temp.data);
				
				return true;
			}else if(k<r.data)
				r = r.left;
			else
				r=r.right;
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		PairSum tree=new PairSum();
		
		tree.insert(40);
		tree.insert(20);
		tree.insert(60);
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		tree.insert(70);
		
		boolean test = tree.isPairPresent(tree.root, tree.root, 130);
		
		if(!test)
			System.out.println("No such values are found!");
	}
}
