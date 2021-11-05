// 실행시간 ; 84 ms
// 메모리 : 11904 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1389_케빈베이컨 {
	
	static int N, M, Min, minUser;
	static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		// TODO 케빈 베이컨의 수가 가장 작은 사람 구하기
		// 케빈 베이컨 게임이란? 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 유저의 수. 2 ≤ N ≤ 100
		M = Integer.parseInt(st.nextToken()); // 친구 관계의 수. 1 ≤ M ≤ 5,000
		
		// 그래프 초기화
		list = new List[N+1]; // 1번부터 사용
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		// 친구 관계 입력
		// 무향 그래프. 유저는 1번부터 번호 가짐.
		// 친구가 한명도 없는 사람은 없다.(모든 사람은 연결되어 있다)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		
		Min = Integer.MAX_VALUE; // 가장 작은 케빈 베이컨 수
		minUser = 0; // 그 수를 가진 유저의 번호
		
		// 각 유저의 케빈 베이컨 수 & 가장 작은 수를 가진 유저 번호 구하기
		for (int i = 1; i <= N; i++) {
			BFS(i, new int[N+1]);
		}
		
		System.out.println(minUser);
	}
	
	static void BFS(int start, int[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		visited[start] = 1; // 방문처리. 
		// 내 자신부터 관계는 1로 처리한다.
		// 어차피 가장 작은 수를 가진 유저번호를 구하는 것이므로 상관없다.
		
		while(!queue.isEmpty()) {
			int curUser = queue.poll();
			
			for (Integer user : list[curUser]) {
				
				if(visited[user] != 0) continue;
				queue.offer(user);
				visited[user] = visited[curUser]+1;
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += visited[i];
		}
		
		if(Min > sum) {
			Min = sum;
			minUser = start;
		}
	}
}
