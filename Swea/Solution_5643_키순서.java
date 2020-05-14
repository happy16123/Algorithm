package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {

	public static int N;
	public static int M;
	public static int[][] D;
	public static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			D = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						D[i][j] = 0;
					} else {
						D[i][j] = INF;
					}
				}
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken()) - 1;
				int v2 = Integer.parseInt(st.nextToken()) - 1;
				D[v1][v2] = 1;
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (k == i) {
						continue;
					}
					for (int j = 0; j < N; j++) {
						if (k == i || k == j) {
							continue;
						}
						if (D[i][k] != INF && D[k][j] != INF) {
							D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
						}
					}
				}
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				boolean check = false;
				for (int j = 0; j < N; j++) {
					if (D[i][j] == INF && D[j][i] == INF) {
						check = true;
						break;
					}
				}
				if (!check) {
					ans++;
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
