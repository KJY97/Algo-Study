//14076, 136

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo_9095 {

	public static void main(String[] args) throws IOException {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[12];
		answer[1]=1;
		answer[2]=2;
		answer[3]=4;
		for(int i=4;i<12;i++) {
			answer[i] = answer[i-3]+answer[i-2]+answer[i-1];
		}
		
		for(int tc=0;tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(answer[n]).append('\n');
		}
		
		System.out.println(sb);

	}

}
