//25940, 312
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class algo_1932_박동식 {

	public static void main(String args[]) throws IOException {
		// 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//삼각형의 높이
		int n = Integer.parseInt(br.readLine());
		
		//삼각형 입력받기
		int[][] table = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
				//위의 두 값 중 큰 값을 더해줌
				table[i][j] += Math.max(table[i-1][j], table[i-1][j-1]);
			}
		}
		
		//마지막줄에서 최댓값 구하기
		int answer = 0;
		for(int i=1;i<=n;i++)
			answer = Math.max(answer, table[n][i]);
		
		//출력
		System.out.println(answer);
	}
}