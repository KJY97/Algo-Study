//실행시간: 104 ms
//메모리: 15420 kb

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());  //1 <= X <= 10^6
		int[] D = new int[X+1];    
		
		D[1] = 0;
    
		//작은 부분 문제에서 부터 최적해 찾기
		for (int i = 2; i <= X; i++) {
			int min = D[i-1] + 1;						//규칙3. 1을 뺀다.
			if(i%2 == 0) {
				min = Math.min(min, D[i/2]+1);	//규칙2. 2로 나누어지면 2로 나눈다.
				//-1을 하고 나서 나누어 계산한 횟수 vs 2로 바로 나누어 계산한 횟수 중 최소값 저장하기
			}
			if(i%3 == 0) {
				min = Math.min(min, D[i/3]+1);	//규칙1. 3로 나누어지면 3로 나눈다.
			}
            D[i] = min;
		}
		System.out.println(D[X]);
	}
}
