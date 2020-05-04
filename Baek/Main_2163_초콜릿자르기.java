package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2163_초콜릿자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dp = new int[301];
		for (int i = 1; i <= 300; i++) {
			dp[i] = i - 1;
		}
		int ans1 = (N * dp[M]) + (N - 1);
		int ans2 = (dp[N] * M) + (M - 1);
		System.out.println(ans1 > ans2 ? ans1 : ans2);
	}
}
 