// 제목 : N과 M (8)
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/15657
// 메모리(kb) : 16720
// 실행시간(ms) : 168

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ_15657 {
	
	//N개의 자연수 중 중복을 포함하여 비내림차순으로 M개 고르기
	static int N, M;
	//자연수, 고른 수
	static int[] arr;
	static int[] selected;
	static StringBuilder sb;
	
	public static void main(String args[]) throws IOException {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		selected = new int[M];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//오름차순 정렬
		Arrays.sort(arr);
		
		dfs(0,0);
		System.out.println(sb);

	}
	
	static void dfs(int start, int count) {
		//다 골랏을 때
		if(count==M) {
			for(int i=0;i<M;i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//하나 고르기
		for(int i=start;i<N;i++) {
			selected[count] = arr[i];
			dfs(i, count+1);
		}
	}
}