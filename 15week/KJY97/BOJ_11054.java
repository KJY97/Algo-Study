package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11054 {

	/**
	 * 문제 **
	 *  수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이 구하기
	 *   - 바이토닉 수열이란, 어떤 수를 중심으로 이전 수보다 증가하고 감소하는 수열을 말한다.
	 *   - {10, 20, 30, 25, 20}은 바이토닉 수열
	 *   - 그러나 {10, 20, 30, 40, 20, 30}은 바이토닉 수열이 아니다.
	 * 
	 * => 바이토닉 알고리즘을 사용하자...
	 * => LIS + LDS
	 * 
	 * 시간 : 108 ms
	 * 메모리 : 12104 kb
	 */
	private static int N, arr[];
	private static int lis_memo[], lds_memo[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 수열 크기. 1 ≤ N ≤ 1,000
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 원소. 1 ≤ Ai ≤ 1,000
		}
		
		lis_memo = new int[N];
		lds_memo = new int[N];
		
		LIS(); // 최장 증가 부분 수열 알고리즘
		LDS(); // 최장 감소 부분 수열 알고리즘
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int tmp = lis_memo[i] + lds_memo[i] - 1; // 중복되는 원소 빼기
			max = Math.max(max, tmp);
		}
		System.out.println(max);
		
	}
	
	private static void LDS() {
		for (int i = N-1; i >= 0; i--) {
			lds_memo[i] = 1;
			
			// 맨 뒤에서 i 이전 원소들을 탐색
			for (int j = N-1; j > i; j--) {
				// i번째 원소가 j번째 원소보다 크면서 i번째 memo가 j번째 memo+1 보다 작은 경우
				if(arr[j] < arr[i] && lds_memo[i] < lds_memo[j] + 1) {
					lds_memo[i] = lds_memo[j] + 1;
				}
			}
		}
	}

	private static void LIS() {
		for (int i = 0; i < N; i++) {
			lis_memo[i] = 1;
			
			// 0 ~ i 이전 원소들 탐색
			for (int j = 0; j < i; j++) {
				// j번째 원소가 i번째 원소보다 작으면서 i번째 memo가 j번째 memo+1 보다 작은 경우
				if(arr[j] < arr[i] && lis_memo[i] < lis_memo[j] + 1) {
					lis_memo[i] = lis_memo[j] + 1;
				}
			}
		}
	}

}
