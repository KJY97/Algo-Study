// 실행시간 ; 120 ms
// 메모리 : 11452 kb 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1676_팩토리얼0의개수 {
	
	public static void main(String[] args) throws IOException {
		// TODO N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 0 ≤ N ≤ 500
		
		/** 풀이
		 * 1. N!하면서 10이 만들어지는 경우 따지기.
		 *  => 2, 5로 구성됨
		 *  => 각각 몇 번 나오는지 세기
		 *  6 = 2*3*1*5*2*2*1*3*1*2*1
		 * 2. 근데 모든 값이 five의 개수를 따라감(왜지..??)
		 * 3. 7! = 5040에서 맨 뒤 0의 개수만 고려. 중간에 0은 아님
		 */
		
		int two = 0;
		int five = 0;
//		for (int i = 2; i <= N; i *= 2) {
//			two += N/i;
//		}
		
		for (int i = 5; i <= N; i *= 5) {
			five += N/i;
		}
		
		System.out.println(five);
	}

}
