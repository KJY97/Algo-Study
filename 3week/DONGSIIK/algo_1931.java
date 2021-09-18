import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algo_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//우선 순위 큐에 집어 넣기
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Meeting(start, end));
		}
		
		//회의 목록을 비교하면서 회의실을 빌려줄지 말지 결정
		int answer=0;
		int recentEndTime = Integer.MIN_VALUE;
		
		while(!pq.isEmpty()) {
			Meeting m = pq.poll();
			//이미 회의실 사용중인 경우 건너뜀
			if(m.start<recentEndTime) continue;
			
			//아니라면 회의 종료시간 및 개수 갱신
			recentEndTime = m.end;
			answer++;
		}
		
		//출력
		System.out.println(answer);
	}

	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		//회의 종료 시간이 빠를 수록, 같다면 시작 시간이 빠를 수록
		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			if(this.end!=o.end) return this.end-o.end;
			else return this.start-o.start;
		}
		
	}
}
