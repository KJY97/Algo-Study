//실행시간: 300 ms
//메모리: 25768 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//N, M은 500,000 이하
		//듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
		int N = Integer.parseInt(st.nextToken());	//듣도 못한 사람 수
		int M = Integer.parseInt(st.nextToken());	//보도 못한 사람 수
		
		//set : 중복 자동 제거
		HashSet<String> nugu = new HashSet<>();
		List<String> tmp = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			nugu.add(br.readLine());
		}
		
        // HashSet의 contains 성능 O(1)
        // 정렬하려먼 list 사용
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(nugu.contains(str))
				tmp.add(str);
		}
        
		//사전순으로 출력해야하므로 정렬
		Collections.sort(tmp);
        
		sb.append(tmp.size()).append('\n');
		for (String str : tmp) {
			sb.append(str).append('\n');
		}
		System.out.print(sb);
	}
}
