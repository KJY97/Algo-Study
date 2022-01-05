// 제목 : N과 M(4)
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/15652
// 메모리(kb) : 17880
// 실행시간(ms) : 156

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
	
	//1부터 N까지 중 M개 고르기
	static int n,m;
	//선택된 숫자들
	static int[] selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		
		permutation(1,0);
		
		//출력
		System.out.println(sb);
		}
		
	static void permutation(int start, int count) {
		
		//다 골랐을 때
		if(count==m) {
			for(int i:selected) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//나머지
		for(int i=start;i<=n;i++) {
			selected[count] = i;
			permutation(i, count+1);
	}
	}
}