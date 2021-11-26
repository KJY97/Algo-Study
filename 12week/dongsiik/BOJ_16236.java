
// 제목 : 아기 상어
// 티어 : 골드 4
// 링크 : https://www.acmicpc.net/problem/16236
// 메모리(kb) : 14704
// 실행시간(ms) : 144

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_16236 {

	// 델타 탐색용 배열
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	// 상어의 위치, 크기, 경험치
	static Fish shark;
	// 공간의 크기와 공간
	static int N;
	static int[][] map;

	public static void main(String args[]) throws IOException {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 상어라면 맵에 표시하는 대신, 클래스에만 담아둠
				if (map[i][j] == 9) {
					shark = new Fish(i, j);
					map[i][j] = 0;
				}
			}
		}

		// 총 걸린 시간
		int answer = 0;
		while (true) {
			int time = bfs();
			// 잡아먹을 물고기가 없다면 종료, 아니라면 그 물고기를 잡는데까지 걸린 시간 추가
			if (time == -1)
				break;
			else
				answer += time;
		}

		System.out.println(answer);
	}

	static int bfs() {

		// 먹잇감 위치선정을 위한 우선순위 큐
		PriorityQueue<Node> q = new PriorityQueue<>();
		// 방문여부
		boolean[][] visited = new boolean[N][N];

		// 상어의 현재 위치부터 시작
		q.add(new Node(shark.x, shark.y, 0));
		visited[shark.x][shark.y] = true;

		while (!q.isEmpty()) {
			Node curNode = q.poll();

			// 현재 위치에 잡아먹을 물고기가 있다면 잡아먹고 걸린 시간을 반환
			if (shark.eat(curNode.x, curNode.y)) {
				return curNode.time;
			}

			// 델타 탐색
			for (int d = 0; d < 4; d++) {
				int nx = curNode.x + dx[d];
				int ny = curNode.y + dy[d];
				int nTime = curNode.time + 1;

				if (bypass(nx, ny) && !visited[nx][ny]) {
					q.add(new Node(nx, ny, nTime));
					visited[nx][ny] = true;
				}

			}
		}

		return -1;
	}

	// 상어가 지나갈 수 있는가
	static boolean bypass(int nx, int ny) {
		if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] <= shark.level)
			return true;
		else
			return false;
	}

	// 공간의 각 점들을 방문하는 데 걸린 시간과, 우선순위 큐를 위한 compareTo
	static class Node implements Comparable<Node> {
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			if (this.time != o.time) {
				return this.time - o.time;
			}
			if (this.x != o.x) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}

	}

	// 상어 클래스
	static class Fish {
		// 좌표, 크기, 경험치
		int x, y, level, exp;

		public Fish(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.level = 2;
			this.exp = 0;
		}

		// 잡아먹기
		public boolean eat(int x, int y) {
			if (map[x][y] > 0 && map[x][y] < level) {
				map[x][y] = 0;
				exp++;
				shark.x = x;
				shark.y = y;
				if (level == exp) {
					level++;
					exp = 0;
				}
				return true;
			} else
				return false;
		}

	}
}