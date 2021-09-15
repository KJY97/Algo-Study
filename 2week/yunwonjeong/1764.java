
package 스터디2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1764듣보잡 {	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int d = Integer.parseInt(st.nextToken()); //들어보지 못한 사람 
		int b = Integer.parseInt(st.nextToken()); //본적 없는 사람 
		
		HashSet<String> a = new HashSet<>(); //못들어보고 본적 없는 사람 교집합 
		HashSet<String>set = new HashSet<>(); //못들어보고, 본적없는 사람  
		ArrayList<String> list = new ArrayList<>();
	
		
		for(int i = 0 ;i < d+b ; i++) { //들어본적 없는사람 + 본적없는사람까지 
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(set.contains(str)) //만약 str이 set에 들어가 있으면 a에 추가해줌 
			a.add(str);
			set.add(str); //hashset은 중복값이 들어가지 않음 
		}
		
		for(String s:a)
			list.add(s); //a에 값을 list에 넣어서 정렬해줌 
		Collections.sort(list);
		
		System.out.println(a.size());
		
		for(String l : list)
			System.out.println(l);
	
		
		
		
	}
}
