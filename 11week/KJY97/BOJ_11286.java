package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N11286_절대값힙 {
//	public static class Node implements Comparable<Node> {
//		int num;
//
//		public Node(int num) {
//			this.num = num;
//		}
//		
//		@Override
//		public int compareTo(Node o) { 
//			// 오름차순으로 정렬
//			int abs1 = Math.abs(this.num);
//			int abs2 = Math.abs(o.num);
//			
//			if(abs1 == abs2) // 절대값이 같으면 큰 수가 뒤로(오름차
//				return this.num > o.num ? 1 : -1;
//			return abs1 - abs2;
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1≤N≤100,000
		
		// 우선순위 큐 = 작은 숫자 순
		// Math.abs로 하면 시간이 오래 걸린다
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = o1 > 0 ? o1 : -o1;
			int abs2 = o2 > 0 ? o2 : -o2;
			
			if(abs1 == abs2) // 절대값이 같으면 큰 수가 뒤로(오름차
				return o1 > o2 ? 1 : -1;
			return abs1 - abs2;
		});
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine()); // 연산에 대한 정보 x
			
			if (x != 0) { 
				// 배열에 x값 추가
				pq.add(x);
				continue;
			}
			
			// 배열에서 절대값이 가장 작은 값 출력 & 제거
			if(pq.isEmpty()) System.out.println(0);
			else System.out.println(pq.poll());
		}
	}
}
