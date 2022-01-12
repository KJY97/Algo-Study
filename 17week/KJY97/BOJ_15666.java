package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666 {

	/**
	 * 문제
	 *  조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램 작성하기
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 사전 순으로 증가하는 순서로 출력
	 *   - 같은 수 중복 선택 가능
	 *   - 중복 순열 출력 불가능
	 * 
	 * 시간: 432 ms
	 * 메모리: 17160 kb
	 */
	
	private static int N, M;
	private static int input[], result[];
	
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
		
		// 사전 순으로 출력해야 하므로
		Arrays.sort(input);
		
		// 순열 시작
		permutation(0);
	}
	
	public static void permutation(int idx) {
		if(idx == M) {
			
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			
			return ;
		}
		
		int num = 0;
		for (int i = 0; i < N; i++) {
			// 중복 순열 출력 방지
			// num 값이 다음에 입력되는 input값과 같으면 중복 순열임을 알 수 있다.
			if(input[i] == num) continue;
			
			// 오름차순이 아니면 pass
			if(idx > 0 && result[idx-1] > input[i]) continue;
			
			result[idx] = input[i];
			num = result[idx]; // result의 마지막에 저장된 값
			
			permutation(idx+1);
		}
	}
}