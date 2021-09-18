//실행시간: 108 ms
//메모리: 12996 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int white, blue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //종이 한변의 길이. 2의 제곱수
		map = new int[N][N]; 
		
		//하얀색 0, 파란색 1
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		white = 0;
		blue = 0;
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void divide(int x, int y, int N) {
        
        //흰색 or 파란색으로 이루어져 있는지 체크
		if(colorCheck(x, y, N)) {
			if(map[x][y] == 0) white++;
			else blue++;
			return ;
		}
		
		divide(x, y, N/2);			//4사분면
		divide(x, y+N/2, N/2);		//1사분면
		divide(x+N/2, y, N/2);		//3사분면
		divide(x+N/2, y+N/2, N/2);	//2사분면
	}
    
    //조건: 현재 색종이가 흰색 or 파란색으로 이루어져 있는지 확인
	public static boolean colorCheck(int x, int y, int N) {
		int color = map[x][y];
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(map[i][j] != color)  return false;
			}
		}
		return true;
	}

}
