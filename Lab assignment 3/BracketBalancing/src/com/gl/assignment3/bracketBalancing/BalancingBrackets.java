package com.gl.assignment3.bracketBalancing;
import java.util.*;
public class BalancingBrackets {
	public static boolean isBalanced(String s) {
		int i=-1;
		char[] stack=new char[s.length()];
		
		for(char ch: s.toCharArray()) {
			if(ch=='('|| ch=='{' || ch=='[')
				stack[++i]=ch;
			else {
				if(i>=0 && ((stack[i]=='(' && ch==')') || 
						(stack[i]=='{' && ch=='}') || 
						(stack[i] == '[' && ch == ']')))
					i--;
				else
					return false;
			}
		}
		return i==-1;
	}
	
	public static void main(String[] args) {
		String input = "([[{}]])";
		
		if(isBalanced(input))
			System.out.println("The entered String has balanced brackets");
		else 
			System.out.println("The entered Strings do not contain balanced brackets");
		
	}
}
