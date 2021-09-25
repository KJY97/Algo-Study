//실행시간: 80 ms
//메모리: 11488 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			
			//정수 N을 1, 2, 3의 합으로 나타내는 방법의 수 구하기
			int N = Integer.parseInt(br.readLine()); // 1 <= N < 11
			int[] D = new int[N+2];	//동적 계획법 사용
			
			//초기화
			D[0] = 1; //점화식 맞추기 위해서 1로 초기화
			D[1] = 1; D[2] = 2;
			
			for (int i = 3; i <= N; i++) {
				D[i] = D[i-3] + D[i-2] + D[i-1];
			}
			
			System.out.println(D[N]);
		}
	}
}
