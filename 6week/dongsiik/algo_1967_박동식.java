// 제목 : 트리의 지름
// 티어 : 골드 4
// 링크 : https://www.acmicpc.net/problem/1967
// 메모리(kb) : 23056
// 실행시간(ms) : 228

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_1967_박동식 {

	//정점 수, 트리의 지름, 트리의 지름 한쪽 끝
	static int N, diameter, lastNode;
	//DFS에서 쓸 방문 여부 배열
	static boolean[] visited;
	//그래프
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {

		//입력받기
		input();

		//초기화 후 지름의 한 쪽 끝 찾기
		diameter = 0;
		visited = new boolean[N];
		lastNode = 0;

		dfs(new Node(0, 0));

		//다시 초기화 후 다른쪽 끝까지의 거리 구하기
		diameter = 0;
		Arrays.fill(visited, false);
		dfs(new Node(lastNode, 0));

		System.out.println(diameter);

	}

	static void input() throws NumberFormatException, IOException {
		// 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}

	}

	static void dfs(Node node) {
		//현재 정점
		int nodeNum = node.to;
		int currentWeight = node.weight;

		//방문했다면 통과
		if (visited[nodeNum])
			return;

		//방문처리 후, 지름과 비교한 후 필요하다면 갱신
		visited[nodeNum] = true;
		if (diameter < currentWeight) {
			diameter = currentWeight;
			lastNode = nodeNum;
		}

		//연결된 다른 점들에 대해서 DFS
		for (Node nextNode : graph[nodeNum]) {
			int nextNodeNum = nextNode.to;
			int nextWeight = currentWeight + nextNode.weight;
			dfs(new Node(nextNodeNum, nextWeight));
		}

	}

	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

	}
}