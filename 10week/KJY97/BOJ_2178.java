// 실행시간: 96 ms
// 메모리: 12356 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178_미로탐색 {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static void main(String[] args) throws Exception {
		// TODO (1, 1) --> (N, M)로 지나야 하는 최소의 칸 수 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 2 ≤ N, M ≤ 100
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		
		// 1 : 이동가능, 0 : 이동불가능
		map = new int[N+1][M+1]; //(1,1)에서 출발
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j+1] = tmp.charAt(j) - '0';
			}
		}
		
		// (N,M)에 도착
		BFS();
	}
	
	private static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		int[][] distance = new int[N+1][M+1];
		
		queue.offer(new Point(1, 1));
		distance[1][1] = 1; // 방문처리
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 벗어나거나, 방문처리되어있거나, 이동불가한 0이라면 패스
				if(!isRange(nx,ny) || distance[nx][ny] != 0 || map[nx][ny] == 0) continue;
				
				queue.offer(new Point(nx, ny));
				distance[nx][ny] = distance[cur.x][cur.y] + 1;
			}
		}
		System.out.println(distance[N][M]);
	}
	
	private static boolean isRange(int x, int y) {
		return x > 0 && x <= N && y > 0 && y <= M;
	}
	

}
