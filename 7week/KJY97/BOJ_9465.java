// 실행시간: 856 ms
// 메모리: 123760 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9465_스티커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			// TODO 점수의 합이 최대가 되면서 서로 변을 공유하지 않는 스티커 집함 구하기
			
			int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100,000
			int[][] sticker = new int[2][n+1]; // 1번부터 사용
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken()); // 0 <= score <= 100
				}
			}
			
			/** 풀이
			 * 1. 변을 공유하면 안되므로 대각선 방향의 스티커 사용
			 * 2. 스티커는 1칸 뒤 대각선, 2칸 뒤 대각선까지 사용하며 둘 중 큰 값을 현재 스키커 값과 더한다.
			 * 	 - 3칸 뒤 대각선 스티커는 \/\ 이런 모양으로 접근이 가능하므로 최대 2칸 뒤 까지 접근 가능
			 * 3. 다이나믹을 사용한다.
			 */
			
			int[][] memo = new int[2][n+1];
			memo[0][0] = memo[0][1] = memo[1][0] = 0;
			memo[0][1] = sticker[0][1]; 
			memo[1][1] = sticker[1][1];
			
			for (int i = 2; i <= n; i++) {
				memo[0][i] = Math.max(memo[1][i-1], memo[1][i-2]) + sticker[0][i];
				memo[1][i] = Math.max(memo[0][i-1], memo[0][i-2]) + sticker[1][i];
			}
			
			System.out.println(Math.max(memo[0][n], memo[1][n]));
		}
	}
}
