package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1949_등산로_조성 {

	public static int N;
	public static int K;
	public static int[][] map;
	public static int ans;
	public static int[][] start;
	public static boolean[][] visited;
	public static boolean ch;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];

			int max = 0;
			int temp = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					max = Math.max(max, temp);
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1);
						visited[i][j] = false;
					}
				}
			}
			sb.append("#" + t + " " + ans + " \n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int r, int c, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < N && nc < N && !visited[nr][nc]) {
				if (map[r][c] > map[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, cnt + 1);
					visited[nr][nc] = false;
				}
				else if (!ch && map[r][c] <= map[nr][nc]) {
					for (int k = 1; k <= K; k++) {
						if (map[nr][nc] - k < map[r][c]) {
							visited[nr][nc] = true;
							ch = true;
							map[nr][nc] -= k;
							dfs(nr, nc, cnt + 1);
							map[nr][nc] += k;
							ch = false;
							visited[nr][nc] = false;
						}
					}
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
}
