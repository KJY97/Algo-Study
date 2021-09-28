package 스터디2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj9095_123더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <=t ;tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(solve(n)+"\n");
			
		}
		System.out.println(sb);
	}

	private static int solve(int n) {
	
		
		if(n < 0) return 0;
		if(n == 0) return 1;
			
		return solve(n-1)+solve(n-2)+solve(n-3);
			
		
		
	}

}
