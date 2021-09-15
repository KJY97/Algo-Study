package 스터디2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class bj1620포켓몬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> num = new HashMap<>();
		HashMap<String, Integer> alpha = new HashMap<>();
		for(int i = 0 ; i<N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			num.put(i, str);
			alpha.put(str,i);
		}
		
		for(int i = 0 ;i <M ;i++) {
			StringBuilder sb =  new StringBuilder();
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
		
			
			if(alpha.containsKey(a)) {
				sb.append(alpha.get(a)+1);
			}
			else {
				sb.append(num.get(Integer.parseInt(a)-1));
			}
			System.out.println(sb);
		}
		
		

	}

	

}
