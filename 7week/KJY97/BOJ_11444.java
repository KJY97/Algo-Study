// 실행시간: 84 ms
// 메모리: 11508 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11444_피보나치수6 {

	static long MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		// TODO N이 주어질 때, N번째 피보나치 수를 구하시오. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine()); // 1 <= n <= 1,000,000,000,000,000,000

		// 행렬을 이용한 방법 사용
		fibo(N-1);
	}
	
	static void fibo(long N) {
		long[][] arr = {{1,0}, {0,1}};
		long[][] base = {{1, 1}, {1, 0}};
		
		while(N > 0) {
			
			if(N%2 == 1) {
				arr = Multiply(arr, base);
			} 
			
			base = Multiply(base, base);
			
			N /= 2;
		}
		System.out.println(arr[0][0]);
	}

	private static long[][] Multiply(long[][] a, long[][] b) {
		long[][] result = new long[2][2];
		
		// 행렬 곱셈은 행렬의 가로 * 세로
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					result[i][j] += a[i][k] * b[k][j];
					result[i][j] %= MOD;
				}
				
			}
		}
		return result;
	}
	
	

}
