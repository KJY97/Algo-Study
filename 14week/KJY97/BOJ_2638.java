package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {

	/**
	 * 문제
	 *  NxM 위 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간 구하기
	 *   - 하나의 치즈 격자의 4변 중 2변 이상이 실내온도(외부)와 접촉하면 한시간만에 녹아 없어진다.
	 *   - 치즈 내부의 공기는 상관없다
	 *   - map의 맨 가장자리에는 치즈가 놓이지 않는다.
	 *   
	 *  => BFS 사용
	 *  => 치즈 바깥 주변이 0으로 둘러 쌓여 있는지 판단
	 *  => 치즈가 없는 부분을 큐에 저장해서 바깥 부분만 탐색한다(치즈 안쪽 공간 저장X)
	 *  
	 * 시간: 280 ms
	 * 메모리: 48536 kb
	 */
	
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int N, M, map[][];
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 5 ≤ N, M ≤ 100
		N = Integer.parseInt(st.nextToken()); // 세로 격자 수
		M = Integer.parseInt(st.nextToken()); // 가로 격자 수
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(!checkRemainCheese()) {
			time++; 
			melt();
		}
		System.out.println(time);
	}
	
	// 치즈가 남아있다면 false, 없다면 true
	public static boolean checkRemainCheese() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	// 바깥 실내온도와 접촉한 치즈 녹이기
	public static void melt() {
		// 녹는 치즈 검사하는 용도(map 상태 복사)
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		// 치즈가 없는 부분을 queue에 저장
		queue.add(new Point(0,0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 벗어났거나, 이미 방문했으면 pass
				if(!isRange(nx, ny) || visited[nx][ny]) continue;
				// 0인 칸(=빈칸) 주위에 치즈가 있다면 카운트
				if(map[nx][ny] == 1) copy[nx][ny]++;
				
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
				}				
			}
		}
		
		// 저장해둔 기존 상태에서 녹은 치즈를 뺀다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j]-1 >= 2) // 2변 이상 접촉한 치즈가 녹는 치즈
					map[i][j] = 0; // 녹은 치즈 제거
			}
		}
	}
	
	// map 범위 안
	public static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
