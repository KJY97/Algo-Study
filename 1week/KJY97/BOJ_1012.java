//실행시간: 108ms
//메모리: 13328kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static int[][] map;
	private static int M, N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 가로, 1 <= M <= 50 
			N = Integer.parseInt(st.nextToken()); // 세로, 1 <= N <= 50
			K = Integer.parseInt(st.nextToken()); // 배추 개수, 1 <= K <= 2500

			map = new int[N][M];
			
			//필요한 최소의 배추흰지렁이 마리 수 구하기
			int ans = 0;
			
			//map 초기화
			for (int i = 0; i < K; i++) 
			{
				st = new StringTokenizer(br.readLine());
				int Y = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			
			//인접해 있는 배추 = 인접 그래프가 몇개인가?
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (map[x][y] == 1) {
						dfs(x, y);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	
	public static void dfs(int x, int y) {
		//방문 처리
		map[x][y] = -1;
		
		//배추흰지렁이는 상하좌우 인접한 다른 배추로 이동이 가능
		for (int d = 0; d < 4; d++) {
			int curX = x + deltas[d][0];
			int curY = y + deltas[d][1];
			
			if(isAvailable(curX, curY) && map[curX][curY] == 1) {
				dfs(curX, curY);
			}
		} 
	}
	
    //조건: map의 범위를 벗어나지 않는다.
	public static boolean isAvailable(int curX, int curY) {
		return 0 <= curX && curX < N && 0 <= curY && curY < M;
	}
}
