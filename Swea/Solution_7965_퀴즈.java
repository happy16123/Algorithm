package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_7965_퀴즈 {

	public final static int MOD = 1000000007;
	public static int N;
	public static long res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			for (int i = 1; i <= N; i++) {
				res += dcPower(i, i) % MOD;
			}
			System.out.println("#" + t + " " + res % MOD);
		}
	}

	public static long dcPower(int i, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return i;
		long r = dcPower(i, n >> 1) % MOD;
		if (n % 2 == 0) {
			return (r * r) % MOD;
		} else {
			return (((r * r) % MOD) * i) % MOD;
		}
	}
}
