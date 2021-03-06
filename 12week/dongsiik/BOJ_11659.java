
// 제목 : 구간합 구하기 4
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/11659
// 메모리(kb) : 53812
// 실행시간(ms) : 556

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//배열의 크기, 합을 구해야 하는 횟수
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//배열을 만들고, 값을 입력받으며 누적합을 저장
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value + arr[i-1];
		}
		
		//합을 구할 때마다
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			sb.append(arr[x2]-arr[x1-1]).append('\n');
		}
		
		//출력
		System.out.println(sb);
	}
}