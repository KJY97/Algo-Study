//273768, 2072

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algo_18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입출력도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 좌표의 수
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		// 압축을 위한 내림차순 우선순위 큐, 압축된 값을 저장할 해시맵, 입력받은 값을 저장할 배열
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		HashMap<Integer, Integer> hMap = new HashMap<>();
		int[] arr = new int[n];

		// 좌표들 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 해시맵에 넣어보고, 전에 없던 값이라면 우선순위큐에도 넣어봄
			if (hMap.put(arr[i], 0) == null)
				pq.add(arr[i]);
		}

		// 우선순위큐가 빌 때까지
		while (!pq.isEmpty()) {
			// 숫자를 꺼내서, 자기보다 작은 숫자의 수를 기록
			int num = pq.poll();
			int size = pq.size();
			hMap.put(num, size);
		}

		// 입력된 값마다 해시맵을 보면서 출력
		for (int i = 0; i < n; i++) {
			sb.append(hMap.get(arr[i])).append(' ');
		}

		System.out.println(sb);

	}
}