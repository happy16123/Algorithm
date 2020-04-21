package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	
	public static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] D = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(D[i], INF);
			D[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			D[r][c] = Math.min(D[r][c], w);
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 0; j < N; j++) {
					if (i == j || k == j) {
						continue;
					}
					if (D[i][k] != INF && D[k][j] != INF) {
						D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				D[i][j] = D[i][j] == INF ? 0 : D[i][j];
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}
}
