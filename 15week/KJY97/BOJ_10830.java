package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {

	/**
	 * 문제
	 *  크기가 N*N인 행렬 A의 B제곱을 구하는 프로그램 작성하기
	 *   - A^B의 각 원소를 1000으로 나눈 나머지 출력
	 *   
	 * => A⁶ = A³ * A³ = (A² * A¹) * (A² * A¹) = ((A¹ * A¹) * A¹) * ((A¹ * A¹) * A¹)
	 * => A⁹ = A⁴ * A⁴ * A¹ = (A² * A²) * (A² * A²) * A¹ = ((A¹ * A¹) * (A¹ * A¹)) * ((A¹ * A¹) * (A¹ * A¹)) * A¹
	 * => 분할정복..
	 * => A에 값을 넣을 때도 MOD로 나머지 처리해줘야 함..(1000이 들어오는 경우 처리)
	 * 
	 * 시간 : 76 ms
	 * 메모리 : 11544 kb
	 */
	private static final int MOD = 1000;
	private static int N, A[][];
	private static long B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 2 ≤ N ≤  5
		B = Long.parseLong(st.nextToken()); // 1 ≤ B ≤ 100,000,000,000
		
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()) % MOD; // 0 <= 원소 <= 1000
			}
		}
		
		// A의 B제곱
		int[][] ans = powMatrix(A, B);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	// 행렬 제곱
	public static int[][] powMatrix(int[][] arr, long cnt) {
		// 지수(cnt)가 1일 때 행렬 A 반환
		if(cnt == 1L) {
			return arr;
		}
		
		// 지수를 계속 2로 분할하기
		int[][] res = powMatrix(arr, cnt/2);
		
		res = multiMatrix(res, res);
		
		// 홀수면 A¹를 곱해준다.
		if(cnt % 2 == 1L) {
			res = multiMatrix(res, A);
		}
		
		return res;
	}
	
	// 행렬 곱
	public static int[][] multiMatrix(int[][] arr1, int[][] arr2) {
		
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					tmp[i][j] += arr1[i][k] * arr2[k][j];
					tmp[i][j] %= MOD;
				}
			}
		}
		return tmp;
	}

}
