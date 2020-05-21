package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7208_지도칠하기 {

	public static int N;
	public static int[][] map;
	public static int[] color;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			color = new int[N];
			ans = 987654321;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(0, 0);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void solve(int cnt, int change) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && color[i] == color[j]) {
						return;
					}
				}
			}
			ans = Math.min(ans, change);
			return;
		}

		for (int i = 1; i <= 4; i++) {
			if (color[cnt] == i) {
				solve(cnt + 1, change);
			} else {
				int temp = color[cnt];
				color[cnt] = i;
				solve(cnt + 1, change + 1);
				color[cnt] = temp;
			}
		}
	}
}
