package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[] cal = new int[N + 1];
			int[] score = new int[N + 1];
			int[][] dp = new int[N + 1][L + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if(cal[i] > j) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j - cal[i]] + score[i], dp[i-1][j]);
					}
				}
			}
			
			for(int i=0; i<N+1; i++) {
				System.out.println(Arrays.toString(dp[i]));
			}
			System.out.println("#" + t + " " + dp[N][L]);
		}
	}
}
