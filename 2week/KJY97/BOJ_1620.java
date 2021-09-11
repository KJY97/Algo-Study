//실행시간: 484 ms
//메모리: 61900 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//1<=N,M<=1000000
		int N = Integer.parseInt(st.nextToken());	//포켓문의 개수
		int M = Integer.parseInt(st.nextToken());	//문제 개수
	
		//hashmap - 탐색시간 O(1)
		Map<String, Integer> hashmap1 = new HashMap<>(); 
		Map<Integer, String> hashmap2 = new HashMap<>(); 
		
		//포켓몬 정보 저장
		for (int i = 0; i < N; i++) {
			String name = br.readLine(); //최대 20글자
			hashmap1.put(name, i+1);
			hashmap2.put(i+1, name);
		}
		
		//맞춰야 하는 문제 - 알파벳:포켓몬번호, 숫자:해당 번호 문자
		for (int i = 0; i < M; i++) {
			String problem = br.readLine();
			
			//첫 글자 대문자, 나머지 소문자이므로
			if('A'<=problem.charAt(0) && problem.charAt(0) <= 'Z') {
				sb.append(hashmap1.get(problem)).append("\n");
			}else {
				int num = Integer.parseInt(problem);
				sb.append(hashmap2.get(num)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
