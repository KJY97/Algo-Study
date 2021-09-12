//실행시간: 284 ms
//메모리: 25956 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	//연산의 개수
		
		//우선순위 = 작은 순자 순
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//자연수 - 추가, 0 - 가장 작은 값 출력
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			
			if(X > 0) pq.offer(X);
			else {
				if(pq.isEmpty()) 
					sb.append(0).append('\n');
				else
					sb.append(pq.poll()).append('\n');
			}
		}
		System.out.println(sb);
	}
}
