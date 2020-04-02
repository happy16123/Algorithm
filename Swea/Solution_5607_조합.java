package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {

	public static final int MOD = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long[] fac = new long[n + 1];
			fac[0] = 1;
			for (int i = 1; i <= n; i++) {
				fac[i] = (fac[i - 1] * i) % MOD;
			}

			long deno = (fac[r] * fac[n - r]) % MOD;
			long fer = fermat(deno, MOD - 2);
			System.out.println("#" + t + " " + (fac[n] * fer) % MOD);
		}
	}

	public static long fermat(long n, int x) {
		if (x == 0) {
			return 1;
		}
		long temp = fermat(n, x / 2);
		long ret = (temp * temp) % MOD;
		if (x % 2 == 0) {
			return ret;
		} else {
			return (ret * n) % MOD;
		}
	}
}
