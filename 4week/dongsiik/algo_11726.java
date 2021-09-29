//14364, 128

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo_11726 {

	// 나머지를 구할 때 나누는 수
	static final int divisor = 10_007;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		// 출력
		System.out.println(getFibo(n+1));
	}

	static long[][] matrixMultiply(long[][] A, long[][] B) {
		int n = A.length;
		int m = B.length;
		int l = B[0].length;
		
		long[][] res = new long[n][l];
		
		for(int i=0;i<n;i++) {
			for(int k=0;k<l;k++) {
				for(int j=0;j<m;j++) {
					res[i][k] = (res[i][k] + (A[i][j]*B[j][k])%divisor)%divisor;
				}
			}
		}
		
		return res;

	}

	static long getFibo(long n) {
		// 행렬을 이용한 피보나치 계산
		long resMatrix[][] = { { 1, 0 }, { 0, 1 } };
		long A[][] = { { 1, 1 }, { 1, 0 } };

		// 분할 정복을 이용한 거듭제곱
		while (n > 0) {
			if (n % 2 == 0) {
				A = matrixMultiply(A, A);
				n /= 2;
			} else {
				resMatrix = matrixMultiply(resMatrix, A);
				n--;
			}
		}

		// F_n 출력
		return resMatrix[1][0];
	}
}
