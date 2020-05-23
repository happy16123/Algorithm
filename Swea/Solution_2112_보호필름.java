package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

	public static int R;
	public static int C;
	public static int K;
	public static int[][] map;
	public static int[][] ori;
	public static boolean[] visited;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 987654321;
			map = new int[R][C];
			ori = new int[R][C];
			visited = new boolean[R];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					int a = Integer.parseInt(st.nextToken());
					ori[i][j] = a;
				}
				map[i] = Arrays.copyOf(ori[i], C);
			}
			
			if(K == 1) {
				ans = 0;
			} else {
				for (int i = 0; i <= R; i++) {
					solve(0, 0, 0, i);
				}
			}

			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int start, int change, int stop) {
		if (ans < change) {
			return;
		}
		if (cnt == stop) {
			int chk = 0;
			for (int c = 0; c < C; c++) {
				int cur = map[0][c];
				int count = 1;
				for (int r = 1; r < R; r++) {
					if (map[r][c] == cur) {
						count++;
					} else {
						cur = map[r][c];
						count = 1;
					}
					if (count == K) {
						chk++;
						break;
					}
				}
				if(chk - 1 != c) {
					return;
				}
			}
			if (chk == C) {
				ans = Math.min(change, ans);
			}
			return;
		}

		for (int i = start; i < R; i++) {
			Arrays.fill(map[i], 0);
			solve(cnt + 1, i + 1, change + 1, stop);

			Arrays.fill(map[i], 1);
			solve(cnt + 1, i + 1, change + 1, stop);
			map[i] = Arrays.copyOf(ori[i], C);
		}
	}
}
