// 실행시간: 1460 ms
// 메모리 : 94852 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2263_트리의순회 { // 중위 순회, 후위 순회가 주어졌을 때, 전위 순회를 구하는 프로그램

	static int[] idx, inOrder, postOrder;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이진 트리의 노드의 개수. 1≤n≤100,000
		// 정점 번호는 1번부터 시작
		int N = Integer.parseInt(br.readLine()); 
		
		// ---- 중위 순회 입력 ----
		inOrder = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for (int i = 1; i <= N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		// ---- 후위 순회 입력 ----
		postOrder = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 풀이
					1
				2		3
		  	 4     5  6    7
		   8   9  
		  중위순회: '8-4-9'-2-5-1-6-3-7 (왼-루-오)
		  후위순회: '8-9-4'-5-2-6-7-3-1 (왼-오-루)
		  전위순회: 1-2-4-8-9-5-3-6-7 (루-왼-오)
		  
		  8 4 9 2 5  6 3 7  / 1 - 6
		  
		  8 4 9   5  / 2 - 4
		  
		  후위의 가장 마지막 값은 루트가 된다.
		  중위순회에서 1(루트) 기준으로 쪼개면 왼쪽 트리 / 오른쪽 트리로 나눠짐
		  
		 * 중위순회 기준으로 루트 기반으로 둘 나누고
		 * 후위순회 기준으로 가장 마지막 값이 루트가 된다.
		*/
		
		// 중위순회의 값이 inOrder배열의 몇 번(=index)에 위치하는지 저장
		idx = new int[N+1];
		for (int i = 1; i <= N; i++) {
			idx[inOrder[i]] = i;
		}
		
		// 전위순회 시작
		preOrder(1, N, 1, N);
	}
	
	public static void preOrder(int in_start, int in_end, int post_start, int post_end) {
		
		// 기저조건: 더 이상 나누는 게 불가능하다면..
		if(in_start > in_end || post_start > post_end) return ;
		
		int root = postOrder[post_end];
		int root_idx = idx[root];
		int left = root_idx - 1 - in_start + 1; // ??????
		
		System.out.print(root+ " "); // 루트 출력
		
		// 왼쪽 탐색
		preOrder(in_start, root_idx-1, post_start, post_start + left-1);
		// 오른쪽 탐색
		preOrder(root_idx+1, in_end, post_start + left ,post_end-1);
	}

}
