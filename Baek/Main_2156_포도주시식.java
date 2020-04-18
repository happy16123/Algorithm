package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {

	public static int[] data;
	public static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		data = new int[N + 1];
		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = data[1];
		if(N > 1)
			dp[2] = data[1] + data[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2] + data[i], dp[i - 3] + data[i - 1] + data[i]);
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}

		System.out.println(dp[N]);
	}
}
