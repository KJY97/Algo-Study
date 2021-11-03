// 실행시간: 88 ms
// 메모리: 11840 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 수열 A에서 가장 긴 증가하는 부분 수열의 길이 구하기 => 최장 증가 수열. 이진탐색 사용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //1 ≤ N ≤ 1,000, 수열 크기
		int[] arr = new int[N]; // 중복되는 값이 들어온다.
		int[] LIS = new int[N]; // 증가수열
		
		// ---- 수열 입력 초기화 ----
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		//10 20 10 30 20 50
		int size = 0; // LIS에 채워진 원소 수 = 수열의 길이
		for (int i = 0; i < N; i++) {
			// Arrays.binarySearch() : LIS에 탐색하는 값이 존재하지 않으면 음수 출력
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);

			// 중복값이라면 패스
			if(temp >= 0) continue;
			
			temp = Math.abs(temp) - 1;
			LIS[temp] = arr[i];
			
			// 추가된 위치가 맨 뒤라면 사이즈 증가
			if(temp == size) ++size;
		}
		System.out.println(size);
	}

}
