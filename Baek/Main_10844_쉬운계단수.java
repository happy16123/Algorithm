package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10844_쉬운계단수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];

		Arrays.fill(dp[0], 1);
		dp[0][0] = 0;

		for (int n = 1; n < N + 1; n++) {
			for (int i = 0; i < 10; i++) {
				if (i == 0) {
					dp[n][i] = dp[n - 1][1];
				} else if (i == 9) {
					dp[n][i] = dp[n - 1][8];
				} else {
					dp[n][i] = dp[n - 1][i - 1] + dp[n - 1][i + 1];
				}
				dp[n][i] %= 1000000000;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N - 1][i];
			sum %= 1000000000;
		}
		
		System.out.println(sum);
	}
}
