import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class algo_2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//컴퓨터 수, 간선 수
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		//그래프(인접행렬) 입력받기
		boolean[][] graph = new boolean[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = true;
			graph[to][from] = true;
		}

		//정답
		int answer = 0;
		//방문 여부
		boolean[] visited = new boolean[n + 1];

		//1번 컴퓨터를 큐에 넣고 방문처리
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[1] = true;
		q.add(1);

		while (!q.isEmpty()) {
			//현재 컴퓨터
			int current = q.poll();

			//현재 컴퓨터와 연결되면서 방문하지 않았다면
			for (int i = 1; i <= n; i++) {
				if (graph[current][i] && !visited[i]) {
					//방문처리, 큐에 넣기, 정답 하나 증가
					visited[i] = true;
					q.add(i);
					answer++;
				}
			}
		}

		//출력
		System.out.println(answer);
	}

}