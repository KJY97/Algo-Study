// 제목 : 트리 순회
// 티어 : 실버 1
// 링크 : https://www.acmicpc.net/problem/1991
// 메모리(kb) : 14124
// 실행시간(ms) : 120

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1991_박동식 {

	//트리 정보
	static Node[] graph;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

		//입력 및 초기화
		init();
		
		//순회 및 결과 저장
		Preorder('A');
		sb.append('\n');
		Inorder('A');
		sb.append('\n');
		Postorder('A');
		sb.append('\n');
		
		//출력
		System.out.println(sb);

	}
	
	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		//정점의 수
		int N = Integer.parseInt(br.readLine());
		graph = new Node[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char leftChild = st.nextToken().charAt(0);
			char rightChild = st.nextToken().charAt(0);
			
			graph[parent-'A'] = new Node(parent, leftChild, rightChild);
		}
		
	}
	
	static void Preorder(char nodeChar) {
		char leftChild = graph[nodeChar-'A'].leftChild;
		char rightChild = graph[nodeChar-'A'].rightChild;

		sb.append(nodeChar);
		if(leftChild!='.') Preorder(leftChild);
		if(rightChild!='.') Preorder(rightChild);
	}
	
	static void Inorder(char nodeChar) {
		char leftChild = graph[nodeChar-'A'].leftChild;
		char rightChild = graph[nodeChar-'A'].rightChild;

		if(leftChild!='.') Inorder(leftChild);
		sb.append(nodeChar);
		if(rightChild!='.') Inorder(rightChild);
	}
	
	static void Postorder(char nodeChar) {
		char leftChild = graph[nodeChar-'A'].leftChild;
		char rightChild = graph[nodeChar-'A'].rightChild;

		if(leftChild!='.') Postorder(leftChild);
		if(rightChild!='.') Postorder(rightChild);
		sb.append(nodeChar);
	}
	
	static class Node{
		char parent, leftChild, rightChild;

		public Node(char parent, char leftChild, char rightChild) {
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		
	}
	
}