//실행시간: 312 ms
//메모리: 25412 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main { //최대 힙

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //1 ≤ N ≤ 100,000
		
		//우선순위 큐 사용 - 원래는 오름차순 정렬이지만 collections 사용하여 내림차순으로 정렬
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine()); // 자연수는 2^31보다 작다
			
			//0 가장 큰 값 출력. 그 외 추가
			if (X == 0) { 
				if (queue.isEmpty()) sb.append(0).append('\n');
				else sb.append(queue.poll()).append('\n');
			}
			else queue.add(X);
		}
		System.out.println(sb);
	}
}
