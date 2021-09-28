package 스터디2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백준11726타일링 {
	static long[] m;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	m = new long[n+1];
	m[0] = 1;
	m[1] = 1;
	
	for(int i = 2; i <=n ;i++) {
		m[i] =( m[i-1]+m[i-2])%10007;
	}
	
	System.out.println(m[n]);
	
}
}

