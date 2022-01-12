package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080 {

	/**
	 * 문제
	 *  행렬 A를 행렬 B로 바꾸는데 필요한 연산의 회수의 최소값 구하기
	 *   - 0과 1로만 이루어짐
	 *   - 행렬 변환 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것
	 *   - A를 B로 바꿀 수 없다면 -1
	 *   
	 * 시간: 80 ms
	 * 메모리: 11636 kb 
	 */
	private static int A[][], B[][];
	private static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1 <= N, M <= 50
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		// 행렬 A 초기화
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 행렬 B 초기화
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}
			
		int cnt = 0; // 뒤집는 연산 횟수 카운트
		for (int i = 0; i <= N-3; i++) {
			for (int j = 0; j <= M-3; j++) {
				// 맨 왼쪽 위를 비교 
				if(A[i][j] != B[i][j]) {
					flip(i,j);
					cnt++;
				}
			}
		}
		
		if(isSame()) System.out.println(cnt);
		else System.out.println(-1);
	}
	
	// 3×3 크기만큼 바꾸기
	public static void flip(int x, int y) {
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				if(A[i][j] == 0) A[i][j] = 1;
				else A[i][j] = 0;
			}
		}
	}
	
	// 바뀐 A가 B와 동일한지 체크
	public static boolean isSame() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A[i][j] != B[i][j]) return false;
			}
		}
		return true;
	}
}
