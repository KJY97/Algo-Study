// 실행시간: 5628 ms
// 메모리: 12072 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9663_NQueen {
	
	static int N, cnt;
	static int col[]; // N개 열을 의미하는 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제. 퀸을 놓는 방법의 수 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //1 ≤ N < 15
		
		col = new int[N+1];	// 1부터 시작
		cnt = 0;
		setQueens(1); // 1행부터 놓는 시도
		System.out.println(cnt);
	}

	// rowNo: 행번호
	private static void setQueens(int rowNo) {
		
		// 기저조건 : 더 이상 퀸을 놓을 수 없다 = 서로 공격할 수 없도록 N개를 모두 두었다는 의미
		if(rowNo > N) {
			cnt++; // 경우의 수 증가
			return ;
		}
		
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i; // rowNo행, i열 저장
			
			// 현재놓은 rowNo행까지 유망하다면 다음 퀸으로 이동
			if(isAvailable(rowNo)) 
				setQueens(rowNo+1);
		}
	}

	private static boolean isAvailable(int rowNo) { // 현재 행까지는 탐색하지 않는다.
		for (int i = 1; i < rowNo; i++) {
			// 같은 열에 두거나, 대각선으로 있다면 유망하지 않다. 
			if(col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == (rowNo - i)) 
				return false;
		}
		return true;
	}
}
