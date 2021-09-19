//실행시간: 564 ms
//메모리: 42600 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) 
				return this.start - o.start;
			else
				return this.end - o.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meet = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); //2^31-1보다 작거나 같은 자연수 또는 0
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			
			meet[i] = new Meeting(start, end);
		}
		
		//종료시간이 빠른 순으로 정렬
		Arrays.sort(meet);
		
		int max = 0; //겹치지 않는 회의 개수
		int end = 0; //회의 종료시점 저장
		
		//회의 시간이 겹치지 않게 회의실 사용할 수 있는 회의의 최대 개수 출력
		for (int i = 0; i < N; i++) {
			if(end <= meet[i].start) { 
				end = meet[i].end;
				max++; 
			}
		}
		System.out.println(max);
	}
}
