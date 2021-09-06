import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1003 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine()); // 0 <= N <= 40 
			int[][] arr = new int[41][2];
			
			arr[0][0] = 1; arr[0][1] = 0;
			arr[1][0] = 0; arr[1][1] = 1;
			
			//fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하기
			// -> 피보나치 호출방식과 동일하게  0과 1이 호출된 횟수도 더해진다.
			for (int n = 2; n <= N; n++) {
				arr[n][0] = arr[n-1][0] + arr[n-2][0];
				arr[n][1] = arr[n-1][1] + arr[n-2][1];
			}
			System.out.println(arr[N][0] + " " + arr[N][1]);
		}
	}
}
