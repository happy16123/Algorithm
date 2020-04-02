package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3503_초보자를_위한_점프대_배치하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] data = new int[N];
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(data);
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N - 2; i++) {
				max = Math.max(max, data[i + 2] - data[i]);
			}

			System.out.println("#" + t + " " + max);
		}
	}
}
