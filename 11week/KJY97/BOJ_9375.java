package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N9375_패션왕 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 최대 100

		for (int test_case = 0; test_case < T; test_case++) {
			// 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
			// 같은 이름을 가진 의상은 존재하지 않는다
			// 알몸이 아닌 상태로 의상을 입을 수 있는 경우의 수 구하기
			
			int N = Integer.parseInt(br.readLine()); // 의상의 수
			StringTokenizer st;
			HashMap<String, Integer> map = new HashMap<>(); // 의상종류 : 개수
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 의상 이름 필요없음
				
				String kind = st.nextToken();
				
				if(!map.containsKey(kind))
					map.put(kind, 1);
				else
					map.put(kind, map.get(kind)+1);
			}
			
			// 각 종류에 null 값이 들어갔다고 생각하기 -> headgear : hat, turban, null
			// 3C1 * 2C1 - 1(null * null)
			int ans = 1;
			for (int val : map.values()) {
				ans *= (val+1);
			}
			
			System.out.println(ans - 1);
		}
	}

}
