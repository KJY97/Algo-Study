// 제목 : IOIOI
// 티어 : 실버 2
// 링크 : https://www.acmicpc.net/problem/5525
// 메모리(kb) : 20060
// 실행시간(ms) : 284

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_5525 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//P_N의 N, S의 길이 M, S
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		//정답
		int answer = 0;
		//II나 OO 같은 경계선을 찾을 위치
		int fromIndex = 0;
		while(true) {
			//II, OO의 위치
			int nextII = S.indexOf("II", fromIndex);
			int nextOO = S.indexOf("OO", fromIndex);
			
			//없을 경우 M-1자리에 두기
			if(nextII==-1) nextII = M-1;
			if(nextOO==-1) nextOO = M-1;
	
			//다음 경계선 자리
			int toIndex = Math.min(nextII, nextOO);
			
			//경계값 시작이 I일 때, 경계선 사이의 영역이 2*N이면 P_N이 들어감
			if(S.charAt(fromIndex)=='I' && toIndex-fromIndex>=2*N) {
				answer += (toIndex-fromIndex - 2*N)/2 + 1;				
			}
			//경계값 시작이 O일 때, 경계선 사이의 영역이 2*N+1 이상이면 P_N이 들어감
			else if(toIndex-fromIndex>2*N) {
				answer += (toIndex-fromIndex - 2*N-1)/2 + 1;				
			}
			
			//끝까지 다 탐사했다면 종료
			if(toIndex==M-1) break;
			//경계선 끝점 옆칸을 다음 시작지점으로 삼음
			fromIndex = toIndex+1;
		}
		
		//출력
		System.out.println(answer);
	}
}