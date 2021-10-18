// 제목 : 피보나치 수 6
// 티어 : 골드 3
// 링크 : https://www.acmicpc.net/problem/11444
// 메모리(kb) : 14216
// 실행시간(ms) : 136

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	
	public class Main {
		
		static final int divisor = 1000000007;
		
		public static void main(String[] args) throws NumberFormatException, IOException {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			long n = Long.parseLong(br.readLine());
			
			
			
			//출력
			System.out.println(getFibo(n));
		}
		
		//행렬 곱하기
		static long[][] matrixMultiply(long[][] A, long[][] B) {
			int a = A.length;
			int b = B.length;
			int c = B[0].length;
			
			long[][] result = new long[a][c];
			
			for(int i=0;i<a;i++) {
				for(int k=0;k<c;k++) {
					for(int j=0;j<b;j++) {
						result[i][k] = (result[i][k] + A[i][j]*B[j][k])%divisor;
					}
				}
			}
		    
		    return result;
		}
		
		//피보나치 점화식을 행렬 연산으로 변경 후 계산
		static long getFibo(long n) {
			long resMatrix[][] = {{1,0},{0,1}};
			long A[][] = {{1,1},{1,0}};
			
			//분할 정복을 이용한 거듭제곱
			while(n>0) {
		        if (n % 2 == 0) {
		            A = matrixMultiply(A, A);
		            n /= 2;
		        }
		        else {
		            resMatrix = matrixMultiply(resMatrix, A);
		            n--;
		        }
			}
			
			
			return resMatrix[1][0];
		}
	}
