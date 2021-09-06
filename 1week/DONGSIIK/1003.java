//14160kb, 128ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws IOException {
		// 빠른 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스 수를 입력받기
		int T = Integer.parseInt(br.readLine());

		//테스트 케이스들을 입력받고, 가장 큰 정수값 찾아두기
		int[] tc = new int[T];
		int MAX = 0;
		
		for(int i=0;i<T;i++) {
			tc[i] = Integer.parseInt(br.readLine());
			MAX = Math.max(tc[i],MAX);
		}
		
		//DP로 0, 1을 호출하는 횟수 구하기
		int[] fibo0 = new int[MAX+1];
		int[] fibo1 = new int[MAX+1];
		fibo0[0] = 1;
		fibo1[1] = 1;
		
		for(int i=2;i<=MAX;i++) {
			fibo0[i] = fibo0[i-1]+fibo0[i-2];
			fibo1[i] = fibo1[i-1]+fibo1[i-2];
		}
		
		//출력
		for(int i=0;i<T;i++) {
			sb.append(fibo0[tc[i]]).append(' ').append(fibo1[tc[i]]).append('\n');
		}
		
		System.out.print(sb.toString());
		
	}

}