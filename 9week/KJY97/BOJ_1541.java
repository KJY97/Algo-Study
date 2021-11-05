// 실행시간 ; 72 ms
// 메모리 : 11512 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		// TODO 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 식. 0~9, +, - 로 구성
		// 처음과 마지막 문자는 숫자. 연속해서 2개 이상 연산자가 나오지 않는다.
		// 최대 5자리 숫자가 등장
		String exp = br.readLine(); 
		
		/** 풀이
		 * 값이 최소인 경우를 구하는 것이므로
		 * +로 묶여있는 것끼리 모두 더하고, 그 결과들을 모두 처음 숫자에서 - 한다.
		 * 
		 * 1. +들끼리 묶어주기 위해서 -로 split
		 * 2. 분리된 문자열을 + 기준으로 split해서 그 숫자들 더하기
		 * 3. 더한 결과들을 처음 숫자에서 빼기
		 */
		
		int res = Integer.MAX_VALUE;
		String[] subNumber = exp.split("-"); // 55, 50+40
		for (int i = 0; i < subNumber.length; i++) {
			
			int sum = 0;
			
			// -기준으로 분리된 문자열을 +기준으로 split해서 그 숫자들 더하기
			String[] addNumber = subNumber[i].split("\\+");
			for (int j = 0; j < addNumber.length; j++) {
				sum += Integer.parseInt(addNumber[j]);
			}
			
			if(res == Integer.MAX_VALUE) {
				res = sum;
			} else {
				res -= sum;
			}
		}
		System.out.println(res);
		
	}
}
