package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4014_활주로_건설 {

	public static int N;
	public static int X;
	public static int ans;
	public static int[][] map;
	public static int[][] high;
	public static int[] dir = { -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			high = new int[2][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int max = 0;
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(map[i][j], max);
				}
				high[0][i] = max;
			}

			for (int j = 0; j < N; j++) {
				int max = 0;
				for (int i = 0; i < N; i++) {
					max = Math.max(map[i][j], max);
				}
				high[1][j] = max;
			}

			for (int i = 0; i < N; i++) {
				int max = high[0][i];
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max && findWidth(i, j, max)) {
						ans++;
						break;
					}
				}
			}

			for (int j = 0; j < N; j++) {
				int max = high[1][j];
				for (int i = 0; i < N; i++) {
					if (map[i][j] == max && findHeight(i, j, max)) {
						ans++;
						break;
					}
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean findWidth(int r, int c, int maxHigh) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[N];
		q.offer(new int[] { c, map[r][c], 1 });
		visited[c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			c = cur[0];
			int high = cur[1];
			int len = cur[2];
			if ((c == 0 || c == N - 1) && high != maxHigh) {
				if (len < X) {
					return false;
				}
			}
			for (int i = 0; i < 2; i++) {
				int nc = c + dir[i];
				if (nc > -1 && nc < N && !visited[nc]) {
					if (Math.abs(high - map[r][nc]) >= 2) {
						return false;
					}
					if (high == map[r][nc]) {
						q.offer(new int[] { nc, map[r][nc], len + 1 });
					} else if (high - 1 == map[r][nc]) {
						if (high != maxHigh && len < X) {
							return false;
						}
						q.offer(new int[] { nc, map[r][nc], 1 });
					} else if(high + 1 == map[r][nc]) {
						if(len < X * 2) {
							return false;
						}
						if(nc == 0 || nc == N - 1) {
							q.offer(new int[] {nc, map[r][nc], len});
						} else {
							q.offer(new int[] {nc, map[r][nc], 1});
						}
					}
					visited[nc] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean findHeight(int r, int c, int maxHigh) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[N];
		q.offer(new int[] { r, map[r][c], 1 });
		visited[r] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			int high = cur[1];
			int len = cur[2];
			if ((r == 0 || r == N - 1) && high != maxHigh) {
				if (len < X) {
					return false;
				}
			}
			for (int i = 0; i < 2; i++) {
				int nr = r + dir[i];
				if (nr > -1 && nr < N && !visited[nr]) {
					if (Math.abs(high - map[nr][c]) >= 2) {
						return false;
					}
					if (high == map[nr][c]) {
						q.offer(new int[] { nr, map[nr][c], len + 1 });
					} else if (high - 1 == map[nr][c]) {
						if (high != maxHigh && len < X) {
							return false;
						}
						q.offer(new int[] { nr, map[nr][c], 1 });
					} else if(high + 1 == map[nr][c]) {
						if(len < X * 2) {
							return false;
						}
						if(nr == 0 || nr == N - 1) {
							q.offer(new int[] {nr, map[nr][c], len});
						} else {
							q.offer(new int[] {nr, map[nr][c], 1});
						}
					}
					visited[nr] = true;
				}
			}
		}

		return true;
	}
}
