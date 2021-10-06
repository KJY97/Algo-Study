// 실행시간: 76 MS
// 메모리: 11500 KB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//A, B, C 모두  2,147,483,647 이하 자연수 -> long 사용
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());	//곱한 횟수
		int C = Integer.parseInt(st.nextToken());	//나누는 수
		
		// 자연수 A를 B번 곱한 수 알기.
		System.out.println(getExpo_divie(A,B,C));
	}
	
	//일반 반복문 사용 O(N) -> 시간초과
	static long getExpo_iterative(int C, int n, int MOD) {
		long res = 1;

		for (int i = 0; i < n; i++) {
			res = res * C  % MOD;
		}
		return res;
	}

	//시간 제한은 0.5초이므로 분할정복 사용 O(log₂N)
	static long getExpo_divie(int C, int n, int MOD) {
		//A x A x A x A x A = (A³)² = (A² x A)²
		//n이 짝수면 지수는 n/2, 홀수면 (n-1)/2
		
		if (n == 1) return C % MOD;
		
		if (n % 2 == 0) {
			long res = getExpo_divie(C, n/2, MOD);
			return (res * res) % MOD;
		} else {
			long res = getExpo_divie(C, (n-1)/2, MOD);
			return (((res * res) % MOD) * C) % MOD;
		}
	}
}
