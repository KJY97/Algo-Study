package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
	
	/**
	 * 문제
	 *  조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램 작성하기
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 같은 수 중복 가능
	 *   - 고른 수열은 오름차순
	 * 
	 * 시간: 612 ms
	 * 메모리: 28732 kb
	 */
	private static int N, M;
	private static int result[], input[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1 ≤ M ≤ N ≤ 8
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		input = new int[N];
		
		// N개의 수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순으로 출력되어야 하므로..
		Arrays.sort(input);
		
		// 순열 시작
		permutation(0);
	}
	
	// 중복이 가능한 순열 함수
	public static void permutation(int idx) {
		if(idx == M) {
			// 출력
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			
			System.out.println();
			return ;
		}
		
		// 같은 수 중복 허용
		for (int i = 0; i < N; i++) {
			result[idx] = input[i];
			
			// 오름차순으로 출력되어야 하므로 이전 수보다 작으면 pass
			if(idx != 0 && result[idx-1] > result[idx]) continue;
			
			// 재귀 시작
			permutation(idx+1);
		}
	}

}
