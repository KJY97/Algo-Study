//실행시간: 636 ms
//메모리: 151788 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;	//정점 개수, 간선 개수
	private static List<Integer>[] list;	//무향그래프
	private static boolean[] visited;		//정점 방문 체크
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수. 1 ≤ N ≤ 1,000
		M = Integer.parseInt(st.nextToken()); //간선의 개수. 0 ≤ M ≤ N×(N-1)/2
		
		list = new List[N+1]; //1번 정점부터 사용
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		//무향 그래프 - 양쪽 모두 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[start].add(end);
			list[end].add(start);
		}
		
		//연결 요소의 개수 구하기
		int ans = 0; //몇 번 탐색하는가?
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				ans++;
				BFS(i);
			}
		}
		System.out.println(ans);
	}
	
	//연결되어 있는 정점 탐색
	public static void BFS(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(vertex);
		visited[vertex] = true;	//방문 처리
		
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			
			for (Integer v : list[idx]) {
				if (!visited[v]) { //미방문 정점 체크
					visited[v] = true; //방문 처리
					queue.offer(v);
				}
			}
		}
	}
}
