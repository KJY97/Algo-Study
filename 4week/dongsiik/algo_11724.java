//114056, 524

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_11724 {

	// 조상 노드
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입출력도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점 수, 간선 수
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 조상 노드 초기화
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		// 간선 입력받으며 union
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			makeUnion(u, v);
		}

		// 자신과 조상이 같은 노드만큼 연결 요소가 있음
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (i == parent[i])
				answer++;
		}

		// 출력
		System.out.println(answer);
	}

	// 조상 찾기(경로 압축)
	static int findParent(int node) {
		if (node == parent[node])
			return node;

		return parent[node] = findParent(parent[node]);
	}

	// 조상 합치기
	static void makeUnion(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);

		if (aParent > bParent)
			parent[aParent] = bParent;
		else
			parent[bParent] = aParent;
	}
}