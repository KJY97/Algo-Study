//실행시간: 100 ms
//메모리: 11860 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N2407_조합 { // nCm 출력

	static int N, M;
	static BigInteger[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// m ≤ n
		N = Integer.parseInt(st.nextToken()); // 5 ≤ n ≤ 100
		M = Integer.parseInt(st.nextToken()); // 5 ≤ m ≤ 100
		
		// long으로 해도 오버플로우 발생 -> long보다 더 큰 무한대 정수형 BigInteger 클래스 사용
		memo = new BigInteger[N+1][N+1]; // 1번부터 사용
		
		// 조합은 메모이제이션으로 표현 가능.
		// 초기화
		memo[0][0] = memo[1][0] = memo[1][1] = BigInteger.ONE;
		
		// DP 방식. nCm = n-1Cm-1 + n-1Cm
		for (int n = 2; n <= N; n++) {
			for (int r = 0; r <= n; r++) {
				if (n == r || r == 0) {
					memo[n][r] = BigInteger.ONE; // 1
				}else {
					memo[n][r] = memo[n-1][r-1].add(memo[n-1][r]); 
				}
			}
		}
		
		System.out.println(memo[N][M]);
	}
}
