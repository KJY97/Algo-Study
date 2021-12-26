
// 제목 : 서강그라운드
// 티어 : 골드 4
// 링크 : https://www.acmicpc.net/problem/14938
// 메모리(kb) : 14756
// 실행시간(ms) : 160

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_14938 {
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//지역 수, 수색범위, 도로 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		//지역별 아이템 수
		st = new StringTokenizer(br.readLine());
		int[] items = new int[N];
		for(int i=0;i<N;i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		//인접행렬로 표현한 그래프
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) map[i][j] = 15000;
			}
		}
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = l;
		}
		
		//플로이드 워셜
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				for(int k=0;k<N;k++) {
					map[i][k] = Math.min(map[i][k], map[i][j]+map[j][k]);
				}
			}
		}
		
		//시작점에서 얻을 수 있는 최대 아이템 수
		int answer = 0;
		
		//시작지마다
		for(int i=0;i<N;i++) {
			int current = 0;
			//거리가 가까운 지점에서 얻을 수 있는 아이템 수 더하기
			for(int j=0;j<N;j++) {
				if(map[i][j]<=M) {
					current += items[j];
				}
			}
			//최댓값과 비교 후 갱신
			answer = Math.max(answer, current);
		}
		
		System.out.println(answer);
	}
}