package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		// 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		int[] number = new int[N+1]; // 1번부터 사용
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			number[i] = Integer.parseInt(st.nextToken()); // 1,000보다 작거나 같은 자연수
		}
		
		// 메모이제이션
		int[] sum = new int[N+1];
		sum[0] = 0;
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + number[i];
		}
		
		// 합을 구해야 하는 구간이 주어진다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(sum[end] - sum[start-1]).append('\n');
		}
		System.out.println(sb);
		
	}

}
