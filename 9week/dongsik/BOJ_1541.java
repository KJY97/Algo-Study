
// 제목 : 잃어버린 괄호
// 티어 : 실버 2
// 링크 : https://www.acmicpc.net/problem/1541
// 메모리(kb) : 14168
// 실행시간(ms) : 124

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
		
		int answer = 0;
		boolean flag = false;
		
		while(st.hasMoreTokens()) {
			String substr = st.nextToken();
			if(substr.equals("-"))
				flag = true;
			else if(substr.equals("+"))
				continue;
			else {
				int num = Integer.parseInt(substr);
				if(flag) answer-=num;
				else answer+=num;
			}
		}
		
		System.out.println(answer);
	}
}