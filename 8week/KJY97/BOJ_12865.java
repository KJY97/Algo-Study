// 실행시간: 152 ms
// 메모리: 51240 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12865_평범한배낭 {
	
	static class Item {
		int w, v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물건의 개수. 1 ≤ N ≤ 100
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게. 1 ≤ K ≤ 100,000
		
		Item[] item = new Item[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 물건의 무게. 1 ≤ W ≤ 100,000
			int v = Integer.parseInt(st.nextToken()); // 물건의 가치. 0 ≤ V ≤ 1,000
			item[i] = new Item(w, v);
		}
		
		// 다이나믹 - 메모이제이션 이용
		int[][] memo = new int[N+1][K+1]; 
		// 0 인덱스는 0으로 초기화
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				int itemW = item[i-1].w;
				int itemV = item[i-1].v;
				
				if(itemW > w) // 현재 고려하는 물건의 무게가 담을 수 있는 무게보다 크면 이전의 최대 가치합 저장
					memo[i][w] = memo[i-1][w];
				else
					memo[i][w] = Math.max(itemV + memo[i-1][w - itemW], memo[i-1][w]);
			}
		}
		System.out.println(memo[N][K]);
	}

}
