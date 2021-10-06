// 실행시간: 236 ms
// 메모리: 23336 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 삼각형 크기. (1 ≤ n ≤ 500
		int[][] triangle = new int[N+1][];	// 1층부터 사용 (0층 사용x)
		
		// 삼각형 이루는 정수 입력 초기화
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()); // 0 <= num <= 9999
			triangle[i] = new int[i+2];
			for (int j = 1; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		// 삼각형 위층에서 아래층으로 내려올 때, 선택된 수의 합의 최대값은?
		// 현재 층에서 선택된 수의 대각선 왼쪽, 오른쪽만 선택 가능
		// DP 방식
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
			}			
		}
		
		// 맨 아래층에서 합이 최대값인 것 찾기
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, triangle[N][i]);
		}
		
		System.out.println(max);

	}
}
