package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리_순회_1991 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, n = Integer.parseInt(br.readLine());
		char data[];
		Tree tree2 = new Tree();
		
		for(i=0;i<n;i++){
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree2.add(data[0], data[1], data[2]);
		}
		tree2.preorder(tree2.root);
		System.out.println();
		tree2.inorder(tree2.root);
		System.out.println();
		tree2.postorder(tree2.root);
		br.close();
		
	}
	
}


	class Node{
		char data;
		Node left, right;
		public Node(char data){ this.data = data; }
	}
	
	class Tree{
		
		Node root;
		public void add(char data, char leftData, char rightData){
			if(root==null){
				if(data!='.') root = new Node(data);
				if(leftData!='.') root.left = new Node(leftData);
				if(rightData!='.') root.right = new Node(rightData);
			}
			else search(root, data, leftData, rightData);
		}
		private void search(Node root, char data, char leftData, char rightData){
			if(root==null) return;
			else if(root.data==data){
				if(leftData!='.') root.left = new Node(leftData);
				if(rightData!='.') root.right = new Node(rightData);
			}
			else{
				search(root.left, data, leftData, rightData);
				search(root.right, data, leftData, rightData);
			}
		}
		public void preorder(Node root){
			System.out.print(root.data);
			if(root.left!=null) preorder(root.left);
			if(root.right!=null) preorder(root.right);
		}
		public void inorder(Node root){
			if(root.left!=null) inorder(root.left);
			System.out.print(root.data);
			if(root.right!=null) inorder(root.right);
		}
		public void postorder(Node root){
			if(root.left!=null) postorder(root.left);
			if(root.right!=null) postorder(root.right);
			System.out.print(root.data);
		}
	}
