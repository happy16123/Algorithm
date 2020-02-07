package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int N;
		int[] data;
		String[] temp;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			temp = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(temp[i]);
			}
			int left = 0;
			int right = 0;
			int max = -1;
			int ans = 0;
			int cnt = 0;
			for (int i = 2; i < N - 2; i++) {
				int cur = data[i];
				for (int j = 1; j <= 2; j++) {
					left = data[i - j];
					right = data[i + j];
					if (left < cur && right < cur) {
						cnt++;
						max = Math.max(max, left);
						max = Math.max(max, right);
					}
				}
				if (cnt != 2) {
					max = -1;
				}
				if (max != -1) {
					ans += cur - max;
				}
				max = -1;
				cnt = 0;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
