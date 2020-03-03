package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699_수지의_수지맞는여행 {

	public static char[][] map;
	public static boolean[][] visited;
	public static boolean[] checked;
	public static int R;
	public static int C;
	public static int ans;
	public static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			visited = new boolean[R][C];
			checked = new boolean[26];
			ans = -1;

			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			dfs(0, 0, 1);
			
			System.out.println("#" + t + " " + ans);

		}
	}

	public static void dfs(int r, int c, int cnt) {
		visited[r][c] = true;
		checked[map[r][c] - 'A'] = true;

		int nr, nc;

		for (int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < R && nc < C) {
				if (!visited[nr][nc] && !checked[map[nr][nc] - 'A']) {
					dfs(nr, nc, cnt + 1);
					visited[nr][nc] = false;
					checked[map[nr][nc] - 'A'] = false;
				}
			}
		}
		ans = Math.max(cnt, ans);
	}
}
