package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11779 {
	
	/**
	 * 문제
	 *  A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 구하라.
	 *   - 도시번호는 1 ~ N
	 *   - 한 도시에서 출발하여 다른 도시에 도착하는 M개 버스
	 * => 다익스트라
	 * => 스페셜저지문제.. 1-3-5 or 1-4-5 나와도 정답
	 *  
	 * 시간 : 468 ms
	 * 메모리 : 51800 kb
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
			// 오름차순 정렬
			return this.cost - o.cost;
		}
	}
	
	private static int N, M;
	private static List<Node>[] list;
	private static int cost[], route[];
	private final static int INFINITY = 100000000; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시 개수. 1 ≤ N ≤ 1,000
		M = Integer.parseInt(br.readLine()); // 버스 개수. 1 ≤ M ≤ 100,000
		
		// 초기화
		list = new List[N+1]; // 도시번호는 1번부터..
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 출발 
			int to = Integer.parseInt(st.nextToken()); // 도착
			int cost = Integer.parseInt(st.nextToken()); // 비용. 0 <= cost <= 100,000
			
			list[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 출발 도시
		int end = Integer.parseInt(st.nextToken()); // 도착 도시
		
		dijkstra(start, end);
		
		// 출발 도시 -> 도착 도시 최소 비용
		System.out.println(cost[end]);
		
		// idx가 도착정점이기 때문에 저장된 이전 정점을 따라간다. (거꾸로 가기)
		ArrayList<Integer> routes = new ArrayList<>();
		int cur = end;
		while(cur != 0) {
			routes.add(cur);
			cur = route[cur];
		}
		System.out.println(routes.size());
		
		for (int i = routes.size()-1; i >= 0; i--) {
			System.out.print(routes.get(i)+ " ");
		}
	}
	
	// start: 출발도시, end: 도착도시
	private static void dijkstra(int start, int end) {
		Queue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		cost = new int[N+1]; // 각 정점에 대한 최소 가중치 저장
		route = new int[N+1]; // 각 정점으로 출발한 정점 저장
		
		// 다익스트라 INFINITY으로 초기화
		Arrays.fill(cost, INFINITY);
		
		queue.offer(new Node(start, 0));
		cost[start] = 0;
		route[start] = 0; 
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curV = cur.vertex;
			int curCost = cur.cost;
			
			// 방문한 적 있으면 패스
			if(visited[curV]) continue;
			
			// 방문체크
			visited[curV] = true; 
			
			for (Node next : list[curV]) {
				
				// 방문하지 않았고 경유지+가중치 값이 최소 가중치보다 작으면 
				if(!visited[next.vertex] && cost[next.vertex] > curCost + next.cost) {
					cost[next.vertex] = curCost + next.cost;
					queue.offer(new Node(next.vertex, cost[next.vertex]));
					route[next.vertex] = curV;
				}
			}
		}
	}

}
