package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의_양팔저울 {

	public static int N;
	public static int[] list;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			ans = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,0,0);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int l, int r) {
		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = cnt; i < N; i++) {
			int temp = list[cnt];
			list[cnt] = list[i];
			list[i] = temp;

			solve(cnt + 1, l + list[cnt], r);
			if (l >= r + list[cnt]) {
				solve(cnt + 1, l, r + list[cnt]);
			}

			temp = list[cnt];
			list[cnt] = list[i];
			list[i] = temp;
		}
	}

}
