
// 제목 : 2*n 타일링 2
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/11727
// 메모리(kb) : 14324
// 실행시간(ms) : 124

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_11727 {
	
	static final int MOD = 10_007;

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점 수
		int N = Integer.parseInt(br.readLine());

		System.out.println(getAnswer(N+1));
	}
	
	static long getAnswer(int N) {
		
		long resMatrix[][] = {{1,0},{0,1}};
		long A[][] = {{1,2},{1,0}};
		
		while(N>0) {
			if(N%2==1) {
				resMatrix = matrixMultiply(resMatrix, A);				
			}
			
	            A = matrixMultiply(A, A);
	            N /= 2;
	        
		}
		
		
		return (resMatrix[1][0])%MOD;
	}
	
	static long[][] matrixMultiply(long[][] A, long[][] B) {
		int a = A.length;
		int b = B.length;
		int c = B[0].length;
		
		long[][] result = new long[a][c];
		
		for(int i=0;i<a;i++) {
			for(int k=0;k<c;k++) {
				for(int j=0;j<b;j++) {
					result[i][k] = (result[i][k] + A[i][j]*B[j][k])%MOD;
				}
			}
		}
	    
	    return result;
	}
}