//26360, 348

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class algo_11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입출력도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 최대 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// 명령어 수
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			// 명령어
			int cmd = Integer.parseInt(br.readLine());
			// 삭제
			if (cmd == 0) {
				if (pq.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(pq.poll()).append('\n');
			}
			// 삽입
			else {
				pq.add(cmd);
			}
		}

		// 출력
		System.out.println(sb);

	}
}