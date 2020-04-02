package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6719_성수의_프로그래밍_강좌_시청 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] data = new int[N];
			double ans = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(data);
			for (int i = K; i > 0; i--) {
				ans = (data[N- i] + ans) / 2.0;
			}

			System.out.printf("#" + t + " %7f\n", ans);
		}
	}
}
