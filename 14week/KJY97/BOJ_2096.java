package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {

	/**
	 * 문제
	 * 첫 줄에서부터 조건을 지키며 마지막 줄까지 내려가는데, 얻을 수 있는 최대 점수, 최소 점수의 합을 구하기
	 *  - N개의 줄에 0~9의 숫자 3개가 적혀있다.
	 *  - 조건: 바로 아래 수 or 대각선 수로만 이동 가능
	 * => DP, 메모이제이션 사용 
	 *  
	 * 시간: 352 ms
	 * 메모리: 56496 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 100,000
		int[][] map = new int[N+1][5]; // 1행부터 사용. 1~3열만 사용
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최고점수 찾기
		int[][] maxMemo = new int[N+1][5];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				int tmp = Math.max(maxMemo[i-1][j-1], maxMemo[i-1][j]);
				maxMemo[i][j] = Math.max(tmp, maxMemo[i-1][j+1]) + map[i][j];
			}
		}
		
		// 최저점수 찾기
		int[][] minMemo = new int[N+1][5];
		minMemo[1][1] = map[1][1];
		minMemo[1][2] = map[1][2];
		minMemo[1][3] = map[1][3];
		
		for (int i = 2; i <= N; i++) {
			minMemo[i][1] = Math.min(minMemo[i-1][1], minMemo[i-1][2]) + map[i][1];
			minMemo[i][2] = Math.min(Math.min(minMemo[i-1][1], minMemo[i-1][2]), minMemo[i-1][3]) + map[i][2];
			minMemo[i][3] = Math.min(minMemo[i-1][2], minMemo[i-1][3]) + map[i][3];
		}
		
		int max = Math.max(Math.max(maxMemo[N][1], maxMemo[N][2]), maxMemo[N][3]);
		int min = Math.min(Math.min(minMemo[N][1], minMemo[N][2]), minMemo[N][3]);
		
		System.out.println(max + " " + min);
	}

}
