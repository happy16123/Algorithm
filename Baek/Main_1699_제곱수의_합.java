package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1699_제곱수의_합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N];

		for (int i = 1; i <= N; i++) {
			memo[i] = i;
			for (int j = 1; j * j <= i; j++) {
				memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
			}
		}

		System.out.println(memo[N]);
	}
}
