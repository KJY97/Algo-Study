package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070 {

	/**
	 * 문제
	 *  (1,1)와 (1,2)를 차지하고 있는 가로 방향의 파이프의 한쪽 끝을 (N,N)으로 이동시키는 방법의 개수 구하기
	 *   - 행과 열은 1부터 시작
	 *   - 각각의 칸은 빈 칸이거나 벽
	 *   - 파이프는 항상 빈 칸만 차지
	 *   - 파이프는 연속된 2개 칸 크기
	 *   - 파이프는 밀면서 회전시킬 수 있으며 3가지 방향 가능(→, ↘, ↓)
	 *   - 회전은 45도만 회전 가능
	 *   
	 *   - 방법의 수는 항상 1,000,000보다 작거나 같다.
	 *   - 이동시킬 수 없다면 0 출력
	 * 
	 * => 시간초과 발생.. map[N][N]이 벽인 경우 체크해야 한다!
	 * 
	 * 시간: 524 ms
	 * 메모리: 277584 kb 
	 */
	
	public static class Pipe {
		int x, y, dir; // 행, 열, 방향

		public Pipe(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	private static int N, map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 집의 크기. 3 ≤ N ≤ 16
		map = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				// 빈칸은 0, 벽 1
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 도착 위치가 벽이 있다면 이동시킬 수 없다!
		if(map[N][N] == 1) System.out.println(0);
		else BFS();
	}
	
	public static void BFS() {
		Queue<Pipe> queue = new LinkedList<>();
		// 방향 : 가로 0 세로 1 대각선 2
		queue.offer(new Pipe(1, 2, 0)); // (1,2)는 파이프 뒤쪽
		
		int cnt = 0; // 방법 개수 카운트
		while(!queue.isEmpty()) {
			Pipe cur = queue.poll();
			
			// (N, N)에 도착
			if(cur.x == N && cur.y == N) {
				cnt++;
				continue;
			}
			
			// 현재 방향이 가로 -> 가로 or 대각선
			if(cur.dir == 0) {
				if(isAvailable(cur, 0)) queue.offer(new Pipe(cur.x, cur.y+1, 0));
				if(isAvailable(cur, 2)) queue.offer(new Pipe(cur.x+1, cur.y+1, 2));
			}
			// 현재 방향이 세로 -> 세로 or 대각선 
			else if(cur.dir == 1) {
				if(isAvailable(cur, 1)) queue.offer(new Pipe(cur.x+1, cur.y, 1));
				if(isAvailable(cur, 2)) queue.offer(new Pipe(cur.x+1, cur.y+1, 2));
			}
			// 현재 방향이 대각선 -> 가로 or 세로 or 대각선 
			else if(cur.dir == 2) {
				if(isAvailable(cur, 0)) queue.offer(new Pipe(cur.x, cur.y+1, 0));
				if(isAvailable(cur, 1)) queue.offer(new Pipe(cur.x+1, cur.y, 1));
				if(isAvailable(cur, 2)) queue.offer(new Pipe(cur.x+1, cur.y+1, 2));
			}
		}
		
		System.out.println(cnt);
	}
	
	// 파이프 이동 가능한 칸인가?
	public static boolean isAvailable(Pipe cur, int dir) {
		switch (dir) {
		case 0: // 가로
			return cur.y+1 <= N && map[cur.x][cur.y+1] != 1;
		case 1: // 세로
			return cur.x+1 <= N && map[cur.x+1][cur.y] != 1;
		case 2: // 대각선
			return cur.x+1 <= N && cur.y+1 <= N && map[cur.x+1][cur.y+1] != 1 && map[cur.x][cur.y+1] != 1 && map[cur.x+1][cur.y] != 1;
		}
		return false;
	}
	
	

}
