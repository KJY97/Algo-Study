import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2096 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] min = new int[N+1][3];
		int[][] max = new int[N+1][3];
		int[][] arr = new int[N+1][3];
		
		min[0][0] = min[0][1] = min[0][2] = 0;
		max[0][0] = max[0][1] =	max[0][2] = 0;
		
		for(int i = 1 ;i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());

			
		}
		
		
		for(int i = 1; i <=N ; i++) {
			
			
			min[i][0] = Math.min(min[i-1][0]+arr[i][0], min[i-1][1]+arr[i][0]);
			max[i][0] = Math.max(max[i-1][0]+arr[i][0], max[i-1][1]+arr[i][0]);
			
			min[i][1] = Math.min(min[i-1][0]+arr[i][1], min[i-1][1]+arr[i][1]);
			min[i][1] = Math.min(min[i][1], min[i-1][2]+arr[i][1]);
			max[i][1] = Math.max(max[i-1][0]+arr[i][1], max[i-1][1]+arr[i][1]);
			max[i][1] = Math.max(max[i][1], max[i-1][2]+arr[i][1]);
			
			min[i][2] = Math.min(min[i-1][1]+arr[i][2], min[i-1][2]+arr[i][2]);
			max[i][2] = Math.max(max[i-1][1]+arr[i][2], max[i-1][2]+arr[i][2]);
			
		
		}
		
		
		int a = Math.min(min[N][0], min[N][1]);
		a = Math.min(a, min[N][2]);
		int b = Math.max(max[N][0], max[N][1]);
		b = Math.max(b, max[N][2]);
		
		System.out.println(b+" "+a);
	}

}
