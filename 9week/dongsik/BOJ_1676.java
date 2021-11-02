
// 제목 : 팩토리얼 0의 개수
// 티어 : 실버 4
// 링크 : https://www.acmicpc.net/problem/1676
// 메모리(kb) : 14192
// 실행시간(ms) : 132

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1676 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		int pow = 5;
		while(pow<=N) {
			answer += N/pow;
			pow *= 5;
		}
		
		System.out.println(answer);
	}
}