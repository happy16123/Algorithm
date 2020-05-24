package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스2 {

	public static int N;
	public static int M;
	public static int[] expense;
	public static int[][] map;
	public static int ans;
	public static ArrayList<Pos> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		expense = new int[22];
		for (int i = 1; i <= 21; i++) {
			expense[i] = i * i + (i - 1) * (i - 1);
		}

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			list = new ArrayList<Pos>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						list.add(new Pos(i, j));
					}
				}
			}
			ans = 0;
			for (int k = 1; k <= N + 1; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						bfs(i, j, k);
					}
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c, int k) {
		int profit = 0;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			Pos cur = list.get(i);
			int len = Math.abs(r - cur.r) + Math.abs(c - cur.c) + 1;
			if (len <= k) {
				count++;
			}
			profit = (M * count) - expense[k];
			if (profit >= 0 && ans < count) {
				ans = Math.max(ans, count);
			}
		}
	}

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
