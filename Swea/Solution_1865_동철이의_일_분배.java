package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1865_동철이의_일_분배 {

	public static int N;
	public static double max;
	public static double[][] work;
	public static boolean[] visited;
	public static int[] index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			work = new double[N][N];
			visited = new boolean[N];
			index = new int[N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					work[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
				}
			}

			dfs(0, 100.0);
			
			System.out.printf("#%d %.6f\n", t, max);
		}
	}

	public static void dfs(int cnt, double data) {
		if(data <= max) {
			return;
		}
		if (cnt == N) {
			max = Math.max(max, data);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				index[cnt] = i;
				visited[i] = true;
				dfs(cnt + 1, data * work[cnt][i]);
				visited[i] = false;
			}
		}
	}

}
