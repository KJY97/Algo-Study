// 실행시간: 564 ms 
// 메모리: 63800 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {

	public static void main(String[] args) throws IOException {
		// TODO 메모장에서 비밀번호를 찾는 프로그램 만들기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 수. 1 ≤ N ≤ 100,000
		int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수. 1 ≤ M ≤ 100,000
		
		// 사이트 주소와 비밀번호 입력. 길이는 최대 20자 => HashMap 사용하기
		HashMap<String, String> hmap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String address = st.nextToken(); // 사이트 주소: 알파벳 소문자/대문자, 대시('-'), 마침표('.')로 구성. 중복없음
			String password = st.nextToken(); // 비밀번호: 알파벳 대문자로만 구성
			hmap.put(address, password);
		}
		
		// 비밀번호를 찾으려는 사이트 주소 입력 및 해당 비밀번호 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String find = br.readLine();
			sb.append(hmap.get(find)).append('\n');
		}
		System.out.println(sb);
	}

}
