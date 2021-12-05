
// 제목 : Four Squares
// 티어 : 실버 4
// 링크 : https://www.acmicpc.net/problem/17626
// 메모리(kb) : 14504
// 실행시간(ms) : 144

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_17626 {
	
	public static void main(String args[]) throws IOException {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//numOfTerms[i] = j는 i를 표현할 수 있는 제곱수들의 최소 갯수가 j라는 뜻 
		int[] numOfTerms = new int[N+1];
		numOfTerms[0] = 0;
		for(int i=1;i<=N;i++) {
			numOfTerms[i] = 5;
		}
		
		//따져볼 제곱수들의 상한선
		int upperBound = (int) Math.sqrt(N);
		
		//각각의 제곱수들에 대해서 DP
		for(int i=1;i<=upperBound;i++) {
			int square = i*i;
			for(int j=0;j+square<=N;j++) {
				numOfTerms[j+square] = Math.min(numOfTerms[j+square], numOfTerms[j]+1);
			}
		}
		
		System.out.println(numOfTerms[N]);
	}

}