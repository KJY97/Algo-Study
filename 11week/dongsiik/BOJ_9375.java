
// 제목 : 패션왕 신해빈
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/9375
// 메모리(kb) : 14192
// 실행시간(ms) : 132

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class BOJ_9375 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-->0) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==0) {
				sb.append(0).append('\n');
				continue;
			}
			
			HashMap<String, Integer> hMap = new HashMap<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				hMap.put(type, hMap.getOrDefault(type, 0)+1);
			}
			
			int answer = 1;
			for(String type : hMap.keySet()) {
				answer *= (hMap.get(type)+1);
			}
			
			sb.append(answer-1).append('\n');
		}
		
		System.out.println(sb);
	}
}