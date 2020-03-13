package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461_파도반_수열 {

	public static long[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<101; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}
