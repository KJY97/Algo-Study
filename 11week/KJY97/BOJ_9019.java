package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9019_DSLR {
	
	public static class Point {
		int num;
		String command;
		
		public Point(int num, String command) {
			this.num = num;
			this.command = command;
		}
		
		public int D() {
			// D: 2A mod 10000를 레지스터에 저장
			return (num * 2) % 10000;
		}
		
		public int S() {
			// S: A-1를 저장. A가 0이면 9999를 대신 저장
			if(num == 0) return 9999;
			return num - 1;
		}
		
		public int L() {
			// L: A의 각 자릿수 왼편으로 회전해서 저장
			return num % 1000 * 10 + num/1000;
		}
		
		public int R() {
			// R: A의 각 자릿수 오른편ㅇ로 회전해서 저장
			return num % 10 * 1000 + num / 10;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			// 0 이상 10,000 미만
			int A = Integer.parseInt(st.nextToken()); // 레지스터의 초기 값(십진수)
			int B = Integer.parseInt(st.nextToken()); // 최종 값
			
			// TODO A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력
			
			Queue<Point> queue = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			
			queue.add(new Point(A, ""));
			visited[A] = true;
			
			while(!queue.isEmpty()) {
				Point cur = queue.poll();

				if (cur.num == B) {
					System.out.println(cur.command);
					break;
				}
				
				// 명령어 수행 & 방문하지 않은 숫자라면..
				if(!visited[cur.D()]) {
					queue.add(new Point(cur.D(), cur.command+"D"));
					visited[cur.D()] = true;
				}
				
				if(!visited[cur.S()]) {
					queue.add(new Point(cur.S(), cur.command+"S"));
					visited[cur.S()] = true;
				}
				
				if(!visited[cur.L()]) {
					queue.add(new Point(cur.L(), cur.command+"L"));
					visited[cur.L()] = true;
				}
				
				if(!visited[cur.R()]) {
					queue.add(new Point(cur.R(), cur.command+"R"));
					visited[cur.R()] = true;
				}
			}
		}
	}

}
