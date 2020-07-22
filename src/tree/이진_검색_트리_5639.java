package tree;

import java.io.*;
 
public class 이진_검색_트리_5639 {
    public static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree tree = new BinaryTree(Integer.parseInt(br.readLine()));
        String temp = "";
        while ((temp = br.readLine()) != null && temp.length() != 0) {  
            tree = tree.addTree(tree, Integer.parseInt(temp));
        }
        postorder(tree);
        System.out.println(sb);
    }
 
    public static void postorder(BinaryTree tree) {
        if (tree.left != null) postorder(tree.left);
        if (tree.right != null) postorder(tree.right);
        sb.append(tree.data + "\n");
    }
}
 
class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;
 
    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
 
    public BinaryTree addTree(BinaryTree tree, int val) {
        BinaryTree curTree = null;
        if (tree == null) return new BinaryTree(val);
        if (tree.data > val) {
            curTree = addTree(tree.left, val); 
            tree.left = curTree;               
        } else if (tree.data < val) {
            curTree = addTree(tree.right, val); 
            tree.right = curTree;               
        }
        return tree;                          
    }
}
 