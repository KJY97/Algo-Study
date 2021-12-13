package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_리스트ver {
	
	/**
	 * 문제
	 *  1번 정점 -> N번 정점으로 이동할 때 주어진 두 정점을 반드시 거치면서 최단 경로로 이동해야 한다.
	 *   - 방향성 없는 그래프(양방향 그래프)
	 *   - 한번 이동했던 간선 다시 이동 가능
	 *   - 경로 없을 때는 -1 출력
	 *   => 다익스트라 이용하기(리스트로 생성)
	 *   
	 * 풀이
	 *  INFINITY를 Integer.MAX_VALUE로 설정하면 
	 *  2 0
	 *  1 2
	 *  같은 경우에 -1이 아닌 2147483645이 출력됨(오버플로우 발생)
	 *  
	 * 시간 : 664 ms
	 * 메모리 : 67712 kb
	 */
	private static class Node implements Comparable<Node>{
		int vertex;
		int dis;
		
		public Node(int vertex, int dis) {
			this.vertex = vertex;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
	
	private static int N, E;
	private static List<Node> list[];
	private final static int INFINITY = 200000 * 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수. 2 ≤ N ≤ 800
		E = Integer.parseInt(st.nextToken()); // 간선 개수. 0 ≤ E ≤ 200,000
		
		list = new List[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			// start->end의 거리는 dis
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken()); // 1 ≤ dis ≤ 1,000
			
			// 방향성 없는 그래프이므로..
			list[start].add(new Node(end, dis));
			list[end].add(new Node(start, dis));
		}
		
		// 반드시 거쳐야 하는 정점 2개
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N
		int res1 = dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		// 1 -> v2 -> v1 -> N
		int res2 = dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		int ans = -1;
		if(res1 < INFINITY || res2 < INFINITY) ans = Math.min(res1, res2);
		
		System.out.println(ans);
	}

	// start에서 end까지의 최단 거리 찾는 알고리즘
	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		
		Arrays.fill(distance, INFINITY);
		
		queue.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curV = cur.vertex;
			int curDis = cur.dis;
			
			// 방문했다면 pass
			if(visited[curV]) continue;
			
			// 방문체크
			visited[curV] = true;
			
			for(Node next : list[curV]) {
				// 방문하지 않았고, 경유지+가중치 값이 최소 가중치보다 작다면
				if(!visited[next.vertex] && distance[next.vertex] > curDis + next.dis) {
					distance[next.vertex] = curDis + next.dis;
					queue.add(new Node(next.vertex, distance[next.vertex]));
				}
			}
		}
		
		return distance[end];
	}

}
