// 실행시간 : 80 ms
// 메모리 : 11636 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1991_트리순회 { // 이진트리를 전위, 중위, 후위순회로 출력

	static class Node {
		char data;
		Node left, right;
		
		public Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class Tree {
		
		Node root;
		
		public Tree(char data, char leftData, char rightData) {
			root = new Node(data);
			if(leftData != '.') root.left = new Node(leftData);
			if(rightData != '.') root.right = new Node(rightData);
		}
		
		public void Add(char data, char leftData, char rightData) {
			
			search(root.left, data, leftData, rightData); // 왼쪽으로 data를 가진 노드 탐색
			search(root.right, data, leftData, rightData); // 오른쪽으로 data를 가진 노드 탐색
		}
		
		public void search(Node node, char data, char leftData, char rightData) {
			
			 // 기저조건: 더 이상 탐색 할 수 없다면 탐색 종료
			if(node == null) {
				return ;
			}
			
			// data를 가진 부모 노드를 찾았다면 자식 노드 추가
			if(node.data == data) {
				if(leftData != '.') 
					node.left = new Node(leftData);
				if(rightData != '.') 
					node.right = new Node(rightData);
			}
			else {
				// data를 가진 부모 노드가 아니면 계속 다음 노드를 찾기 위해 탐색 진행
				search(node.left, data, leftData, rightData); // 왼쪽으로 data 탐색
				search(node.right, data, leftData, rightData); // 오른쪽으로 data 탐색
			}
		}
		
		// 전위 순회. 루트 - 왼쪽 - 오른쪽
		public void preOrder(Node root) {
			if(root != null) {
				System.out.print(root.data);
				preOrder(root.left);
				preOrder(root.right);
			}
		}
		
		// 중위 순회. 왼쪽 - 루트 - 오른쪽
		public void inOrder(Node root) {
			if(root != null) {
				inOrder(root.left);
				System.out.print(root.data);
				inOrder(root.right);
			}
		}
		
		// 후위 순회. 왼쪽 - 오른쪽 - 루트
		public void postOrder(Node root) {
			if(root != null) {
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.data);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 이진 트리의 노드의 개수. 1 ≤ N ≤ 26
		char[] data = br.readLine().replaceAll(" ", "").toCharArray(); // 공백 문자 제거한 문자열을 char 배열로 만듦
		Tree tree = new Tree(data[0], data[1], data[2]);
		
		// 트리 정보 입력. 자식 노드가 없으면 '.'
		for (int i = 1; i < N; i++) {
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.Add(data[0], data[1], data[2]);
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}
