
// 제목 : N과 M (9)
// 티어 : 실버 2
// 링크 : https://www.acmicpc.net/problem/15663
// 메모리(kb) : 21444
// 실행시간(ms) : 216

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class BOJ_15663 {
	
	//N개의 자연수 중 M개를 고르기
	static int N, M;
	//중복을 고려하여 숫자를 저장하는 arr
	static ArrayList<Num> arr;
	//골라진 자연수들
	static int[] selected;
	static StringBuilder sb;
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//중복 관리를 위한 해시맵
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		selected = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
		}
		
		//해시맵에서 중복 정보를 포함하여 배열로 옮기기
		arr = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			arr.add(new Num(entry.getKey(), entry.getValue()));
		}
		
		//숫자 오름차순 정렬
		arr.sort((num1, num2)->(num1.number-num2.number));
		
		dfs(0,0);
		
		System.out.println(sb);
	}
	
	static void dfs(int start, int count) {
		
		//다 골랐을 경우 출력
		if(count==M) {
			for(int i=0;i<M;i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//숫자 하나 고르기
		for(int i=start; i<arr.size();i++) {
			if(arr.get(i).dup>0) {
				arr.get(i).dup = arr.get(i).dup -1;
				selected[count] = arr.get(i).number;
				dfs(start, count+1);
				arr.get(i).dup = arr.get(i).dup +1;
			}
		}

	}
	
	static class Num{
		//숫자, 그 숫자의 남은 개수
		int number, dup;

		public Num(int num, int dup) {
			this.number = num;
			this.dup = dup;
		}
				
	}
}