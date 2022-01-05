package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938 {

	/**
	 * 문제
	 *  예은이가 얻을 수 있는 최대 아이템 개수를 출력하기
	 *   - 각 지역은 일정한 길이 l의 길로 다른 지역과 연결되어 있고, 이 길은 양방향 통행이 가능
	 *   - 낙하산 지역 중심으로 수색 범위 m 이내 모든 지역 아이템 습득 가능
	 * 
	 * => 가중치가 있으므로 다익스트라 알고리즘 활용
	 * 
	 * 시간: 96 ms
	 * 메모리: 12256 kb
	 */
	private static class Area implements Comparable<Area> {
		int vertex, length; // 지역 번호, 거리

		public Area(int vertex, int length) {
			this.vertex = vertex;
			this.length = length;
		}

		@Override
		public int compareTo(Area o) {
			// 오름차순
			return this.length - o.length;
		}
	}
	
	private static List<Area> list[]; // 인접리스트
	private static int[] item; // 각 구열별 아이템 수 저장
	private static int N, M, R;
	private static int max = 0; // 최대 아이템 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 지역의 개수 n (1 ≤ n ≤ 100)
		M = Integer.parseInt(st.nextToken()); // 수색범위 m (1 ≤ m ≤ 15)
		R = Integer.parseInt(st.nextToken()); // 길의 개수 r (1 ≤ r ≤ 100)
		
		// 각 구역에 있는 아이템의 수 t (1 ≤ t ≤ 30)
		st = new StringTokenizer(br.readLine());
		item = new int[N+1];
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인접리스트 초기화
		list = new List[N+1]; // 지역번호 1번부터 시작 
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		// 길 양 끝에 존재하는 지역의 번호 a, b, 그리고 길의 길이 l (1 ≤ l ≤ 15)
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			// 무향그래프이므로 양방향
			list[a].add(new Area(b, l));
			list[b].add(new Area(a,l));
		}
		
		// 각 정점에 떨어졌을 때 수집 가능한 아이템 수 & 최대값 구하기
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		System.out.println(max);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Area> queue = new PriorityQueue<>();
		int[] distance = new int[N+1]; // start에서 vertex까지의 거리 길이 저장
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE); // 배열 초기화
		
		queue.offer(new Area(start, 0)); // 자기자신이므로 길이는 이동거리는 0
		distance[start] = 0;
		
		// 수색할 수 있는 모든 곳 탐색
		while(!queue.isEmpty()) {
			Area cur = queue.poll();
			int idx = cur.vertex;
			int dis = cur.length;
			
			// 방문 체크
			if(visited[idx]) continue;
			// 방문 처리
			visited[idx] = true;
			
			for (Area area : list[idx]) {
				// 방문하지 않은 정점 && 경유지+가중치 합이 distance에 저장된 최소 가중치보다 작다면 업데이트
				if(!visited[area.vertex] && distance[area.vertex] > dis + area.length) {
					distance[area.vertex] = distance[idx] + area.length;
					queue.offer(new Area(area.vertex, distance[area.vertex]));
				}
			}
		}
		
		// 가능한 수색범위 안에서 얻을 수 있는 아이템 수 구하기
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if(distance[i] <= M) sum += item[i];
		}
		
		max = Math.max(max, sum);
	}

}
