//실행시간: 2260 ms
//메모리: 305348 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st;
			
			int K = Integer.parseInt(br.readLine());	//연산 개수. k ≤ 1,000,000
			
			/**
			 * TreeMap
			 *  - 키와 값이 저장된 map, entry 저장
			 *  - 데이터 저장 즉시 key값 비교해서 오름차순 정렬 
			 *  - 레드 블랙 트리로 구성
			 *     - 부모 노드보다 작은 값은 왼쪽으로, 큰 값은 오른쪽으로 배치 
			 */
			TreeMap<Integer, Integer> map = new TreeMap<>(); 
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if (op.equals("I")) { 	//삽입 연산. 중복값 허용
					if(map.containsKey(num)) {
						map.put(num, map.get(num)+1);
					}else {
						//num, 개수 저장
						map.put(num, 1);
					}
				} 
				else if(op.equals("D")) { //삭제 연산

					if(map.isEmpty()) continue;
					
					if (num == 1) { //최대값 삭제
						int max = map.lastKey();
						int value = map.get(max);
						
						if (value == 1) map.remove(max);
						else map.put(max, value-1);
						
					}else {	//최소값 삭제
						int min = map.firstKey();
						int value = map.get(min);
						
						if (value == 1) map.remove(min);
						else map.put(min, value-1);
					}	
				}
			}
			
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey() + " "+map.firstKey());
			}
		}
	}
}
