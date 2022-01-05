package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663 {

	/**
	 * 문제
	 *  조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램 작성하기
	 *   - N개의 자연수 중에서 M개를 고른 수열
	 *   - 사전 순으로 증가하는 순서로 출력
	 *   - 중복 불가
	 * 
	 * => 중복 순열이 발생하는 경우는 input을 오름차순으로 바꿨을 때 이전 값과 동일하면 발생한다.
	 * => 한번은 출력해야 하므로 result에 저장된 마지막 수와 그 다음 수가 일치하는지 체크한다.
	 *  만약 일치하면 pass
	 * 
	 * 시간: 1292 ms
	 * 메모리: 42436 kb
	 */
	private static int N, M;
	private static int input[], result[];
	private static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1 ≤ M ≤ N ≤ 8
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		input = new int[N];
		visited = new boolean[N];
		
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
			// 같은 수 중복 방지
			if(visited[i]) continue;
			// 중복 순열 방지
			// 이 값이 다음에 입력되는 input값과 같으면 중복 순열임을 알 수 있다.
			if(input[i] == num) continue;
			
			visited[i] = true;
			
			result[idx] = input[i];
			num = result[idx]; // result의 마지막에 저장된 값
			
			permutation(idx+1);
			
			visited[i] = false;
		}
	}

}
