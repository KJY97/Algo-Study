//실행시간: 136 ms
//메모리: 19260 kb 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//수빈이 위치
		int K = Integer.parseInt(st.nextToken());	//동생 위치
		
		//1초 후 걷는 경우 - ±1, 순간이동 - 2*N
		//수빈이가 동생을 찾을 수 있는 가장 빠른 시간 구하기
		
		//★ bfs로 풀기
		int[] arr = new int[2*K+1];
        
	    int cnt = 0;
		if(N >= K) 
			cnt = N-K;
		else
			cnt = bfs(N, K, arr);
        
		System.out.println(cnt);
	}
	
	public static int bfs(int N, int K, int[] cnt) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		
		int[] moveN = new int[3];	//-1 +1 *2
		cnt[N] = 0;
		
		while(!queue.isEmpty() && N != K) {
			N = queue.poll();
			
			moveN[0] = N-1;
			moveN[1] = N+1;
			moveN[2] = N*2;
			
			for (int i = 0; i < 3; i++) {
				//N 이동한 값이 범위를 벗어나는지 확인
				if(0 <= moveN[i] && moveN[i] < 2*K) {
					//미방문 확인
					if(cnt[moveN[i]] == 0) {
						queue.offer(moveN[i]);
						cnt[moveN[i]] = cnt[N]+1;	//1초 후 이동 저장
					}
				}
			}
		}
		return cnt[K];
	}
}
