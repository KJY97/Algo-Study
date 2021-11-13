// 실행시간: 76 ms
// 메모리: 11500 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		// TODO 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 계단의 개수. 300개 이하
		
		int[] stairs = new int[N+2]; // 점수는 10,000이하 자연수
		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		/**
		 * [문제]
		 * 	계단은 한번에 1칸, 2칸 오를 수 있다.
		 * 	연속된 3개 계단 모두 밟으면 안됨. 단, 시작점은 계단 아님
		 * 	시작은 첫번째 계단, 도착은 마지막 계단 밟아야 한다.
		 * 
		 * [풀이]
		 * 	DP(다이나믹 프로그래밍) 사용(최대값 저장)
		 *  1. 마지막 계단 전의 계단 밟은 경우(= 마지막 계단을 밟지 못한 경우)
		 *  	=> 마지막 계단 전전은 밟지 못한다!
		 *  	=> memo[i-3] + stairs[i-1] + stairs[i]
		 *  2. 마지막 계단 전의 계단을 밟지 않은 경우(= 마지막 계단을 밟은 경우)
		 *  	=> 마지막 계단 전전 밟았다!
		 *  	=> memo[i-2] + stairs[i]
		 *  3. 1, 2번 중 최대값 구해서 memo에 저장
		 *  4. N=2인 경우 에러 방지를 위해 +2 해준다 
		 */
		
		int[] memo = new int[N+2]; 
		memo[0] = stairs[0];
		memo[1] = stairs[0]+stairs[1];
		memo[2] = Math.max(stairs[0]+stairs[2], stairs[1]+stairs[2]);
		for (int i = 3; i < N; i++) {
			memo[i] = Math.max(memo[i-3] + stairs[i-1] + stairs[i], memo[i-2] + stairs[i]);
		}
		
		System.out.println(memo[N-1]);
	}

}
