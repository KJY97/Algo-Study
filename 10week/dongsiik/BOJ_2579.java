// 제목 : 계단 오르기
// 티어 : 실버 3
// 링크 : https://www.acmicpc.net/problem/2579
// 메모리(kb) : 14220
// 실행시간(ms) : 128

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_2579 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//계단 정보 입력받기
		int N = Integer.parseInt(br.readLine());
		int[] floor = new int[N];
		
		for(int i=0;i<N;i++) {
			floor[i] = Integer.parseInt(br.readLine());
		}
		
		//계단이 한칸이면 DP 따질 일이 없음
		if(N==1) {
			System.out.println(floor[0]);
			return;
		}
		
		//이전까지 정보, 지금 갱신하려는 정보
		int[] prev = new int[3];
		int[] cur = new int[3];
		int[] temp;

		for(int i=0;i<N;i++) {
			//현재 정보였던 것을, 한칸 전 정보로 밀어내기
			temp = prev;
			prev = cur;
			cur = temp;
			
			//현재 칸을 안 밟은 경우, 전칸을 밟지 않고 이어밟은 경우, 전칸부터 이어밟은 경우
			cur[0] = Math.max(prev[1], prev[2]);
			cur[1] = prev[0] + floor[i];
			cur[2] = prev[1] + floor[i];
		}
		
		//마지막 칸은 밟으므로 두 값 중 비교
		System.out.println(Math.max(cur[1], cur[2]));
	}
}