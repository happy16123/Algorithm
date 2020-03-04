package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과_건포도2 {

	public static int R;
	public static int C;
	public static int[][] map;
	public static int[][][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			dp = new int[R + 1][C + 1][R + 1][C + 1];
			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + t + " " + dfs(0, 0, R, C));
		}
	}

	public static int dfs(int startR, int startC, int h, int w) {

		if (h == 1 && w == 1) {
			return 0;
		}

		if (dp[startR][startC][h][w] != Integer.MAX_VALUE) {
			return dp[startR][startC][h][w];
		}
		int sum = 0;
		for (int i = startR; i < startR + h; i++) {
			for (int j = startC; j < startC + w; j++) {
				sum += map[i][j];
			}
		}

		for (int i = 1; i < h; i++) {
			if (dp[startR][startC][i][w] == Integer.MAX_VALUE) {
				dp[startR][startC][i][w] = dfs(startR, startC, i, w);
			}
			if (dp[startR + i][startC][h - i][w] == Integer.MAX_VALUE) {
				dp[startR + i][startC][h - i][w] = dfs(startR + i, startC, h - i, w);
			}
			dp[startR][startC][h][w] = Math.min(dp[startR][startC][h][w],
					sum + dp[startR][startC][i][w] + dp[startR + i][startC][h - i][w]);
		}
		for (int i = 1; i < w; i++) {
			if (dp[startR][startC][h][i] == Integer.MAX_VALUE) {
				dp[startR][startC][h][i] = dfs(startR, startC, h, i);
			}
			if (dp[startR][startC + i][h][w - i] == Integer.MAX_VALUE) {
				dp[startR][startC + i][h][w - i] = dfs(startR, startC + i, h, w - i);
			}
			dp[startR][startC][h][w] = Math.min(dp[startR][startC][h][w],
					sum + dp[startR][startC][h][i] + dp[startR][startC + i][h][w - i]);
		}

		return dp[startR][startC][h][w];
	}
}
