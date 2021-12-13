package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11403_경로찾기 {

	public static void main(String[] args) throws IOException {
		// 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 정점의 개수. 1 ≤ N ≤ 100
		
		// i->j 간선이 존재하면 1, 없다면 0
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 모든 정점에서 모든 정점으로의 경로 구하기(거쳐가는 정점도 포함) -> 플로이드 와샬
		// i->j로 가는 경로 구하기
		// 즉, i->k->j
		for (int k = 0; k < N; k++) { // 거쳐가는 정점
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][k] == 1 && matrix[k][j] == 1) matrix[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
