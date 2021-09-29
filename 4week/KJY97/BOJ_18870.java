//실행시간: 1872 ms
//메모리: 356904 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //1 ≤ N ≤ 1,000,000
		int[] arr = new int[N];
		
		//x의 좌표 압축 결과는 x보다 작은 값들의 개수  
		
		//좌표 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {	
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//정렬을 위한 배열 복사
		int[] tmp = arr.clone();
		Arrays.sort(tmp); //오름차순 정렬
		
		//x좌표의 압축 결과를 저장(xi보다 작은 수 개수)
		//key: 좌표 값, value: 압축 결과
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
		//오름차순 정렬이므로 가장 작은 값이 맨 앞있기 때문에 이 좌표의 압축결과는 무조건 0
		int cnt = 0;
		hashmap.put(tmp[0], cnt++);
		
		//동일한 좌표값이 아닌 경우에만 저장
		for (int i = 1; i < N; i++) {
			if(tmp[i-1] != tmp[i])
				hashmap.put(tmp[i], cnt++);
		}
		
		//원래 배열 순서대로 출력
		for (int i = 0; i < N; i++) {
			sb.append(hashmap.get(arr[i])).append(' ');
		}
		System.out.println(sb);
	}
  
}
