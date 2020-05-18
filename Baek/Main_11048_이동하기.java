package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {

	public static int R;
	public static int C;
	public static int[][] map;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dp = new int[R + 1][C + 1];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j] + map[i-1][j-1], dp[i-1][j-1] + map[i-1][j-1]), dp[i][j-1] + map[i-1][j-1]);
			}
		}
		
		System.out.println(dp[R][C]);
	}
}
