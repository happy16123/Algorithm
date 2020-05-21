package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_7206_숫자게임 {

	public static int ans;
	public static int[] dp = new int[100000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			String n = br.readLine();
			sb.append("#" + t + " " + solve(Integer.parseInt(n)) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int solve(int n) {
		int cnt = 0;
		if (dp[n] != 0) {
			return dp[n];
		}
		if (n < 10) {
			dp[n] = 0;
			return 0;
		}
		StringBuilder temp = new StringBuilder();
		temp.append(n);
		int size = temp.length();

		for (int i = 0; i < size - 1; i++) {
			int a = Integer.parseInt(temp.substring(0, i + 1));
			int b = Integer.parseInt(temp.substring(i + 1, temp.length()));
			cnt = Math.max(cnt, solve(a * b));
		}
		if (size > 2) {
			for (int i = 0; i < size - 1; i++) {
				int a = Integer.parseInt(temp.substring(0, i + 1));
				for (int j = i + 1; j < size - 1; j++) {
					int b = Integer.parseInt(temp.substring(i + 1, j + 1));
					int c = Integer.parseInt(temp.substring(j + 1, temp.length()));
					cnt = Math.max(cnt, solve(a * b * c));
				}
			}
		}
		dp[n] = cnt + 1;
		return dp[n];
	}
}
