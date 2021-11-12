
// 제목 : 동전 0
// 티어 : 실버 2
// 링크 : https://www.acmicpc.net/problem/11047
// 메모리(kb) : 14384
// 실행시간(ms) : 132

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_11047 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		//내림차순으로 바꿔서 입력받기
		for(int i=N-1;i>=0;i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		
		for(int i=0;i<N;i++) {
			answer += K/coins[i];
			K %= coins[i];
		}
		
		System.out.println(answer);
	}
}