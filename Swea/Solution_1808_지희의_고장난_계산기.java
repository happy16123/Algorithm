package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1808_지희의_고장난_계산기 {

	public static boolean[] cal;
	public static int[] dp;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			cal = new boolean[10];
			for (int i = 0; i < 10; i++) {
				if (st.nextToken().equals("1")) {
					cal[i] = true;
				}
			}

			N = Integer.parseInt(br.readLine());
			dp = new int[N+10];
			bfs(N);
			if (dp[N] == Integer.MAX_VALUE) {
				System.out.println("#" + t +  " " + -1);
			} else {
				System.out.println("#" + t + " " + (dp[N] + 1));
			}
		}
	}

	public static int bfs(int num) {
		if(dp[num] != 0) {
			return dp[num];
		}
		dp[num] = check(num);
		
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				int t1 = bfs(i);
				int t2 = bfs(num / i);
				dp[num] = Math.min(dp[num], t1 == Integer.MAX_VALUE || t2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : t1 + t2 + 1);
			}
		}

		return dp[num];
	}
	
	public static int check(int num) {
		int cnt = 0;
		while (num != 0) {
			int rem = num % 10;
			num /= 10;
			if (!cal[rem]) {
				return Integer.MAX_VALUE;
			}
			cnt++;
		}
		return cnt;
		
	}
}
