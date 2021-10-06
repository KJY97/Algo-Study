// 실행시간: 708 ms
// 메모리: 91980 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main { //트리의 지름
	
	static class Node {
		int to, dis;

		public Node(int to, int dis) {
			this.to = to;
			this.dis = dis;
		}
		
	}
	static List<Node>[] list;
	static int max, nodeNum;
	
	public static void main(String[] args) throws IOException {
		// 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다
		// 트리의 지름을 구하시오
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정점의 개수. 2 ≤ V ≤ 100,000
		int V = Integer.parseInt(br.readLine());
		list = new List[V+1];	//정점 번호는 1번부터 시작
		
		// 간선 정보 입력
		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			
			//시작 정점
			int from = Integer.parseInt(st.nextToken());
			list[from] = new ArrayList<>();
			
			while(true) {
				//연결된 정점
				int to = Integer.parseInt(st.nextToken());
				
				if(to == -1) break;
				
				//가중치
				int dis = Integer.parseInt(st.nextToken());
				list[from].add(new Node (to, dis));
			}
		}
		
		//두 점 사이의 거리가 가장 긴 것 = 가중치의 합이 가장 큰 겻
		max = 0;
		
		// 루트에서 가장 먼 노드 찾기 = nodeNum
		DFS(1, 0, new boolean[V+1]);
		
		// nodeNum에서 가장 먼 노드 찾기
		DFS(nodeNum, 0, new boolean[V+1]);
		System.out.println(max);
	}
	
	/**
	 * DFS는 쭉 직진하는 형태로 탐색하기 때문에 사용하였다.
	 * @param num 탐색하는 정점 번호
	 * @param sum 가중치의 합
	 * @param visited 정점 방문 체크 배열
	 */
	static void DFS(int num, int sum, boolean[] visited) {
		visited[num] = true; 	// 방문 체크
		
		if (max < sum) {
			max = Math.max(max, sum);
			nodeNum = num;
		}

		for (Node cur : list[num]) {
			if(!visited[cur.to]) 
				DFS(cur.to, sum + cur.dis, visited);
		}
	}

}
