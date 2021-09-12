//26056kb, 296ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> neverHeard = new HashSet<>(n);
		ArrayList<String> neverHeardAndSeen = new ArrayList<>(Math.min(n, m));

		for (int i = 0; i < n; i++) {
			String person = br.readLine();
			neverHeard.add(person);
		}

		for (int i = 0; i < m; i++) {
			String person = br.readLine();
			if (neverHeard.contains(person))
				neverHeardAndSeen.add(person);
		}

		sb.append(neverHeardAndSeen.size()).append('\n');
		Collections.sort(neverHeardAndSeen);
		for (int i = 0; i < neverHeardAndSeen.size(); i++) {
			sb.append(neverHeardAndSeen.get(i)).append('\n');
		}

		System.out.print(sb.toString());
	}

}
