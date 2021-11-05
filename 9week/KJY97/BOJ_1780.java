// 실행시간 ; 868 ms
// 메모리 : 318304 kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1780_종이개수 {

	static int N;
	static int map[][], cnt[];
	public static void main(String[] args) throws IOException {
		// TODO -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 3의 제곱꼴. N <= 3^7
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = new int[3]; // -1, 0, 1의 개수를 담는 배열
		divide(0, 0, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}
	
	static void divide(int x, int y, int N) {
		
		// 기저조건: -1, 0, 1로만 이루어져 있는지 체크
		if(numberCheck(x, y, N)) {
			if(map[x][y] == -1) cnt[0]++;
			else if(map[x][y] == 0) cnt[1]++;
			else if(map[x][y] == 1) cnt[2]++;
			return ;
		}
		
		// 모두 같은 수가 아니라면 같은 크기의 종이 9개로 자른다.
		int third = N/3;
		divide(x, y, third); 
		divide(x, y+third, third); 
		divide(x, y+(third*2), third); 
		
		divide(x+third, y, third);
		divide(x+third, y+third, third);
		divide(x+third, y+(third*2), third);
		
		divide(x+(third*2), y, third);
		divide(x+(third*2), y+third, third);
		divide(x+(third*2), y+(third*2), third);
	}

	private static boolean numberCheck(int x, int y, int N) {
		int num = map[x][y];
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(map[i][j] != num) return false;
			}
		}
		return true;
	}

}
