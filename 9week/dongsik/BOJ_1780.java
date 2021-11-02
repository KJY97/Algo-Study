
// 제목 : 종이의 개수
// 티어 : 실버 2
// 링크 : https://www.acmicpc.net/problem/1780
// 메모리(kb) : 310376
// 실행시간(ms) : 904

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {

	static int N;
	static int[][] paper;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		init();
		recursive(0,0,N);
		printAnswer();
	}
	
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = new int[3];
	}
	
	static void recursive(int row, int column, int length) {
		if(!checkSameNumber(row, column, length)) {
			length /= 3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					recursive(row+i*length, column+j*length, length);
				}
			}
		}
	}
	
	static boolean checkSameNumber(int row, int column, int length) {
		int num = paper[row][column];
		
		for(int i=row;i<row+length;i++) {
			for(int j=column;j<column+length;j++) {
				if(paper[i][j]!=num) return false;
			}
		}
		
		answer[num+1]++;
		
		return true;
	}
	
	static void printAnswer() {
		for(int i=0;i<3;i++) {
			System.out.println(answer[i]);
		}
	}
	
}