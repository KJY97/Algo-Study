//49160kb, 520ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] numToPokemon = new String[n + 1];
		HashMap<String, Integer> pokemonToNum = new HashMap<>(n + 1);

		for (int i = 1; i <= n; i++) {
			String pokemon = br.readLine();
			numToPokemon[i] = pokemon;
			pokemonToNum.put(pokemon, i);
		}

		for (int i = 1; i <= m; i++) {
			String query = br.readLine();
			if (query.charAt(0) >= 'A' && query.charAt(0) <= 'Z')
				sb.append(pokemonToNum.get(query)).append('\n');
			else
				sb.append(numToPokemon[Integer.parseInt(query)]).append('\n');
		}

		System.out.print(sb.toString());
	}

}
