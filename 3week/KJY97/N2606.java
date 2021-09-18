//실행시간: 80 ms
//메모리: 11700 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수 = 정점 수. 1 <= N <= 100 
		int E = Integer.parseInt(br.readLine()); //네트워크 상 직접 연결되어 있는 컴퓨터 쌍 수 = 간선 수
		
		//-----무향그래프 만들기------//
		
		//리스트로 만들기
		List<Integer>[] list = new List[N+1]; //1번부터 시작
		for (int i = 0; i < N+1; i++) {
			list[i] = new LinkedList<>();
		}
		
		//간선 정보 받기
		StringTokenizer st;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[start].add(end);
            list[end].add(start);
		}
		
		//------1번 컴퓨터를 통해 바이러스 걸리게 되는 컴퓨터 수 출력---------//
		//바이러스는 연결되어 있는 모든 컴퓨터에 퍼진다. - BFS 사용
		int ans = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1]; //1번부터 번호 시작
		
		queue.offer(1);	//1번 컴퓨터에서 탐색 시작
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Integer vertex : list[cur]) {
				if(!visited[vertex]) {	//미방문한 정점 체크
					ans++;		//방문하는 정점 수 카운트
					queue.offer(vertex);
					visited[vertex] = true;	//방문 처리
				}
			}
		}
		System.out.println(ans);
	}
}
