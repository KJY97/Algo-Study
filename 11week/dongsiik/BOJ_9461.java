
// 제목 : 파도반 수열
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/9461
// 메모리(kb) : 14292
// 실행시간(ms) : 132

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_9461 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] pado = new long[101];
		pado[1] = pado[2] = pado[3] = 1;
		pado[4] = pado[5] = 2;
		for(int i=6;i<101;i++) {
			pado[i] = pado[i-1] + pado[i-5];
		}
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-->0) {
			int N = Integer.parseInt(br.readLine());
			
			
			
			sb.append(pado[N]).append('\n');
		}
		
		System.out.println(sb);
	}
}