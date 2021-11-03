// 실행시간: 84 ms
// 메모리: 11508 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N15650_N과M2 {

	static int N, M;
	static int[] number, result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO: 1 ~ N 자연수 중에서 중복 없이 M개를 고른 수열. 증가하는 순서로 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//1 ≤ M ≤ N ≤ 8
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		for (int i = 1; i <= N; i++) {
			number[i-1] = i;
		}
		
		// 증가하는 순서로 출력
		permu(0);
	}
	
	static void permu(int idx) {
		
		// 기저조건: M개 만큼 선택
		if(idx == M) {
			// 출력
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			if(idx >= 1 && result[idx-1] > number[i]) continue; // 오름차순이 아니면 pass
			
			visited[i] = true;
			result[idx] = number[i];
			permu(idx+1);
			visited[i] = false;
		}
	}

}
