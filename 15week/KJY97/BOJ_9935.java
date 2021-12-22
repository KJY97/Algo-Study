package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935 {

	/**
	 * 문제
	 *  폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐진다.
	 *  모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보자.
	 *   - 남아있는 문자가 없는 경우 존재. 이때는 FRULA 출력
	 *   - 문자열은 알파벳 대소문자와 숫자로 이루어져있다.
	 *   
	 *   [과정]
	 *   - 문자열이 폭발 문자열을 포함 -> 모든 폭발 문자열 폭발. 남은 문자열을 이어붙여 새로운 문자열 생성
	 *   - 새로 생긴 문자열에 폭발 문자열이 폭함되어 있을 수 있다.
	 *   - 폭발은 폭발 문자열이 문자열에 없을 때까지 반복
	 * 
	 * => contains와 replaceAll를 사용하면 메모리 초과 발생.. (특히 replace가 메모리 많이 차지해서..)
	 * => println을 사용하면 시간초과 발생..
	 * 
	 * 시간 : 260 ms
	 * 메모리 : 29192 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 문자열. 1 <= str.length <= 1,000,000
		String bomb = br.readLine(); // 폭발 문자열. 1<= bomb.length <= 36
		int bombSize = bomb.length();
		
		char[] result = new char[str.length()];
		int idx = 0; // idx는 result의 저장된 문자 길이
		
		for (int i = 0; i < str.length(); i++) {
			result[idx++] = str.charAt(i);
			
			// 폭발 문자열보다 저장된 문자열이 더 길면 탐색
			if(idx >= bomb.length()) {
				
				boolean flag = true; // 폭발 문자열을 포함하는지 판별
				for (int j = 0; j < bombSize; j++) {
					// 저장된 문자열 길이 - 폭발 문자열만큼 뒤로 이동 + 글자 비교 위치
					if(result[idx - bombSize + j] != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				// 폭발 문자열 삭제
				if(flag) idx -= bomb.length(); 
			}
		}
		
		StringBuilder sb = new StringBuilder();

		if(idx == 0) {
			sb.append("FRULA");
		}
		else {
			for (int i = 0; i < idx; i++) {
				sb.append(result[i]);
			}
		}
		System.out.println(sb);
	}

}
