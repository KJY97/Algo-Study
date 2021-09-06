//15760kb, 164ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static boolean[][] farm;
	static int m,n;
	static int count;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String args[]) throws IOException {
		// 빠른 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스 수를 입력받기
		int T = Integer.parseInt(br.readLine());

		for(int t=0;t<T;t++) {
			
			//농장의 크기와 배추 수 입력받기
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			//농장 그리기
			farm = new boolean[m][n];
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			//dfs로 지렁이를 뿌리면서, 지렁이가 안 묻은 배추가 있다면 필요한 마리수 하나 증가
			count=0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(farm[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		
		System.out.print(sb.toString());
		
	}
	
	//델타 탐색을 이용한 dfs
	static void dfs(int x, int y) {
		farm[x][y] = false;
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx>=0 && nx<m && ny>=0 && ny<n && farm[nx][ny])
				dfs(nx,ny);
		}
	}

}