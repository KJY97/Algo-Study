//실행시간: 292 ms
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
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		//자연수 - 추가, 0 - 가장 작은 값 출력
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			
			if(X > 0) priorityQueue.offer(X);
			else {
				//int형으로 null 체크 불가.
				Integer num = priorityQueue.poll();
				
				//null은 객체가 아니여서 equals로 비교 불가
				if(num == null) num = 0;

				sb.append(num).append('\n');
			}
		}
		System.out.println(sb);
	}
}
