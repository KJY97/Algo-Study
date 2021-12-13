package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9461_파도반수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			// P(N)을 출력
			// P(N)은 나선에 있는 정삼각형의 변의 길이
			// int로 하면 초과가 발생하므로 long 사용
			int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 100
			
			if(N < 4) {
				System.out.println(1);
				continue;
			}
			
			// DP 이용하기 - 메모이제이션
			long[] memo = new long[N+1]; // 1번부터 사용
			memo[1] = memo[2] = memo[3] = 1;
			for (int i = 4; i <= N; i++) {
				memo[i] = memo[i-3] + memo[i-2];
			}
			System.out.println(memo[N]);
		}
	}

}
