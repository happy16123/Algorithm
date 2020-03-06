package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_디저트_카페 {

	public static int N;
	public static int startR;
	public static int startC;
	public static int[][] map;
	public static int[][] dir = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	public static boolean[] visited;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[101];
			ans = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					startR = i;
					startC = j;
					visited[map[i][j]] = true;
					dfs(i, j, 0, 0);
					visited[map[i][j]] = false;
				}
			}
			if(ans == Integer.MIN_VALUE) {
				ans = -1;
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	public static void dfs(int r, int c, int cnt, int d) {
		if (startR == r && startC == c && d == 3) {
			ans = Math.max(ans, cnt);
			return;
		}
		
		int nr, nc, nd;
		for (int i = 0; i < 2; i++) {
			if(i == 0) {
				nd = d;
				nr = r + dir[nd][0];
				nc = c + dir[nd][1];
			}
			else {
				if(r == startR && c == startC) {
					return;
				}
				if(d == 3) {
					return;
				}
				nd = d + 1;
				nr = r + dir[nd][0];
				nc = c + dir[nd][1];
			}
			if (nr > -1 && nc > -1 && nr < N && nc < N) {
				if(nr == startR && nc == startC) {
					dfs(nr,nc, cnt +1, nd);
					return;
				}
				if (!visited[map[nr][nc]]) {
					visited[map[nr][nc]] = true;
					dfs(nr, nc, cnt + 1, nd);
					visited[map[nr][nc]] = false;
				}
			}
		}
	}
}
