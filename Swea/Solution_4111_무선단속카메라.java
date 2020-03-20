package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4111_무선단속카메라 {

	public static int N;
	public static int K;
	public static int[] data;
	public static int[] gap;
	public static int ans;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			data = new int[N];
			gap = new int[N - 1];
			ans = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(data);

			for (int i = 0; i < N - 1; i++) {
				gap[i] = Math.abs(data[i + 1] - data[i]);
			}

			Arrays.sort(gap);

			for (int i = 0; i < N - 1 - (K - 1); i++) {
				ans += gap[i];
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
