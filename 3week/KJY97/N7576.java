//실행시간: 544 ms
//메모리: 121144 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()); //2 ≤ M,N ≤ 1,000

		board = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		//1 익은 토마토, 0 익지 않은 토마토, -1 토마토가 없음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == 1) //탐색할 익은 토마토 저장
					queue.add(new int[] {i, j});
			}
		}
		
		//---------- BFS 시작------------//
		
		//보관 후 하루가 지나면, 익지 않은 토마토는 인접한 익은 토마토에 영향 받음(대각선 제외)
		//최소 며칠이 지나야 모든 토마토가 익을까? (저장될 때 모두 익은 상태라면 0, 모두 익지 못한다면 -1)
		
		int size = queue.size(); //저장될 때의 익은 토마토 개수
		int cnt = 0;
		int day = 0;			//저장될 때 모두 익었다면 0
		
		//익은 토마토와 인접한 익지 않은 토마토 탐색
		while(!queue.isEmpty()) {
			
			if (cnt == size) {
				size = queue.size(); //하루 치의 익은 토마토 개수
				cnt = 0;			 //익지 않은 토마토 탐색을 완료한 익은 토마토 수 
				day++;				 //하루가 지남
			}
			
			int[] ripeTomato = queue.poll();
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int curX = ripeTomato[0] + deltas[i][0];
				int curY = ripeTomato[1] + deltas[i][1];
				
				//범위 안 & 익지 않은 토마토
				if (isRange(curX, curY, N, M)&& board[curX][curY] == 0) {
					board[curX][curY] = 1;	//인접해 있기 때문에 영향 받음
					queue.add(new int[] {curX, curY}); //익은 토마토는 큐에 저장
				}
			}
		}
		
		//모두 익었는지 확인
		if(checking(N, M)) 
			System.out.println(day);
		else
			System.out.println(-1);
	}
	
	//조건: 범위 안
	public static boolean isRange(int x, int y, int N, int M) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	//하나라도 안 익었다면(=0) false 반환
	public static boolean checking(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
