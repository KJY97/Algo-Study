package 스터디2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 백준11279최대힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0 ;i <n ;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				if(!q.isEmpty())
				sb.append(q.poll()+"\n");
				else sb.append("0\n");
			}
			else q.add(a);
			
		}
System.out.println(sb);
	}

}
