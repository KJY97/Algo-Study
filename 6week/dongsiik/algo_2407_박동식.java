// 제목 : 조합
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/2407
// 메모리(kb) : 14440
// 실행시간(ms) : 128

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class algo_2407_박동식 {

	static int N,M;
	public static void main(String[] args) throws IOException {

		input();
		combination();

	}
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
	
	private static void combination() {
		BigInteger[] fac = new BigInteger[N+1];
		fac[0] = BigInteger.ONE;
		for(int i=1;i<=N;i++)
			fac[i] = fac[i-1].multiply(new BigInteger(""+i));
		
		BigInteger answer = fac[N].divide(fac[M]).divide(fac[N-M]);
		
		System.out.println(answer.toString());
	}
	
}