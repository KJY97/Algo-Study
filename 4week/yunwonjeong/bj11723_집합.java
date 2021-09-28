package 스터디2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		/*
		 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
			remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
			check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
			toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
			all: S를 {1, 2, ..., 20} 으로 바꾼다.
			empty: S를 공집합으로 바꾼다.
		 */

		int n = Integer.parseInt(br.readLine());//연산의 수 
		
		HashSet<Integer>set = new HashSet<>(); //중복 수 없애기 위해 hashset 사용 
		
		for(int i = 0 ;i < n ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			
			switch (str) {
			case "add": set.add(Integer.parseInt(st.nextToken()));
				
				break;

			case "remove": set.remove(Integer.parseInt(st.nextToken()));
				
				break;
			case "check": 
				if(set.contains(Integer.parseInt(st.nextToken())))
					sb.append("1\n");
			else sb.append("0\n");
				
				break;
			case "toggle":
				int a = Integer.parseInt(st.nextToken());
				if(set.contains(a))
					set.remove(a);
				else set.add(a);
				
				break;
			case "all":
				set.clear();
				for(int j = 1; j<=20 ; j++) {
					set.add(j);
				}
				
				break;
			case "empty":
				set.clear();
				break;
			}
		}
	System.out.println(sb);
		
	}

}
