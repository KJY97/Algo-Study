//312976, 1156

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class algo_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입출력도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		HashSet<Integer> hSet = new HashSet<>(20);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("add")) {
				hSet.add(Integer.parseInt(st.nextToken()));
			} else if (cmd.equals("remove")) {
				hSet.remove(Integer.parseInt(st.nextToken()));
			} else if (cmd.equals("check")) {
				sb.append(hSet.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append('\n');
			} else if (cmd.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (hSet.contains(num))
					hSet.remove(num);
				else
					hSet.add(num);
			} else if (cmd.equals("all")) {
				for (int j = 1; j <= 20; j++)
					hSet.add(j);
			} else if (cmd.equals("empty")) {
				hSet.clear();
			}

		}

		System.out.println(sb);
	}
}