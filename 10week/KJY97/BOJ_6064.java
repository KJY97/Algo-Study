// 실행시간: 404 ms
// 메모리: 33412 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6064_카잉달력 { //

	public static void main(String[] args) throws Exception {
		// TODO 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			
			// 1 ≤ M, N ≤ 40,000, 
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int x = Integer.parseInt(st.nextToken()); // 1 ≤ x ≤ M
			int y = Integer.parseInt(st.nextToken()); // 1 ≤ y ≤ N
	
			/**
			 * [문제]
			 * 	- 첫번째 해 <1:1>부터 마지막 해<M:N>
			 *  - 다음 해를 표현할 때는 다음과 같은 규칙을 가진다.
			 *   : x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1
			 *   : y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1
			 *  - <x:y>는 몇 번째 해인지 구하라!
			 *  
			 * [풀이]
			 *  - 범위 때문에 완탐은 불가. 4만 * 4만 = 16억..
			 *  - x는 M번 주기, y는 N번 주기로 나온다
			 *    => <M:N>이 되는 해는 최소공배수가 되는 해
			 *    => 이걸 넘기면 유효하지 않다
			 *  - x = res % M, y = res % N
			 *  - 최소공배수 = a*b/gcd(a,b)
			 *  - gcd(=최대공약수)는 유클리드 호제법으로 구하기
			 */
			
			int res = -1; // 몇 번째 해
			int max = lcm(M,N); // 최소공배수
			for (int i = x; i <= max; i+=M) { // x 먼저 고려
				// y와 일치하는 거 찾기
				int sy = i % N;
				// 1. y = N이라면, sy의 값은 0
				// 2. y != N이라면 sy의 값이 y
				// 1 또는 2를 만족하면 된다!
				if((y==N && sy == 0) || (y != N && sy == y)) {
					res = i;
					break;
				}
			}
			System.out.println(res);
		}

	}
	static int gcd(int a, int b) {
		if (a % b == 0) return b;
		else return gcd(b, a %b);
	}
	
	static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}

}
