// 실행시간: 76 MS
// 메모리 : 11660 KB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {

	private static int board[];
	
	public static void main(String[] args) throws IOException {
		// 보드판은 10x10이며 1 ~ 100번까지 있다.
		// 플레이어는 주사위의 수만큼 이동해야 한다. 단, 100번 칸을 넘어가게 된다면 이동할 수 없다.
		// 사다리는 올라가고, 뱀은 내려간다. => 뒤집어서 생각
		// TODO 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최소값 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사다리 수. 1 ≤ N ≤ 15
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수. 1 ≤ M ≤ 15
		
		board = new int[101];  // 1번부터 사용한다.
		
		// 모든 칸은 최대 하나의 사다리 or 뱀을 가진다.(겹치는 경우 없음)
		
		// 사다리 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// x번 칸에 도착하면, y번 칸으로 이동. x < y
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		
		// 뱀 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// u번 칸에 도착하면, v번 칸으로 이동. u > v
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			board[u] = v;
		}
		
		// 항상 100번 칸에 도착할 수 있는 입력만 주어진다.
		
		// 탐색 시작
		BFS();
	}
	
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		int[] count = new int[101]; // 주사위 굴린 횟수 저장
		boolean[] visited = new boolean[101];
		
		queue.add(1); // 1번 칸에서 시작
		count[1] = 0;
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll(); // 현재 접근한 위치
			
			if(cur == 100) {
				System.out.println(count[100]);
				break;
			}
			
			for (int dice = 1; dice <= 6; dice++) {
				int next = cur + dice; // 현재 위치에서 주사위를 굴려본다
				
				// 100번 칸을 넘어갔는지, 이전에 접근했는지 확인
				if(next > 100 || visited[next]) continue;
				
				visited[next] = true; // 방문 체크
			
				// 사다리 or 뱀을 만났다면 저장된 칸으로 이동
				if(board[next] != 0) {
					next = board[next];
					if(!visited[next]) {
						visited[next] = true;
						count[next] = count[cur] + 1; // 주사위 굴린 횟수 증가
						queue.add(next);
					}
				}
				// 사다리 or 뱀을 만나지 않은 경우
				else { 
					count[next] = count[cur] + 1; // 주사위 굴린 횟수 증가
					queue.add(next);
				}
			}
		}		
	}
}
