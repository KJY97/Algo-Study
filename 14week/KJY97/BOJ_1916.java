package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
	
	/**
	 * 문제
	 *  A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 구하라.
	 *   - 도시번호는 1 ~ N
	 *   - 한 도시에서 출발하여 다른 도시에 도착하는 M개 버스
	 *   => 다익스트라
	 *   
	 *  시간: 480 ms
	 *  메모리: 51336 kb
	 */
	private static class Node implements Comparable<Node>{
		int vertex;
		int cost;
		
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	private static int N, M;
	private static List<Node> list[];
	private final static int INFINITY = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시 개수. 1 ≤ N ≤ 1,000
		M = Integer.parseInt(br.readLine()); // 버스 개수. 1 ≤ M ≤ 100,000
		
		list = new List[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 버스 노선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()); // 0 <= cost <= 100,000
			
			list[start].add(new Node(end, cost));
		}
		
		// 출발 도시와 도착도시 번호 입력
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int ans = dijkstra(A, B);
		System.out.println(ans);
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] cost = new int[N+1];
		
		Arrays.fill(cost, INFINITY);
		
		queue.add(new Node(start, 0));
		cost[start] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curV = cur.vertex;
			int curCost = cur.cost;
			
			// 방문했다면 pass
			if(visited[curV]) continue;
			
			// 방문체크
			visited[curV] = true;
			
			for (Node next: list[curV]) {
				
				// 방문하지 않았고, 경유지+가중치 값이 최소 가중치보다 작다면
				if(!visited[next.vertex] && cost[next.vertex] > curCost + next.cost) {
					cost[next.vertex] = curCost + next.cost;
					queue.add(new Node(next.vertex, cost[next.vertex]));
					
				}
			}
		}
		
		return cost[end];
	}

}
