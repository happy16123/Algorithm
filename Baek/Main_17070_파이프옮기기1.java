package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {

	public static int N;
	public static int ans;
	public static int[][] map;
	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	public static int[][] type = { { 0 }, { 1 }, { 0, 1, 2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		dfs(0, 1, 0);
		dfs(0, 1, 2);
		System.out.println(ans);
	}

	public static void dfs(int r, int c, int cur) {
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return;
		}
		int nr = 0;
		int nc = 0;
		for (int i = 0; i < type[cur].length; i++) {
			nr = r + dir[type[cur][i]][0];
			nc = c + dir[type[cur][i]][1];
			if (nr > -1 && nc > -1 && nr < N && nc < N) {
				if (map[nr][nc] == 1) {
					return;
				}
			} else {
				return;
			}
		}
		if (nr == N - 1 && nc == N - 1) {
			ans++;
			return;
		}
		if (cur == 0) {
			dfs(nr, nc, 0);
			dfs(nr, nc, 2);
		} else if (cur == 1) {
			dfs(nr, nc, 1);
			dfs(nr, nc, 2);
		} else if (cur == 2) {
			dfs(nr, nc, 0);
			dfs(nr, nc, 1);
			dfs(nr, nc, 2);
		}
	}
}
