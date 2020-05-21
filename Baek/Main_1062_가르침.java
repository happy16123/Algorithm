package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {

	public static boolean[] visited;
	public static String[] word;
	public static int N;
	public static int K;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[26];
		word = new String[N];

		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K == 26) {
			System.out.println(N);
			return;
		}

		for (int i = 0; i < N; i++) {
			String cur = br.readLine();
			word[i] = cur.substring(4, cur.length() - 4);
		}

		K = K - 5;
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		ans = 0;
		combi(0, 0);

		System.out.println(ans);
	}

	public static void combi(int start, int cnt) {
		if (cnt == K) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < word[i].length(); j++) {
					if (!visited[word[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag) {
					res++;
				}
			}
			ans = Math.max(ans, res);
			return;
		}

		for (int i = start; i < 26; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combi(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
