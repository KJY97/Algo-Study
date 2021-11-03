// 실행시간: 104 ms
// 메모리: 15728 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9251_LCS {

	public static void main(String[] args) throws IOException { 
		// TODO 두 수열 중, 모두의 부분 수열이 되는 수열 중 가장 긴 것 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최대 1000글자로 이루어짐
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		// 다이나믹 이용
		int[][] LCS = new int[str1.length + 1][str2.length + 1]; // 1번부터 사용
		
		// 문자열 str1, str2 한글자씩 비교
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if(str1[i-1] == str2[j-1]) // 두 문자가 같다면 
					LCS[i][j] = LCS[i-1][j-1] + 1;
				else // 두 문자가 다르다면
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		
		System.out.println(LCS[str1.length][str2.length]);
	}

}
