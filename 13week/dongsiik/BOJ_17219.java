
// 제목 : 비밀번호 찾기
// 티어 : 실버 4
// 링크 : https://www.acmicpc.net/problem/17219
// 메모리(kb) : 57828
// 실행시간(ms) : 628

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class BOJ_17219 {
	
	public static void main(String args[]) throws IOException {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//전체 사이트 수, 찾을 사이트 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> pw = new HashMap<>(N);
		
		//해시맵에 사이트별로 비밀번호 넣기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			pw.put(site, password);
		}
		
		//해시맵에서 사이트별로 비밀번호 찾기
		for(int i=0;i<M;i++) {
			String site = br.readLine();
			sb.append(pw.get(site)).append('\n');
		}
		
		System.out.println(sb);
	}

}