
// 제목 : 트리의 순회
// 티어 : 골드 3
// 링크 : https://www.acmicpc.net/problem/2263	
// 메모리(kb) : 50624
// 실행시간(ms) : 480

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2263_박동식 {

	// 트리 정보
	static int N;
	static int[] Inorder;
	static int[] InorderToIndex;
	static int[] Postorder;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		// 입력 및 초기화
		init();

		// 순회 및 결과 저장
		getPreorder(1, N, 1, N);

		// 출력
		System.out.println(sb);

	}

	private static void getPreorder(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
		int parent = Postorder[postorderEnd];
		int parentIndexInorder = InorderToIndex[parent];
		int numOfLeftFamily = parentIndexInorder - inorderStart;
		int numOfRightFamily = inorderEnd - parentIndexInorder;

		sb.append(parent).append(' ');
		if (numOfLeftFamily > 0)
			getPreorder(inorderStart, parentIndexInorder - 1, postorderStart, postorderStart + numOfLeftFamily - 1);
		if (numOfRightFamily > 0)
			getPreorder(parentIndexInorder + 1, inorderEnd, postorderEnd - numOfRightFamily, postorderEnd - 1);

	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		// 정점의 수
		N = Integer.parseInt(br.readLine());
		Inorder = new int[N + 1];
		Postorder = new int[N + 1];
		InorderToIndex = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int nodeNum = Integer.parseInt(st.nextToken());
			Inorder[i] = nodeNum;
			InorderToIndex[nodeNum] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			Postorder[i] = Integer.parseInt(st.nextToken());
		}

	}

}