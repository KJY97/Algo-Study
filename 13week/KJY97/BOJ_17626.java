// 실행시간: 108 MS
// 메모리: 12132 KB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17626 {

	public static void main(String[] args) throws IOException {
		// TODO 자연수 N이 주어질 때, N을 최소 개수의 제곱수 합으로 표현하라.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 50,000
		
		// dp - 메모이제이션 사용
		// 제곱수들의 최소 개수를 저장한다.
		int []memo = new int[N+1]; // N번까지 사용하기 위해서 +1
		memo[0] = 0; memo[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE; // 최소값 변수 초기화
			
			// 첫번째 제곱수
			// 무조건 i의 루트값이 제곱수가 되는 것은 아니기 때문에 -1를 해주면서 최소개수 찾기
			for (int j = (int)Math.sqrt(i); j > 0; j--) { 
				int tmp = i - (j*j); // 첫번째 제곱수를 제외한 나머지 값
				min = Math.min(memo[tmp], min);
			}
			memo[i] = min + 1;
		}
		System.out.println(memo[N]);
	}
}