// 실행시간: 2028 ms
// 메모리: 135456 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		// TODO NxN 크기의 표에서 (x1, y1)부터 (x2, y2)까지의 합 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 표 크기 1 ≤ N ≤ 1024
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 1 ≤ M ≤ 100,000
		
		// (1,1) ~ (N,N) 합을 다이나믹으로 구하기
		int[][] memo_sum = new int[N+1][N+1]; // 0번 인덱스 사용 안함
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				memo_sum[i][j] = Integer.parseInt(st.nextToken()); // 1,000 이하 자연수
				// 현재 값에 왼쪽, 위의 값을 더하고, 중복되는 교집합 빼기
				memo_sum[i][j] += memo_sum[i-1][j] + memo_sum[i][j-1] - memo_sum[i-1][j-1];
			}
		}
		
		// (x1, y1)부터 (x2, y2)까지 좌표 입력 & 합 구하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 1부터 좌표 입력됨
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int res = memo_sum[x2][y2];
			// memo_sum은 왼쪽, 위의 값을 저장했기 때문에 해당되지 않는 행과 열의 최종합 부분을 뺀다.
			// 중복되어 빼는 부분이 있기 때문에(교집합) 다시 더해준다.
			res = res - memo_sum[x1-1][y2] - memo_sum[x2][y1-1] + memo_sum[x1-1][y1-1];
			System.out.println(res);
		}
	}
}
