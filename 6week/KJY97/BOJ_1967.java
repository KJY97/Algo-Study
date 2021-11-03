// 실행시간 : 200 MS
// 메모리 : 20652 KB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1967_트리의지름 {

	static class Node {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static List<Node>[] list;
	static int Max, nodeNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수. 1 ≤ n ≤ 10,000
		
		list = new List[N+1]; //1번 부터 사용
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		//간선 정보 입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 부모 노드 번호
			int to = Integer.parseInt(st.nextToken()); // 자식 노드 번호
			int weight = Integer.parseInt(st.nextToken()); // 간선의 가중치
			
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		// 트리에 존재하는 두 노드 사이의 경로 길이가 가장 긴 것 = 트리의 지름
		Max = 0;
		
		// 루트로부터 가장 먼, 지름의 끝 점 중 하나인 nodeNum 찾기
		DFS(1, 0, new boolean[N+1]);
		
		// nodeNum에서 가장 먼, 또 다른 지름의 끝 점 찾기
		DFS(nodeNum, 0, new boolean[N+1]);
		
		// 트리의 지름은..
		System.out.println(Max);
	}
	
	public static void DFS(int idx, int sum, boolean[] visited) {
		visited[idx] = true; // 방문체크
		
		if (Max < sum) { // 최대값 갱신
			Max = sum;
			nodeNum = idx;
		}
		
		for (Node cur : list[idx]) {
			if(!visited[cur.vertex]) {
				DFS(cur.vertex, sum + cur.weight, visited);
			}
		}
	}
}
