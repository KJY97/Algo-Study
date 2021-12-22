package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
	
	/**
	 * 문제
	 *  이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하라.
	 *   - 노드의 왼쪽 서브트리에 있는 모든 노드의 키 < 노드의 키
	 *   - 노드의 오른쪽 서브트리에 있는 모든 노드의 키 > 노드의 키
	 *   - 왼쪽, 오른쪽 서브트리도 이진트리
	 *   
	 *   - 노드에 들어있는 키의 값은 10⁶보다 작은 양의 정수
	 *   - 노드 수 : 10,000개 이하
	 *   - 같은 키를 가지는 노드 존재하지 않음
	 *   
	 * 시간 : 672 ms
	 * 메모리 : 17376 kb
	 */
	
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 노드는 최대 10000개
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String data = "";
		while(true) {
			data = br.readLine();
			if(data == null || data.equals("")) break;
			insert(root,Integer.parseInt(data));
		}
		
		System.out.println(root.data);
		postOrder(root);
	}
	
	private static void insert(Node root, int data) {
		if(data < root.data) {
			if(root.left == null) root.left = new Node(data);
			else insert(root.left, data);
		}
		else if(data > root.data){
			if(root.right == null) root.right = new Node(data);
			else insert(root.right, data);
		}
	}
	
	private static void postOrder(Node root) {
		if(root == null) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

}
