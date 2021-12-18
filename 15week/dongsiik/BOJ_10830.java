
// 제목 : 행렬 제곱
// 티어 : 골드 4
// 링크 : https://www.acmicpc.net/problem/10830
// 메모리(kb) : 14216
// 실행시간(ms) : 132

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_10830 {

	static final int MOD = 1000;
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] A = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pow(A,B);
		
	}
	
	static void pow(int[][] A, Long B) {
		
		int N = A.length;
		int[][] res = new int[N][N];
		for(int i=0;i<N;i++) res[i][i] = 1;
		
		while(B>0) {
			if(B%2==1) {
				res = matrixMultiply(res, A);
			}
			
			B/=2;
			A = matrixMultiply(A,A);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int[][] matrixMultiply(int[][] A, int[][] B){
		
		int N = A.length;
		int M = B.length;
		int L = B[0].length;
		
		int[][] res = new int[N][L];
		
		for(int i=0;i<N;i++) {
			for(int k=0;k<L;k++) {
				for(int j=0;j<M;j++) {
					res[i][k] += A[i][j]*B[j][k];
				}
				res[i][k] %= MOD;
			}
		}
		
		return res;
	}
	
}