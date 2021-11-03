// 실행시간: 564 ms
// 메모리: 44748 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N11404_플로이드 {

	static int[][] matrix;
	static int N, M;
	static int INF = 9999999;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO A에서 B로 가는데 필요한 비용의 최소값 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 2 ≤ n ≤ 100, 도시 개수
		M = Integer.parseInt(br.readLine()); // 1 ≤ m ≤ 100,000, 버스 개수
		
		// ---- 인접 행렬 초기화 ----
		matrix = new int[N+1][N+1]; // 1번도시부터 사용
		
		// 자기 자신한테 가는거는 0, 연결이 안되어 있으면 INF
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i != j && matrix[i][j] == 0) matrix[i][j] = INF;
			}
		}
		
		// ---- 버스 정보 입력 초기화 ----
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 버스 출발 도시
			int to = Integer.parseInt(st.nextToken()); // 버스 도착 도시
			int cost = Integer.parseInt(st.nextToken()); // 버스 비용 1<= cost <= 100,000
			
			// 인접행렬 입력
			matrix[from][to] = Math.min(matrix[from][to], cost);
		}
		
		// ---- 플로이드 워샬 알고리즘 사용 ----
		// 모든 정점에서 모든 정점으로의 최단 경로 구하기 = 플로이드 와샬 사용
		floyd();
		
		// --- 출력 ---
		// i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용. 갈 수 없다면 0 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void floyd() {
		
		// 경유 도시
		for (int city = 1; city <= N; city++) {
			
			// 출발 도시
			for (int from = 1; from <= N; from++) {
				
				if(city == from) continue;
				
				// 도착 도시
				for (int to = 1; to <= N; to++) {
					
					if(from == to || to == city) continue;
					
					if(matrix[from][to] > matrix[from][city] + matrix[city][to]) 
						matrix[from][to] = matrix[from][city] + matrix[city][to];
				}
			}
		}
		
		// INF가 있으면 0으로 처리
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(matrix[i][j] == INF) matrix[i][j] = 0;
			}
		}		
	}

}
