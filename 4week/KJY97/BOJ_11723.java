//실행시간: 1032 ms
//메모리: 324956 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine()); //1 ≤ M ≤ 3,000,000
		
		int flag = 0; //비어있는 공집합
		String op;
		int num;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			
      //비트마스킹 방법 사용
			switch(op) {
                case "add": 
                	num = Integer.parseInt(st.nextToken());
                    flag = flag | 1 << num;
                    break;

                case "remove": 
                	num = Integer.parseInt(st.nextToken());
                    flag = flag & ~(1 << num);
                    break;

                case "check":
                	num = Integer.parseInt(st.nextToken());
                    if((flag & 1 << num) != 0) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;

                case "toggle":
                	num = Integer.parseInt(st.nextToken());
                    flag = flag ^ 1 << num;
                    break;

                case "all":
                    flag = ~(flag & 0);
                    break;

                case "empty":
                    flag = flag & 0;
                    break;
            }
		}
		System.out.println(sb);
	}
}
