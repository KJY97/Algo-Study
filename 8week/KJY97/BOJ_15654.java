// 실행시간: 1972 ms
// 메모리: 78608 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15654_N과M_5 {

	static int N, M;
	static int[] number, result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO: N개 자연수 중에서 M개를 고른 수열. 증가하는 순서로 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//1 ≤ M ≤ N ≤ 8
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken()); // 10,000보다 작은 자연수
		}
		
		Arrays.sort(number); // 사전순으로 출력하기 위해서
		
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
			
			visited[i] = true;
			result[idx] = number[i];
			permu(idx+1);
			visited[i] = false;
		}
	}

}
