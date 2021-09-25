//실행시간: 84 ms
//메모리: 11488 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //1 ≤ n ≤ 1,000
		
		//2xN 크기 직사각형 1x2, 2x1 타일로 채우는 방법의 수 구하기
		//N을 1,2로 더하기
		int[] D = new int[N+1]; 
		D[0] = 1; //점화식을 맞추기 위해 1로 초기화
		D[1] = 1;
		
		// 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력
		for (int i = 2; i <= N; i++) {
			D[i] = (D[i-1] + D[i-2]) % 10007;
		}
		System.out.println(D[N]);
	}
}
