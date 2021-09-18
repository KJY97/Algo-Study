import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2630 {

	static int[][] paper;
	static int[] numOfColor;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		numOfColor = new int[2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 재귀
		recurrence(0, 0, n);

		// 출력
		System.out.println(numOfColor[0]);
		System.out.println(numOfColor[1]);
	}

	static void recurrence(int x, int y, int length) {
		// 영역이 같은 색인지 검사
		int color = checkColor(x, y, length);
		// 아니라면 가로 세로 반반 쪼개서 재귀 호출
		if (color == -1) {
			int newlength = length / 2;
			recurrence(x, y, newlength);
			recurrence(x + newlength, y, newlength);
			recurrence(x, y + newlength, newlength);
			recurrence(x + newlength, y + newlength, newlength);
		}
		// 맞다면 색깔 하나 증가
		else {
			numOfColor[color]++;
		}
	}

	// 영역의 색깔이 전부 같은지 검사
	static int checkColor(int x, int y, int length) {
		for (int i = x; i < x + length; i++) {
			for (int j = y; j < y + length; j++) {
				if (paper[i][j] != paper[x][y])
					return -1;
			}
		}

		return paper[x][y];
	}
}