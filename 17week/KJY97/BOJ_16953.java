package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

	/**
	 * 문제
	 *  정수 A를 B로 바꾸는데 필요한 연산의 최소값을 구하고 +1한 값 출력하기
	 *   - 가능한 연산은 2가지
	 *     1. 2 곱하기
	 *     2. 1을 수의 가장 오른쪽에 추가
	 *   - 만들 수 없는 경우 -1 출력
	 * 
	 * => 메모리 초과 발생
	 * => 만약 cur가 9억이라면 2번째 연산을 통해 90억+1이 되고 int 범위 벗어남
	 * => long 사용하기
	 * => 배열 크기로 long 사용이 불가하므로 class 생성
	 * 
	 * 시간: 100 ms
	 * 메모리: 14972 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1 ≤ A < B ≤ 10⁹
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		BFS(A,B);
	}
	
	public static void BFS(long start, long target) {
		Queue<Point> queue = new LinkedList<>();
		
		// start 수 부터 카운트
		queue.offer(new Point(start, 1));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.idx == target) {
				System.out.println(cur.cnt);
				return;
			}
			
			long twice = cur.idx * 2; // 2곱하기
			long add1 = cur.idx*10 + 1; // 1을 가장 오른쪽에 추가
			
			// B보다 작고 한번도 접근한 적 없다면 큐에 저장
			if(twice <= target) 
				queue.offer(new Point(twice, cur.cnt+1));
			
			if(add1 <= target) 
				queue.offer(new Point(add1, cur.cnt+1));
		}
		
		// 여기까지 왔다는 것은 만들 수 없다는 것
		System.out.println(-1);
	}
	
	public static class Point {
		long idx;
		int cnt;
		
		public Point(long idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
