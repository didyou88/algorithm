// Baekjoon 1991. 트리 순회 

import java.util.*;
import java.io.*;

class Node {
	char value;
	Node left;
	Node right;
	
	public Node(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Node(char value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class Main {
	
	static Node head = new Node('A');
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, parent, left, right);
		}
		
		preorder(head);
		sb.append("\n");
		inorder(head);
		sb.append("\n");
		postorder(head);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// 노드 추가  
	static void insertNode(Node tmp, char parent, char left, char right) {
		if(tmp.value == parent) {
			if(left != '.') tmp.left = new Node(left);
			if(right != '.') tmp.right = new Node(right);
		} else {
			if(tmp.left != null) insertNode(tmp.left, parent, left, right);
			if(tmp.right != null) insertNode(tmp.right, parent, left, right);
		}
	}
	
	// 전위순회 (root, left, right)
	static private void preorder(Node node) {
		if(node == null) return;
		
		sb.append(node.value);
		preorder(node.left);
		preorder(node.right);
	}
	
	// 중위순회 (left, root, right)
	static private void inorder(Node node) {
		if(node == null) return;
		
		inorder(node.left);
		sb.append(node.value);
		inorder(node.right);
	}
	
	// 후위순회 (left, right, root)
	static private void postorder(Node node) {
		if(node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		sb.append(node.value);
	}
	
}
